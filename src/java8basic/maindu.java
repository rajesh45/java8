package java8basic;

abstract class P{
	P(){
		System.out.println("default"+this.hashCode());
	}
}


class C extends P{
	C(){
		System.out.println(this.hashCode());
		
	}
}
public class maindu {
	public static void main(String[] args) {
		C c=new C();
		
				
	}
}
