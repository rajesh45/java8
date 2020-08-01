package streamConcept;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamOperationsCollectingListSet {		
	
	private static void collectToCollection(List<Book> books) {
		System.out.println("\nIn collectToCollection ...");
		List<Book> list1 = books.stream()
			.filter(b -> b.getRating() >= 4.5)
			.distinct()
			.collect(ArrayList::new,
					ArrayList::add,
					ArrayList::addAll);
			//.collect(Collectors.toList());
		System.out.println("list1.size: " + list1.size());
		
		Set<Book> set1 = books.stream()
				.filter(b -> b.getRating() >= 4.5)
				.collect(Collectors.toSet());
		System.out.println("set1.size: " + set1.size());
		
		TreeSet<Book> set2 = books.stream()
				.filter(b -> b.getRating() >= 4.5)
				.collect(Collectors.toCollection(() -> new TreeSet()));
		System.out.println("set2.size: " + set2.size());
	}
			
	
	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
		
		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));
		
		collectToCollection(books);
	}
	
}