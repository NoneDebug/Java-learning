/*
	2.实现判断一个整数，属于哪个范围: 大于0;小于0;
	等于0
*/
import java.util.Scanner;
public class Homework02{
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);
		int integ;	
		System.out.println("请输入一个整数");
		integ = myScanner.nextInt();
		if(integ > 0){
			System.out.println("大于0");
		}else if(integ < 0){
			System.out.println("小于0");
		}else{
			System.out.println("等于0");
		}

	}
}