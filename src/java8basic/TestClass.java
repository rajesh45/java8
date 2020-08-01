package java8basic;


public class TestClass {
    private int i;
    TestClass(int i) {
        i = 43;
    }
    public int getInt() {return i;}
    public static void main(String args[]) {
        TestClass t = new TestClass(42);
        System.out.println("" + t.getInt());
    }
}