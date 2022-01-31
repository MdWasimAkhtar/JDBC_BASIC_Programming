import java.util.*;

class Find_Duplicate_Element_Arrays
{
    public static void main(String[] aa)
    {
//    	duplicate_elements();
	duplicate_elements3();
    }
    
    public static void duplicate_elements(){
    
    	String[] arr = {"Amazon","TATA","TCS","a","Flipkart","89912","CocaCola","a","Amazon","889912","Oracle","TATA","Shilpa","Wasim","Shilpa"};
    	
    	System.out.println("Using brute force method ");
    	
    	for(int i = 0 ; i < arr.length ; i++)
    	{
    	   for ( int j = i+1 ; j < arr.length ; j++)
    	       {
    	 		if (arr[i] == arr[j]) {
    	 		System.out.println(arr[j]); 
    	 		break;
    	 		}      
    	        }
    	}
  }
    	
    	public static void duplicate_elements2(){
    	
    	     System.out.println("Using hasset ");
    	     String[] arr = {"Amazon","TATA","TCS","a","Flipkart","89912","CocaCola","a","Amazon","889912","Oracle","TATA","Shilpa","Wasim","Shilpa"};
    	
    	Set<String> set1 = new HashSet<String>();
    	
    	for( String i : arr){
    		if(set1.add(i) == false){
    		  System.out.println(i);
    		}
    	}
    	      	
   }
   
   public static void duplicate_elements3(){
   	System.out.println("using HashMap");
   	String[] arr = {"Amazon","TATA","TCS","a","Flipkart","89912","CocaCola","a","Amazon","889912","Oracle","TATA","Shilpa","Wasim","Shilpa"};
    	
    	Map<String,Integer> map1 = new HashMap<String, Integer>();
    	
    	for( String i : arr)
    	{
    		if(map1.containsKey(i))
    			map1.put(i,map1.get(i)+1);
    		else
    		    map1.put(i,1);
    	}
    	
    	for(Map.Entry<String,Integer> entry : map1.entrySet()){
    		
    		if(entry.getValue() >1)
    		System.out.println(entry.getKey()+"  : "+entry.getValue());
    	
    	} 
   }
    
 }
