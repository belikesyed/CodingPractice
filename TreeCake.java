import java.util.Scanner;

class TreeCake{
	static int n=1000000007;
	static int n2=2*n;
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		long h,b;
		for(int i=0;i<t;i++){
			h=in.nextLong();
			b=fib(h);
			System.out.println(b%2==0?(b/2)%n:((b+1)/2)%n);
		}
		in.close();
	}
	public static long fib(long h){
		long a=0,b=1,c;
		if(h>1){
			for(long i=2;i<=h;i++){
				c=(a+b)%n2;
				a=b;
				b=c;
			}
			return b;
		}
		else return h;
	}
}