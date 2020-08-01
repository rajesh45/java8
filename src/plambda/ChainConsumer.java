package plambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumer {

	public static void main(String[] args) {
		List<String> strings= Arrays.asList("one","two","three","four","five");
		
		List<String> result= new ArrayList<String>();
		
		Consumer<String> c1= System.out::println;
		
		Consumer<String> c2= result::add;
		System.out.println(result.size());
		
		strings.forEach(c1.andThen(c2)); //after c1 is calculated then the result is passed to c2
		
		System.out.println(result.size());

	}

}
