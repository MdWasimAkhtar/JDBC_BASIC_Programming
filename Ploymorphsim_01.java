/*
A person at the same time can have different characteristics. Like a man at the same time is a father, a husband, an employee. So the same person possesses different behavior in different situations. This is called polymorphism. 
Polymorphism is considered one of the important features of Object-Oriented Programming. Polymorphism allows us to perform a single action in different ways. In other words, polymorphism allows you to define one interface and have multiple implementations. The word “poly” means many and “morphs” means forms, So it means many forms.

Types of polymorphism

In Java polymorphism is mainly divided into two types: 

Compile-time Polymorphism
Runtime Polymorphism
Type 1: Compile-time polymorphism

It is also known as static polymorphism. This type of polymorphism is achieved by function overloading or operator overloading. 

Note: But Java doesn’t support the Operator Overloading.
*/

class  Helper
{
	static int Multiply(int a , int b){
		System.out.println("Int ");
		return a*b;
	}
	
	static double Multiply(double a , double b ){
		return a * b ;
	}
	
	public void add(int a , int b)
	{
	   System.out.println(a+b);
	}
	public void add(int a , double b){
		System.out.println(a+b);
	}
	public static void main(String[] aa){
		System.out.println(Helper.Multiply(23,56));
		System.out.println(Helper.Multiply(90.90,89));
	}
}

/*
It is also known as Dynamic Method Dispatch
 It is a process in which a function call to the overridden method is resolved at Runtime. This type of polymorphism is achieved by Method Overriding. Method overriding, on the other hand, occurs when a derived class has a definition for one of the member functions of the base class. That base function is said to be overridden.

	return of overloading method should be same and also modifier
	
error: method add(int,int) is already defined in class Base1
	public int  add(int a , int b ){

*/
class Base1
{
	int x = 100;
	public  void add(double x , int y){
		System.out.println("final : "+x+y);
	}
	
	public void add(int a , int b){
		System.out.println(a+b);
	}
	
	public static  int  add(int a , int b ,int c  ){
		System.out.println("int a , int b");
		return a+b+c;
	}
	
}
class Drived extends Base1
{
	public void add(int a, int b){
		int x = 900;
		System.out.println("drived class");
		System.out.println(a+b+x);
	}
	public final void add(double x , int y){
		double d = 100;
		System.out.println("final drived class : "+x+y+d);
	}

}
/*
In Overriding Method Resolution is always takes care by JVM at runtime based on Object Type (Based on Runtime Objects);
lateBinding , Dynamic Binding , 

Method Name Must be same and Arguments Type including Order of arguments
Method signature must be same , Return Type must be same untill java1.4 , for Object type we can Apply Its child class as Return Type
Object ------String/StringBuffer/
Number ----Integer/Float/Double/Short/Long


private|||default<protected<public

same Private Method with same Name is valid , but not overriding 
private Method is not visible to child class ,

rule is we can't reduce the scope , we can incread the scope

Final Method 
if the parent class Method is decalred as Final , Overriding is not possible 

But Non-Final to Final is Possible/allowed

abstract to non-abstract is applicable

non-abstract to abstract is applicable 
*/

class Overriding_
{
	public static void main(String[] aa){
		
		Base1 d1 = new Drived();
		System.out.println(Base1.add(10,10,10));
		d1.add(123.22,90);
		
		
	}
}


/*
if child class method throws any checked ex , compilsory parent class have to throws same ex or its parent 

P: void m1() throws Exception   yes            --- 
c: void m1()

P: void m1()            --- 
c: void m1 throws Exception ,,, CTE

P: void m1() throws Throwable           --- 
c: void m1 throws Exception 

P: void m1() throws Exception           --- 
c: void m1 throws IOException    yes Accpectable

P: void m1() throws IOException  in valid
c: void m1 throws Exception 

P: void m1() throws IOException
c: void m1 throws EOFException,FNFE  yes

P: void m1() throws Exception
c: void m1 throws Exception , T.E not valid

P: void m1() throws Exception
c: void m1 throws Exception , NPE ,,, for uncheched no restriction NPE is unchecked Ex
  

*/

/*
	static to non static 
	non-static to static   Not Possible
Object level method to class Level method 

if both method are static valid but it is method hiding 

in method hiding method resolution is always is takes care by Compiler based on refernece type




wrt var-args method
void m1(int...x)
void m1(int x)   will be Method Overloading 

*/

class P
{

public static void m1()
{
}

}

class C {

	public void m1(){
	
	}

}






