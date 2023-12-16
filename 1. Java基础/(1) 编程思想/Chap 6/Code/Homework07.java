public class Homework07{
	public static void main(String[] args){
		int NUM = 10;
		int[] arr = new int[NUM];
		int len = arr.length;
		for(int i = 0; i < len; i++){
			arr[i] = (int)(Math.random() * 100) + 1;
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		int temp = 0;
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len - 1 - i; j++){
				if(arr[j] > arr[j + 1]){
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for(int i = 0; i < len; i++){
			System.out.print(arr[i] + "\t");
		}
	}
}