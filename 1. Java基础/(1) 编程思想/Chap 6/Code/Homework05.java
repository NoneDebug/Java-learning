/*
�������10������(1_100�ķ�Χ)���浽����,
�������ӡ�Լ���ƽ��ֵ�������ֵ�����ֵ���±ꡢ�����������Ƿ���8
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
		System.out.println("ƽ��ֵΪ��" + avg);

		if(index != -1){
			System.out.println("��8����Ӧ�±�Ϊ: " + index);
		}else{
			System.out.println("û��8 ");
		}

		System.out.println("���ֵ�±�Ϊ�� " + max_i + "\t" + "���ֵΪ��" + max);
		System.out.println("��Сֵ�±�Ϊ�� " + min_i + "\t" + "��СֵΪ��" + min);
	}
}