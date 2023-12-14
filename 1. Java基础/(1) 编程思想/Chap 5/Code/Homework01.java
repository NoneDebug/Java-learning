/*
编程实现如下功能
1)某人有100,000元,每经过一次路口，需要交费,规则如下:1)当现金>50000时,每次交5%
2)当现金<=50000时每次交1000编程计算该人可以经过多少次路口,要求: 使用 while break方式完成
*/
public class Homework01{
	public static void main(String[] args){
		double money = 100000;
		int cnt = 0;
		while( true ){
			if(money <= 1000){
				break;
			}
			if (money > 50000){
				money -= money * 0.05;
				cnt++;
			}else if(money <= 50000){
				money -= 1000;
				cnt++;
			}
		}
		System.out.println("该人通过 " + cnt + " 次路口");
	}
}

