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
		System.out.println("�ù���Ϊ��" + this.name);
		System.out.println("�ù���ɫΪ��" + this.color);
		System.out.println("�ù����䣺" + this.age);
	}
}