/*
4.判断一个整数是否是水仙花数，所谓水仙花数是指
一个3位数，其各个位上数字立和等于其本身。
例如: 153 =1*1*1 + 3*3*3 + 5*5*5
*/
public class Homework04{
	public static void main(String[] args){
		for(int i = 100; i < 1000; i++){
			int a = i / 100;
			int b = i / 10 % 10;
			int c = i % 10;
			if(a * a * a + b * b * b + c * c * c == i){
				System.out.println(i + "是水仙花数");
			}
		}

	}
}