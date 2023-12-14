/*
	7.输出小写的a-z以及大写的Z-A
*/
public class Homework06{
	public static void main(String[] args){
		int cnt = 0;
		for(char ch = 'a'; ch < 'z'; ch++){
			System.out.print(ch);
			System.out.print('\t');
			cnt++;
			if(cnt == 5){
				System.out.println();
				cnt = 0;
			}
		}
		cnt = 0;
		for(char ch = 'A'; ch < 'Z'; ch++){
			System.out.print(ch);
			System.out.print('\t');
			cnt++;
			if(cnt == 5){
				System.out.println();
				cnt = 0;
			}
		}
	}
}