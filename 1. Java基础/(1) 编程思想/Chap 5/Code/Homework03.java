
/*
	3.�ж�һ������Ƿ�Ϊ���� Homework03.java	
*/

import java.util.Scanner;
public class Homework03{
	public static void main(String[] args){
		int year = 1700;
		if( year % 4 == 0){
			if( year % 100 == 0){			
				if(year % 400 == 0){
					System.out.println("������");
				}else{
					System.out.println("��������");
				}
			}
			else{
				System.out.println("������");
			}
		}else{
			System.out.println("��������");
		}

	}
}