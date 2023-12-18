public class Homework06{
	public static void main(String[] args){
		Cale c = new Cale(1.9, 2.6);
		System.out.println(c.getAdd());
		System.out.println(c.getSub());
		System.out.println(c.getMul());
		System.out.println(c.getDiv());
		c.op2 = 0;
		System.out.println(c.getDiv());
	}
}


class Cale{
	double op1, op2;
	public Cale(double Operator1, double Operator2){
		this.op1 = Operator1;
		this.op2 = Operator2;
	}
	double getAdd(){
		return this.op1 + this.op2;
	}
	double getSub(){
		return this.op1 - this.op2;
	}
	double getMul(){
		return this.op1 * this.op2;
	}
	double getDiv(){
		if(this.op2 == 0){
			System.out.println("除数为0，不可除");
			return 0;
		}else{
			return this.op1/this.op2;
		}
	}
}