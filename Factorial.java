class Factorial
{
  public static void main(String[] args)
  {

//     Factorial.fact2(1);
	
	for ( int i = 5 ; i <=14 ; i++)
		System.out.println(Factorial.fact3(i));
   }
   public static void fact(int num){
    	int res = 1;
    	for( int i = 1 ; i <= num ; i++)
    	{
    		res = res * i ;
    		System.out.println("Factorial of "+i+"  = " +res);
    	}
   }
   public static void fact2(int num){
   
 	int res= 1 ;
 	while (num <= 10)
 	{
 		res = res * num;
 		System.out.println("Factorial of "+num+"  = " +res);
 		num ++;
 	}
   }
   
   // using recursive function
   public static int fact3(int num)
   {
   	if ( num == 0 )
   		return 1;
   	else{
   		return num * fact3(num-1);
   	}
   }
 }
 
 
 // javac --release 8 Factorial.java
