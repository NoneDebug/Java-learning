
/*
	3.判断一个年份是否为闰年 Homework03.java	
*/

import java.util.Scanner;
public class Homework03{
	public static void main(String[] args){
		int year = 1700;
		if( year % 4 == 0){
			if( year % 100 == 0){			
				if(year % 400 == 0){
					System.out.println("是闰年");
				}else{
					System.out.println("不是闰年");
				}
			}
			else{
				System.out.println("是闰年");
			}
		}else{
			System.out.println("不是闰年");
		}

	}
}