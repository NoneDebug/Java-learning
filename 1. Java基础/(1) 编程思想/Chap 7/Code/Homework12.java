public class Homework12{
	public static void main(String[] args){
		Employee e1 = new Employee("马云", '男', 23, "程序员", 23333.9);
		Employee e2 = new Employee("董明珠", '女', 22);
		Employee e3 = new Employee("公务员", 15233.6);
	}
}

class Employee{
	String name;
	char gender;
	int age;
	String pos;
	double sal;
	public Employee(String pName, char pGender, int pAge,
					String pPos, double pSal){
		this(pName, pGender, pAge);
		this.pos = pPos;
		this.sal = pSal;
	}
	public Employee(String pName, char pGender, int pAge){
		this.name = pName;
		this.gender = pGender;
		this.age = pAge;
	}
	public Employee(String pPos, double pSal){

		this.pos = pPos;
		this.sal = pSal;
	}
}