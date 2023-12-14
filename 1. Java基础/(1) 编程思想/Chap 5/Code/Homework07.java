/*
	8.求出1-1/2+1/3-1/4.....1/100的和
*/
public class Homework07{
	public static void main(String[] args){
		double sum = 0;
		for(int i = 1; i <= 100; i++){
			if( i % 2 != 0){
				sum += 1.0/i;
			}else{
				sum -= 1.0/i;
			}
		}
		System.out.println("The sum of 1-1/2+1/3-1/4.....1/100 is " + sum);
	}
}