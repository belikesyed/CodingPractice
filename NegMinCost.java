import java.util.Scanner;

public class NegMinCost {
	public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	int t=in.nextInt();
    	for(int i=0;i<t;i++){
			int m=in.nextInt();
			int n=in.nextInt();
			int[][] a=new int[m][n];
			for(int j=0;j<m;j++)
				for(int k=0;k<n;k++)
					a[j][k]=in.nextInt();

			System.out.println(minCost(a,m,n));
    	}
        in.close();
    }
	public static int minCost(int[][] cost, int m,int n ){
		int[][] tc=new int[m][n];
		
		tc[m-1][n-1]=cost[m-1][n-1]>0?1:Math.abs(cost[m-1][n-1])+1;
		for(int j=m-2;j>=0;j--)
			tc[j][n-1] =max(tc[j+1][n-1]-cost[j][n-1],1);
		for(int j=n-2;j>=0;j--)
			tc[m-1][j] =max(tc[m-1][j+1]-cost[m-1][j],1);
		
		int min;
		for(int j=m-2;j>=0;j--){
			for(int k=n-2;k>=0;k--){
				min=min(tc[j][k+1],tc[j+1][k]);
				tc[j][k]= max(min-cost[j][k],1);
			}
		}
		/*for(int j=0;j<m;j++){
			for(int k=0;k<m;k++){
				System.out.print(tc[j][k]+" ");
			}
			System.out.println();
		}*/
			
		return tc[0][0];
	}
	static int min(int a, int b){
		return a>b?b:a;
	}
	static int max(int a, int b){
		return a>b?a:b;
	}
}
