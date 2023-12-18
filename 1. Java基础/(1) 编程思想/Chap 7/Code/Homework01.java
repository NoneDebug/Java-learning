public class Homework01{
	public static void main(String[] args){
		double[] a = {1.2, 2.3, 411.2, -908};
		MyTool mt = new MyTool();
		System.out.println(mt.max(a));
	}
}


class MyTool{
	public double max(double[] array){
		double maxArray = array[0];
		for(int i = 1; i < array.length; i++){
			if(maxArray < array[i]){
				maxArray = array[i];
			}
		}
		return maxArray;
	}
}