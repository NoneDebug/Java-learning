/*
随机生成10个整数(1_100的范围)保存到数组,
并倒序打印以及求平均值、求最大值和最大值的下标、并查找里面是否有8
*/

public class Homework05{
	public static void main(String[] args){
		int[] arr = new int[10];
		int len = arr.length;
		for(int i = 0; i < len; i++){
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		int max_i = len - 1, min_i = len - 1;
		int max = arr[len - 1], min = arr[len - 1], index = -1;
		double avg = 0;
		for(int i = len - 1; i >= 0; i--){
			System.out.print(arr[i] + "\t");
			if(max < arr[i]){
				max_i = i;
				max = arr[i];
			}
			if(min > arr[i]){
				min_i = i;
				min = arr[i];
			}
			if(arr[i] == 8){
				index = i;
			}
			avg += arr[i];
		}
		System.out.println();
		avg /= arr.length;
		System.out.println("平均值为：" + avg);

		if(index != -1){
			System.out.println("有8，对应下标为: " + index);
		}else{
			System.out.println("没有8 ");
		}

		System.out.println("最大值下标为： " + max_i + "\t" + "最大值为：" + max);
		System.out.println("最小值下标为： " + min_i + "\t" + "最小值为：" + min);
	}
}