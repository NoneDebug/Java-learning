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
			System.out.println("播放了" + playTime + "s");
		}else{
			System.out.println("播放完了");
		}
		
	}

	public void showInfo(){
		System.out.println("歌名：" + this.name);
		System.out.println("剩余：" + this.times + "s");
	}

}