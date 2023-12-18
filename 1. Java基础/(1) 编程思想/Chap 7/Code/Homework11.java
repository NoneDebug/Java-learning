public class Homework11{
	public static void main(String[] args){
		MyTool mt = new MyTool();
		System.out.println(mt.method(mt.method(10.0, 20.0),100));
	}
}


class MyTool{
	public double method(double a, double b){
		return a > b? a : b;
	}
}