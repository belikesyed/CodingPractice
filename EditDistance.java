import java.util.Scanner;


class EditDistance {
	public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	int t=in.nextInt();
    	for(int i=0;i<t;i++){
			int n=in.nextInt();
			int m=in.nextInt();
			char[] str1=in.next().toCharArray();
			char[] str2=in.next().toCharArray();
			System.out.println(editDistDP(str1, str2, n, m));
			
    	}
        in.close();
    }
    public static int editDistDP(char[] str1, char[] str2,int n, int m){
        
        int[][] cost=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0) cost[i][j]= j;
                else if(j==0) cost[i][j]=i;
                else if(str1[i-1]==str2[j-1])
                    cost[i][j]=cost[i-1][j-1];
                else cost[i][j]=1+min(cost[i][j-1],cost[i-1][j],cost[i-1][j-1]);
            }
        }				
        return cost[n][m];
    }
    public static int min(int a,int b,int c){
        if(a<b && a<c) return a;
        if(b<a && b<c) return b;
        else return c;
    }
}
