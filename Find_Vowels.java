class Find_Vowels
{
    public static void main(String[] aa)
    {
    	find_vowels();
    
    }
    
    public static void find_vowels(){
    	
    	String str = "Have a great Day ";
    	
    	str = str.toLowerCase();
    	str = str.replace(" ","");
    	
    	for(int i = 0 ; i < str.length() ; i++){
    	
    		if( str.charAt(i) =='a' || str.charAt(i) == 'e' || str.charAt(i) =='i' || str.charAt(i) == 'o' || str.charAt(i) == 'u' )
    		System.out.println(str.charAt(i)+"  , at index  : "+i ); 
    	}
    
    }
}
