import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		
		for(int i=0;i<t;i++){
			String A=in.next();
			String B=in.next();
			int a=A.length();
			int b=B.length();
			int dif,cost=0,p=0,q=0,c;
			boolean[] bol;
			if(a>b) {
				dif=b;
				bol=new boolean[a];
			}
			else{
				dif=a;
				bol=new boolean[b];
			}
			boolean g=true;
			int[] m=new int[dif];
			int[] n=new int[dif];
			for(int j=0;j<bol.length;j++)
				bol[j]=true;
			for(int j=0;j<a;j++){
				for(int k=0;k<b;k++){
					if(g && bol[k]&& A.charAt(j)==B.charAt(k)){
						c=(int)A.charAt(j);
						m[p++]=c-'0'; g =false; bol[k]=false;
						System.out.print(m[p-1]+"-> ");
					}
				}
				g=true;
			}
			for(int j=0;j<bol.length;j++)
				bol[j]=true;
			q=0;
			for(int j=0;j<b;j++){
				for(int k=0;k<dif;k++){
					c=(int)B.charAt(j)-'0';
					if(m[k]==c){
						n[q++]=c;
					}
				}
			}
			for(int j=0;j<dif;j++)
				System.out.print(m[j]);
			System.out.println();
			for(int j=0;j<dif;j++)
				System.out.print(n[j]);
		System.out.println(cost);
		}
		in.close();
    }
}
