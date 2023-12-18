public class Homework05{
	public static void main(String[] args){
		Circle c = new Circle(3);
		System.out.println("周长为:" + c.getPerimeter());
		System.out.println("面积为:" + c.getArea());

	}
}


class Circle{
	
	double r;

	public Circle(double radius){
		this.r = radius;
	}

	public double getPerimeter(){
		double radius = this.r;
		return 2 * radius * Math.PI;
	} 
	public double getArea(){
		double radius = this.r;
		return radius * radius * Math.PI;
	}

}