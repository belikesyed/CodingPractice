import java.util.Arrays;
import java.util.Scanner;

public class Lexicography {
	public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	int t=in.nextInt();
    	for(int i=0;i<t;i++){
			char[] s=in.next().toCharArray();			

			System.out.println(strcnvrt(s));
    	}
        in.close();
    }
	public static char[] strcnvrt(char[] s){
		char b='0',c='9';
		int flag=0;
		int n=s.length;
		int[] ss=new int[n];
		for(int i=0;i<n;i++)
			ss[i]=(int)s[i];
		Arrays.sort(ss);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if((char)ss[i]==s[j]){
					break;
				}
				else if(ss[i]<s[j] && i==0?1==1:ss[i-1]<s[j]){
					b=(char)ss[i]; c=s[j]; i=n; flag=j;
					break;
				}
			}
		}
		if(b!='0'){
			for(int j=flag;j<s.length;j++){
				if(s[j]==b) s[j]=c;
				else if(s[j]==c) s[j]=b;
			}
		}
		return s;
	}
}
