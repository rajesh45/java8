package lambdaExample;

import java.util.ArrayList;
import java.util.List;

import java8basic.Bookmark;


/*abstract class Test {
	abstract void apply();	
}*/

interface Test {
	void apply();	
}

public class ClosureAndVariableDemo {		
	private Bookmark[] items;	
	private int next = 0;
	
	public ClosureAndVariableDemo(int size) { 
    	items = new Bookmark[size]; 
    }
    
        
    public static void main(String[] args) {
		
		
		new ClosureAndVariableDemo(5).go(() -> System.out.println("\nLambda"));		
	}
    
    // 2. Mutating it is not thread-safe
    static int global = 0; 
    
    public static void go(Test test) {
		test.apply();
		
		// 1. count is effectively final (Capturing variables)
		int count = 0;
		
		// 3. Trick & Mutating object is fine. 
		List<Integer> trick = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			
			//closure
			new Thread(() -> System.out.println(count)).start();
			 //new Thread(() -> System.out.println(count++)).start();
			
			// 2. Accessing field ~ Not thread safe 
			new Thread(() -> System.out.println(global++)).start();
			
			new Thread(() -> {
				trick.add(count);
				int temp = trick.get(0);
				trick.set(0, temp++);
			}).start();
			
			// 4. No local variable shadowing
			//Consumer<Integer> consumer = count -> {};
			//Consumer<Integer> consumer = c -> { int count = 2;};
						
			// 5. Refresher for Anonymous Classes: 
			new Thread(new Runnable() {
				public void run() {
					//count++; // same as lambda
					int count = 2; // Can shadow local variable
				}
			}).start();
			
			// 6. this reference in lambda is this reference of the enclosed method
			//new Thread(() -> System.out.println(this.global)).start();
		}
	}
    
}
