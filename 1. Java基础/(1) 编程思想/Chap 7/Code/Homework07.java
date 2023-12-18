public class Homework07{
	public static void main(String[] args){
		Dog d = new Dog("Snoopy", "yellow", 2);
		d.showInfo();
	}
}

class Dog{
	String name;
	String color;
	int age;

	public Dog(String dName, String dColor, int dAge){
		this.name = dName;
		this.color = dColor;
		this.age = dAge;
	}

	public void showInfo(){
		System.out.println("该狗名为：" + this.name);
		System.out.println("该狗颜色为：" + this.color);
		System.out.println("该狗年龄：" + this.age);
	}
}