public class Homework04{
	public static void main(String[] args){
		
		int invertNum = 23;
		boolean flag = false;
		int[] array = {10, 12, 45, 90};
		int[] temparray = new int[array.length + 1];
		int j = 0;
		for(int i = 0; i < temparray.length; i++){
			if(invertNum < array[j] && flag == false){
				temparray[i] = invertNum;
				flag = true;
			}else{
				temparray[i] = array[j];
				j++;
			}
		}
		array = temparray;
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + "\t");
		}
	}
}