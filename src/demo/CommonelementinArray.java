package demo;

import java.util.ArrayList;

public class CommonelementinArray {

	public static void main(String[] args) {
		int j=0,k=0;
	       // int [] newresult=new newresult[5];
	       
	       ArrayList listresult=new ArrayList(5);
	        // your code goes here
	        int array1[]={1,2,3,4,5};
	        int array2[]={1,2,5,7,9};//
	        int array3[]={1,3,4,5,8};
	        
	        for(int i=0;i<array1.length;i++){
	            if(array1[i]==array2[j]){
	                if(array2[j]==array3[k]){
	                   listresult.add(array1[i]);
	                   j++;
	                   k++;
	                }
	                if (array1[i]>=array2[j]){
	                j++;
	                }
	                
	                if (array2[j]>=array3[k]){
	                k++;
	                }	                
	            }
	            
	        }     
	        
	        listresult.stream().forEach(System.out::println);
	        
	    
	        
	    }
	}
