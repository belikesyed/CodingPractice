import java.util.Scanner;

public class LongPalindrome {
	public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	int t=in.nextInt();
    	for(int i=0;i<t;i++){
			char[] a=in.next().toCharArray();
			palindrome(a);
			System.out.println();
    	}
        in.close();
    }
	static void palindrome(char[] a){
		int len=a.length,l,h,max=0,srt=0;
		
		for(int j=1;j<len;j++){
			l=j-1; h=j; 
			while(l>=0 && h<len && a[l]==a[h]){
				if(h-l>max){
					max=h-l; srt=l;
				}
				++h; --l;
			}
			
			l=j-1; h=j+1; 
			while(l>=0 && h<len && a[l]==a[h]){
				if(h-l>max){
					max=h-l; srt=l;
				}
				++h; --l;
			}
		}
		for(int j=srt;j<=max+srt;j++)
			System.out.print(a[j]);
	}
	int countPS(String str){
		int len=str.length(),l,h,max=len;
		char[] a=str.toCharArray();
		
		for(int j=1;j<len;j++){
			l=j-1; h=j; 
			while(l>=0 && h<len && a[l--]==a[h++])max++;
			
			l=j-1; h=j+1; 
			while(l>=0 && h<len && a[l--]==a[h++])max++;
		}
		return max;
	}
}

