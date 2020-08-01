package demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	public static void main(String agrs[]) {
	ArrayList<String> strings = new ArrayList<String>();
	strings.add("1 | Computers | 45");
	strings.add("2 | Computers | 48");
	strings.add("2 | Data Structures | 89");
	strings.add("33 | English | 35");
	strings.add("24 | Maths | 70");
	strings.add("15 | Computers | 58");
	strings.add("6 | Data Structures | 55");
	strings.add("7 | English | 40");
	strings.add("18 | Maths | 73");
	
	/*Student s1=new Student(1,"computerScience",48);
	Student s2=new Student(2,"math",48);
	Student s3=new Student(1,"science",48);
	Student s4=new Student(3,"biology",48);
	
	ArrayList<Student>studentList=new ArrayList<Student>();
	studentList.add(s1);
	studentList.add(s2);
	studentList.add(s3);
	studentList.add(s4);*/
	List<Student> results = new ArrayList<Student>();
	for (String s : strings){
	    String[] sa = s.split(" \\| ");
	    results.add(new Student(Integer.parseInt(sa[0]), sa[1], Integer.parseInt(sa[2])));
	}
	
	Map<String, Object> map = results.stream()
	        .collect(Collectors.groupingBy(Student::getSubject, 
	                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getMarks)), 
			r -> r.get().getId())));
	
	System.out.println(map);
	
	/*//System.out.println(strings);
	ArrayList<Student> sam = new ArrayList<Student>();
	//String [] sam= new String[3];
	for (String str : strings) {
	    String [] strArray = str.split("\\|");
	    //System.out.print(strArray.length);
	    // in completed code 
	    for (int i = 0; i < str.length(); i++) {
	        // sam.add(strArray[0],strArray[1], strArray[2]);
	       // s.add(strArray[1]);
	   // }
	}


}*/
}
}


