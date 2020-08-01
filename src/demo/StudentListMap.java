package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentListMap {

	public static void main(String[] args) {
		List<Student> acct=new ArrayList<>();
		
		//Student s1=new Student();
		/*Map<String,Object> map=new HashMap<String, Object>();
		map.put("1001", s1);*/
		
		
		
		/*List<Map<String,Object>> result= new ArrayList<Map<String,Object>>();
		result.add(map);
		System.out.println(result);
		*/
		/*acct=result.stream().map(m->{
			//,.acct.//Student acct1=new Student();
			//acct1.setId(Integer.parseInt(String.valueOf(m.get("id"))));
			acct1.setSubject(String.valueOf("subject"));
			//System.out.println(acct1);
			return acct1;
		}).collect(Collectors.toList());
		*/
		System.out.println(acct.isEmpty());		
	}
	
		
	}
