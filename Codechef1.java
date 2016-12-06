import java.util.Scanner;

class Codechef1
{
    static int min(int x,int y,int z)
    {
        if (x<y && x<z) return x;
        if (y<x && y<z) return y;
        else return z;
    }
    
    static int editDistDP(String str1, String str2, int m, int n)
    {
        // Create a table to store results of subproblems
        int dp[][] = new int[m+1][n+1];

        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
            	if(i==0 && j==0) dp[i][j]=0;
                else if (i==0 && j>0)
                		dp[i][j] = dp[i][j-1]+(int)str2.charAt(j-1)-'0';

                else if (j==0 && i>0) 
                	dp[i][j] = dp[i-1][j]+(int)str1.charAt(i-1)-'0';
                
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];

                else
                {
                	int a=((int)str2.charAt(j-1)-'0');
                    int b=((int)str1.charAt(i-1)-'0');
                	dp[i][j] = min(a+dp[i][j-1],  // Insert
                            b+dp[i-1][j],  // Remove
                            a+b+dp[i-1][j-1]); // Replace
                }
                    
            }
        }
        
        for(int i=0; i<= m; i++)
        {
        	for(int j=0; j<=n; j++)
        	{
        		System.out.print(dp[i][j]+"\t");
        	}
        	System.out.println();
        }
  
        return dp[m][n];
    }
    
 
    static int editDist(String str1 , String str2 , int m ,int n)
    {
    if (m == 0){
    	int cost=0;
    	for(int i=0;i<n;i++)
    		cost+=(int)str2.charAt(i)-'0';
    	return cost;
    }
    if (n == 0){
    	int cost=0;
    	for(int i=0;i<m;i++)
    		cost+=(int)str1.charAt(i)-'0';
    	return cost;
    }
    if (str1.charAt(m-1) == str2.charAt(n-1))
    	return editDist(str1, str2, m-1, n-1);
    
    int a=((int)str2.charAt(n-1)-'0');
    int b=((int)str1.charAt(m-1)-'0');

    return  min ( a+editDist(str1,  str2, m, n-1),
    				b+editDist(str1,  str2, m-1, n),
                     a+b+editDist(str1,  str2, m-1, n-1));
    }
 
    public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	int t=in.nextInt();
    	for(int i=0;i<t;i++){
			String str1=in.next();
			String str2=in.next();
			System.out.println("a"+editDistDP(str1, str2, str1.length(), str2.length()));
			System.out.println("b"+editDist(str1, str2, str1.length(), str2.length()));
    	}
        in.close();
    }
}