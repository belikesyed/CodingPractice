import java.util.Scanner;

public class MinCostPath {
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
		
		tc[0][0]=cost[0][0];
		for(int j=1;j<m;j++)
			tc[j][0] =tc[j-1][0]+cost[j][0];
		for(int j=1;j<n;j++)
			tc[0][j] =tc[0][j-1]+cost[0][j];
		
		for(int j=1;j<m;j++){
			for(int k=1;k<n;k++){
				tc[j][k]= cost[j][k]+ min(tc[j-1][k],tc[j][k-1],tc[j-1][k-1]);
			}
		}
			
		return tc[n-1][m-1];
	}
	static int min(int a, int b,int c){
		if(a<b && a<c) return a;
		if(b<a && b<c) return b;
		else return c;
	}
}
