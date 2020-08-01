package streamConcept;

import static java.util.stream.Collectors.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOperationsGroupingBy {
	
	private static void collectToMap(List<Book> books) {
		System.out.println("\nIn collectToMap ...");
		Map<Long, Book> map = books.stream()
			//.collect(Collectors.toMap(b -> b.getIsbn(), b -> b));
			.collect(Collectors.toMap(b -> b.getIsbn(), b -> b, (b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2));
		for (Entry<Long, Book> entry : map.entrySet()) {
			System.out.println("isbn: " + entry.getKey() + ", book: " + entry.getValue());
		}
		
		System.out.println(map instanceof HashMap);
		
		Map<Long, Book> treeMap = books.stream()
				//.collect(Collectors.toMap(b -> b.getIsbn(), b -> b));
				//.collect(Collectors.toMap(Book::getIsbn, Function.identity(), (b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2, () -> new TreeMap()));
				.collect(Collectors.toMap(Book::getIsbn, Function.identity(), BinaryOperator.minBy(Comparator.comparingDouble(Book::getPrice))));
			for (Entry<Long, Book> entry : treeMap.entrySet()) {
				System.out.println("isbn: " + entry.getKey() + ", book: " + entry.getValue());
			}
		
			/*Map<Double, List<Book>> ratingsMap = treeMap.values().stream()
				.collect(Collectors.toMap(Book::getRating, b -> Collections.singletonList(b), (l1, l2) -> { ArrayList<Book> l = new ArrayList<>(l1);
																				l.addAll(l2);
																				return l;}));
			for (Entry<Double, List<Book>> entry : ratingsMap.entrySet()) {
				System.out.println("\nRating: " + entry.getKey());
				for (Book b : entry.getValue()) {
					System.out.println(b);
				}
			}*/
			
			System.out.println("\ngroupingBy with values as List ... ");
			Map<Double, List<Book>> ratingsMap1 = treeMap.values().stream()
					.collect(Collectors.groupingBy(Book::getRating));
			for (Entry<Double, List<Book>> entry : ratingsMap1.entrySet()) {
				System.out.println("\nRating: " + entry.getKey());
				for (Book b : entry.getValue()) {
					System.out.println(b);
				}
			}
			
			System.out.println("\ngroupingBy with values as Set ... ");
			Map<Double, Set<Book>> ratingsMap2 = treeMap.values().stream()
					.collect(Collectors.groupingBy(Book::getRating, TreeMap::new, toSet()));
			for (Entry<Double, Set<Book>> entry : ratingsMap2.entrySet()) {
				System.out.println("\nRating: " + entry.getKey());
				for (Book b : entry.getValue()) {
					System.out.println(b);
				}
			}
			
			Map<Double, Map<String, List<Book>>> multiLevelMap = treeMap.values().stream()
					.collect(Collectors.groupingBy(Book::getRating, Collectors.groupingBy(Book::getSource, toList())));
			System.out.println("\nmultiLevelMap: " + multiLevelMap);
			
			Map<Double, Long> ratingsCountMap = treeMap.values().stream()
					.collect(Collectors.groupingBy(Book::getRating, Collectors.counting()));
			System.out.println("\nratingsCountMap: " + ratingsCountMap);
			System.out.println("\ncount: " + treeMap.values().stream().collect(Collectors.counting()));
			
			Map<Double, Double> ratingsAvgPriceMap = treeMap.values().stream()
					.collect(Collectors.groupingBy(Book::getRating, Collectors.averagingDouble(Book::getPrice)));
			System.out.println("\nratingsAvgPriceMap: " + ratingsAvgPriceMap);
			
			Map<Double, Optional<Book>> ratingsMinPriceMap = treeMap.values().stream()
					.collect(Collectors.groupingBy(Book::getRating, Collectors.minBy(Comparator.comparingDouble(Book::getPrice))));
			System.out.println("\nratingsMinPriceMap: " + ratingsMinPriceMap);
			
			Map<Double, DoubleSummaryStatistics> ratingsSummaryMap = treeMap.values().stream()
			.collect(Collectors.groupingBy(Book::getRating, Collectors.summarizingDouble(Book::getPrice)));
			System.out.println("\nDoubleSummaryStatistics: " + ratingsSummaryMap);
			
			Map<Boolean, List<Book>> partitionedMap = treeMap.values().stream()
					.collect(Collectors.partitioningBy(b -> b.getRating() >= 4.5));
			System.out.println("\npartitionedMap: " + partitionedMap);
			
			//System.out.println("\ngroupingBy with values as List ... ");
			Map<Double, List<String>> ratingsTitleMap = treeMap.values().stream()
					.collect(Collectors.groupingBy(Book::getRating, Collectors.mapping(Book::getTitle, toList())));
			System.out.println("\nratingsTitleMap: " + ratingsTitleMap);
	}
	
public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
		
		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));
		
		
		
		collectToMap(books);
		
	}	
		
}


