class Homework10{
	public static void main(String[] args){
		Demo d1 =new Demo();
		Demo d2 = d1;
		d2.m();
		System.out.println(d1.i);
		System.out.println(d2.i);
		//输出结果为：
		//i=100
		//j=100
		//101
		//101
	}
}



class Demo{
	int i=100;	
	public void m() {
		int j=i++;
		System.out.println("i="+i);
		System.out.println("j="+j);
	}
}
