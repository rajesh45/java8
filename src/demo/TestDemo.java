package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TestDemo {

	public static void main(String[] args) {
		List<Integer> num = new ArrayList<>(); 
        num.add(1); 
        num.add(2); 
        num.add(3); 
        num.add(4); 
        num.add(5); 
        num.remove(2); 
        num.add(4); 
        System.out.println(num);
        
        String s="programming|in|java|interview";
        List<String> testList = Arrays.asList("programming","in", "java", "interview");
        //List<String> testList2=testList.stream().map(i->).collects(Collector.sp);
        /*List<String> testList2=*/StreamSupport.stream(testList.spliterator(),false).forEach(argslist->{System.out.println(argslist);});//collect(Collectors.toList());//testList.stream().
        //System.out.println(testList2);
        //testList.stream().spliterator()
        
        
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        
        Integer min=primes.stream().min((i1,i2) -> i1.compareTo(i2)).get();
        Integer max=primes.stream().max((i1,i2) -> i1.compareTo(i2)).get();
        System.out.println(min);
        System.out.println(max);
        
        List<String> myList = Arrays.asList("Harry", "", "Gary", "Tony", "", "is", "cool");
        long myListresult= myList.stream().filter(t->t.isEmpty()).count();
        System.out.println(myListresult);
        
        
        

	}

}
