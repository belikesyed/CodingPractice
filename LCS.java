import java.util.Scanner;

public class LCS {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++){
			int n=in.nextInt();
			int m=in.nextInt();
			char[] str1=in.next().toCharArray();
			char[] str2=in.next().toCharArray();
			System.out.println(ss(str1,str2,n,m));
		}
		in.close();
	}
	public static int ss(char[] str1, char[] str2,int n,int m){
		
		int[][] strTable=new int[n+1][m+1];

		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				if(i<1 || j<1)strTable[i][j]=0;
				else if(str1[i-1]==str2[j-1])
					strTable[i][j]=strTable[i-1][j-1]+1;
				else strTable[i][j]=max(strTable[i-1][j],strTable[i][j-1]);
			}
		}
		return strTable[n][m];
	}
	public static int max(int a, int b){
		return a>b?a:b;
	}
}
