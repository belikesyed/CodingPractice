import java.util.Arrays;
import java.util.Scanner;

class LowerupperstrSort {
	public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	int t=in.nextInt();
    	for(int i=0;i<t;i++){
			int n=in.nextInt();
			char[] a=in.next().toCharArray();
			int cnt=0;
			
			for(int j=0;j<n;j++)
				if((int)a[j]>=97 && (int)a[j]<=122) cnt++;
			int[] lw=new int[cnt];
			int[] up=new int[n-cnt];
			int k=0,l=0;
			for(int j=0;j<n;j++){
				if((int)a[j]>=97 && (int)a[j]<=122) lw[k++]=(int)a[j];
				else up[l++]=(int)a[j];
			}
			Arrays.sort(lw);
			Arrays.sort(up);
			l=k=0;
			for(int j=0;j<n;j++){
				if((int)a[j]>=97 && (int)a[j]<=122) a[j]=(char)lw[k++];
				else a[j]=(char)up[l++];
			}

			System.out.println(a);
    	}
        in.close();
    }

}
