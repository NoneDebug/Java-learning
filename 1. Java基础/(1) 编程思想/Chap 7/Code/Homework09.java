public class Homework09{
	public static void main(String[] args){
		Music ms = new Music();
		ms.name = "Shake it off";
		ms.times = 219;
		ms.showInfo();
		ms.play(76);
		ms.showInfo();
	}
}


class Music{

	String name;
	int times;

	public void play(int playTime){
		if(this.times > playTime){
			this.times -= playTime;
			System.out.println("������" + playTime + "s");
		}else{
			System.out.println("��������");
		}
		
	}

	public void showInfo(){
		System.out.println("������" + this.name);
		System.out.println("ʣ�ࣺ" + this.times + "s");
	}

}