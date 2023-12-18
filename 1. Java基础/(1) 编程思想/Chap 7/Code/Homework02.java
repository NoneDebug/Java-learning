public class Homework02{
	public static void main(String[] args){
		String[] strArr = {"三国演艺", "红楼梦", "水浒传", "西游记"};
		A02 tool = new A02();
		if(tool.find("三国演义", strArr) != -1){
			System.out.println(true);
		}else{
			System.out.println(false);
		}
	}
}


class A02{

	public int find(String findStr, String[] strArr){
		int res = -1;
		for(int i = 0; i < strArr.length; i++){
			if(findStr.equals(strArr[i])){
				return i;
			}				
		}
		return -1;
	}
}