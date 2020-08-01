package streamConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamOperationsReduce {		
	
	// if accumulator mutates, use collect(). Otherwise, use reduce()
		private static void mutableReduction() {
			System.out.println("\nmutableReduction ... ");
			String[] grades = {"A", "A", "B"};
			
			StringBuilder concat2 = Arrays.stream(grades).parallel()
					/*.collect(() -> new StringBuilder(), 
							(sb, s) -> sb.append(s),
							(sb1, sb2) -> sb1.append(sb2));*/
					.collect(StringBuilder::new, 
							StringBuilder::append,
							StringBuilder::append);
			System.out.println("concat2: " + concat2);
			
			/*String concatWithJoining = Arrays.stream(grades).parallel()
					.collect(joining());
			System.out.println("concatWithJoining: " + concatWithJoining);*/
		}
		
		static void overloadedReductions() {
			System.out.println("\noverloadedReductions ... ");
			
			String[] grades = {"A", "A", "B"};
			
			// Stream API: Design Principle!!!
			// API does not differentiate between sequential & parallel streams
			String concat1 = Arrays.stream(grades)
				.reduce("", (s1, s2) -> s1 + s2);
			System.out.println("concat1: " + concat1);
			
			// Single instance of container is used + 
			//                SB is not thread-safe + 
			//                combiner redundantly combines
			StringBuilder concat2 = Arrays.stream(grades).parallel()
			.reduce(new StringBuilder(), 
					(sb, s) -> sb.append(s),
					(sb1, sb2) -> sb1.append(sb2));
					//null);
			System.out.println("concat2: " + concat2);
			
			
			// Not efficient: Each accumulation step creates a new StringBuilder
			StringBuilder concat3 = Arrays.stream(grades).parallel()
					.reduce(new StringBuilder(), 
							(sb, s) -> new StringBuilder().append(sb).append(s),
							(sb1, sb2) -> sb1.append(sb2));						
					System.out.println("concat3: " + concat3);
									
		}
		
		// Limitations:
		//   1. Cumbersome
		//   2. Parallelizing is painful
		//   3. Synchronizing shared mutable variable is expensive
		private static void reduceImperatively(List<Book> books) {
			System.out.println("\nReducing imperatively ...");
			Book result = null;
			
			for (Book book : books) {
				// Initialize result with first book having rating >= 4.5
				if (result == null) {
					if (book.getRating() >= 4.5) {
						result = book;
					}				
					continue;
				}
				
				if (book.getRating() >= 4.5 && result.getPrice() > book.getPrice()) {
					result = book;
				}
			}
			
			System.out.println("(Imperative) Lowest priced book with rating >= 4.5: " + result);
			
		}	
			
		// Find the lowest priced book with a rating >= 4.5
		private static void reduce(List<Book> books) {
			System.out.println("\nReduce ...");
			books.stream()
				.filter(b -> b.getRating() >= 4.5)
				.reduce((b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2)
				.ifPresent(b -> System.out.println("Lowest priced book: " + b));				
		}
		
			
	
	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
		
		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));
		
		reduce(books);
		reduceImperatively(books);
		overloadedReductions();	
		mutableReduction();
	}
	
}