public class Homework13{
	public static void main(String[] args){
		Circle c = new Circle();
		PassObject po = new PassObject();
		po.printAreas(c, 5);
	}
}


class Circle{
	double radius;
	public double findArea(){
		return Math.PI * radius * radius;
	}
}

class PassObject{
	public void printAreas(Circle c, int times){
		System.out.println("Radius\t" + "Area");
		for(int i = 1; i <= times; i++){
			c.radius = i;
			System.out.println(c.radius + "\t" + c.findArea());
		}
	}
}