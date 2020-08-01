package java8basic;

public class TestJava8DefaultMethod implements A,B {

	public static void main(String[] args) {
		B test= new TestJava8DefaultMethod();
		test.show();
	}

	@Override
	public void show() {
		System.out.println("Interface Main Called");
	}
	
}
interface A{
	default void show(){
		System.out.println("Interface A Called");
	}
}
interface B{
	default void show(){
		System.out.println("Interface B Called");
	}
}
/*class C implements A, B {
	A a = new C();

	@Override
	public void show() {
		// TODO Auto-generated method stub
		A.super.show();
	}
	
}*/
	





