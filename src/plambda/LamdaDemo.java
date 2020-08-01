package plambda;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;

public class LamdaDemo {

	public static void main(String[] args) {		
		/*FileFilter filter =new FileFilter(){
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}			
		};*/
		FileFilter filterlambda =(File pathname) -> 
		pathname.getName().endsWith(".java");
		
		
		File dir= new File("C:/workspace/java8/java8basic/src/demo");
		File [] files=dir.listFiles(filterlambda);
		 for(File f:files) {
			 System.out.println(f);			 
		 }
	}

}
