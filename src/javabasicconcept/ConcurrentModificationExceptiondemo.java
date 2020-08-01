package javabasicconcept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;




/*
 * the whole concept of concurrentmodificationException is don't change(add new element or delete element ) 
 * the size the the list or map you are iteration.
 * 
 * 
 */
public class ConcurrentModificationExceptiondemo {


	public static void main(String args[]) {
		List<String> myList = /*new CopyOnWriteArrayList<>();*/new ArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			
			if (value.equals("3"))
				it.remove();
			System.out.println("List Value:" + value);
		}

		Map<String, String> myMap = new ConcurrentHashMap<String, String>();// new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				//myMap.remove("3");
				myMap.put("1", "4");
				// myMap.put("4", "4");
			}
		}

	}
}
