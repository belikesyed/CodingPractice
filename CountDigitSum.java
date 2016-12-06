

import java.util.Scanner;

public class CountDigitSum {
	static int dp[][] = new int[101][1001];
	static int k=1000000007;
	static int k2=2000000014;
	public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	int t=in.nextInt();
    	for(int i=0;i<t;i++){
			int n=in.nextInt();
			int x=in.nextInt();
			

			int cnt=check(n,x);
			System.out.println(cnt>0?cnt:"-1");
    	}
        in.close();
    }
	public static int check(int n, int sum){
		int c=0;
		for(int i = 0;i<=100;++i){
            for(int j=0;j<=1000;++j){
                dp[i][j] = -1;
            }
        }
		
		for(int i=1;i<=9;i++){
			if(sum-i>=0)
				c=c+cntSum(n-1,sum-i);
			if(c>k) c=c%k;
		}
		return c;
	}
	public static int cntSum( int n, int sum){
		int c=0;
		if (n == 0) return sum == 0 ?1:0;
		if (dp[n][sum] != -1) return dp[n][sum];
		for (int i = 0; i <= 9; i++)
			if(sum-i>=0){
				c=c+cntSum(n-1, sum - i);
				if(c>k) c=c%k;
			}
		dp[n][sum] = c;
		return c;
	}
	
}
