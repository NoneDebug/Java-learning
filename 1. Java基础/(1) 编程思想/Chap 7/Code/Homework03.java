public class Homework03{
	public static void main(String[] args){
		Book bk = new Book();
		bk.price = 233;
		System.out.println("ԭ�ۣ�" + bk.price);
		bk.updatePrice();
		System.out.println("�ּۣ�" + bk.price);		
		bk.price = 101;
		System.out.println("ԭ�ۣ�" + bk.price);
		bk.updatePrice();
		System.out.println("�ּۣ�" + bk.price);	

	}
}


class Book{
	int price;
	public void updatePrice(){
		if(this.price > 150){
			this.price = 150;
		}else if(this.price > 100){
			this.price = 100;
		}
	}

}