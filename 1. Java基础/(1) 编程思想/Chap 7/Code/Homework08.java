public class Homework08{
	public static void main(String args[]) {
		new Test().count1();
		Test t1= new Test();
		t1.count2();
		t1.count2();
	}
}
class Test {
	int count = 9;
	public void count1(){
		count=10;
		System.out.println("count1=" + count);
	}
	public void count2(){
		System.out.println("count1=" + count++);
	}
	//输出结果为：
	//count1=10
	//count1=9
	//count1=10
}
