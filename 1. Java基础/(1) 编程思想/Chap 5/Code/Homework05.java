
/*
	6.输出1-100之间的不能被5整除的数，每5个一行
*/
public class Homework05{
	public static void main(String[] args){
		int cnt = 0;
		for(int i = 1; i < 100; i++){
			if(i % 5 != 0){
				System.out.print(i);
				System.out.print('\t');
				cnt++;
			}
			if(cnt == 5){
				System.out.println();
				cnt = 0;
			}
		}
	}
}