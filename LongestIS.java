import java.util.Scanner;

public class LongestIS {
	public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	int t=in.nextInt();
    	for(int i=0;i<t;i++){
			int n=in.nextInt();
			int[] arr=new int[n];
			for(int j=0;j<n;j++)
				arr[j]=in.nextInt();
			System.out.println(maxLIS(arr, n));
    	}
        in.close();
    }
	public static int maxLIS(int[] arr,int n){
		int max=0;
		int[] lis=new int[n];
		for(int i=0;i<n;i++)
			lis[i]=1;
		for(int i=1;i<n;i++)
			for(int j=0;j<i;j++)
				if(arr[i]>arr[j] && lis[j]+1>lis[i])
					lis[i]=lis[j]+1;
		for(int i=0;i<n;i++)
			if(max<lis[i]) max=lis[i];
		return max;
	}
}
