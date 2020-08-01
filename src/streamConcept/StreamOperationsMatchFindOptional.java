package streamConcept;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamOperationsMatchFindOptional {		
	
	// findFirst needs more work in parallel env. Use findAny if it does the job.
	// java.util.Optional ~ 
	//     (a) to avoid dealing with null -- in case of find, 
	//     (b) to know if stream is empty -- in case of reduction operation
		private static void find(List<Book> books) {
			System.out.println("\nFinding ...");
			/*Optional<Book> result = */ books.stream()
				.filter(d -> d.getRating() >= 4.8 && d.getPrice() <= 50.0)
				.findAny().orElseGet(StreamOperationsMatchFindOptional::getDefault);
			Optional<Book> opt = Optional.ofNullable(books.get(0));
			System.out.println(opt.isPresent());
			
			/*if (result.isPresent()) {
				System.out.println(result.get());
			} else {
				System.out.println("not found!!!");
			}*/
			
		}
		
		private static void print(Book b) {
			System.out.println(b);			 
		}
		
		private static Book getDefault() {			
			System.out.println("default ...");
			return new Book(0, "", 4.0, 25.0, "Amazon");
		}
			
	
	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
		
		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));
		
		find(books);		
	}
	
}