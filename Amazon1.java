import java.util.*;
class Amazon1 {
    public static void main(String args[] ) {

        String[] str ={"cat" ,"god" ,"bitch","dog" , "tac" ,"cta" };
        String[] dup=new String[str.length];
        
        for(int i=0;i<str.length;i++) dup[i]=str[i];
        int[] a=new int[str.length];
       int k=0;
        for(int i=0;i<str.length;i++)
        	if(dup[i]!=null){
        		a[k++]=i;
        		for(int j=i+1;j<str.length;j++)
        			if(dup[j]!=null &&strMatch(dup[i],dup[j])){
        				a[k++]=j; dup[j]=null;
        			}
        	}
        	
	    for(int i=0;i<str.length;i++)
	        System.out.println(str[a[i]]);
    }
    public static String sortChar(char[] a){
    	 Arrays.sort(a);
    	 String s="";
    	 for(int i=0;i<a.length;i++)
    		 s=s+a[i];
    	 return s;
    }
    public static boolean strMatch(String s1, String s2){
    	if(sortChar(s1.toCharArray()).equals(sortChar(s2.toCharArray()))){
    		return true;
    	}
    	return false;
    }
}
