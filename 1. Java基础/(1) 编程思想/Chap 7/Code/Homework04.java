public class Homework04{
	public static void main(String[] args){
		int[] Arr1 = {1, 1, 4, 5, 1, 4};
		int[] Arr2 = new int[Arr1.length];
		A03 tool = new A03();
		Arr2 = tool.copyArr(Arr1);
		for(int i = 0; i < Arr1.length; i++)
			System.out.print(Arr2[i] + "\t");
	}
}


class A03{
	
	public int[] copyArr(int[] oldArr){
		int[] newArr = new int[oldArr.length];
		for(int i = 0; i < oldArr.length; i++)
			newArr[i] = oldArr[i];
		return newArr;
	}

}