/*
	2.ʵ���ж�һ�������������ĸ���Χ: ����0;С��0;
	����0
*/
import java.util.Scanner;
public class Homework02{
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);
		int integ;	
		System.out.println("������һ������");
		integ = myScanner.nextInt();
		if(integ > 0){
			System.out.println("����0");
		}else if(integ < 0){
			System.out.println("С��0");
		}else{
			System.out.println("����0");
		}

	}
}