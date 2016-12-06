import java.util.Scanner;

public class Codechef2 {
 public static void main(String[] args){
	 Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		int m,n;
		for(int i=0;i<t;i++){
			n=in.nextInt();
			m=in.nextInt();
			int[][] edge=new int[m][3];
					
			for(int j=0;j<m;j++){
				edge[j][1]=in.nextInt();
				edge[j][2]=in.nextInt();
				if(in.nextInt()==0) edge[j][0]=0;
				else edge[j][0]=in.nextInt();
			}
			(new Sorting()).sort(edge, 0, m-1);
			for(int j=0;j<m;j++)
				System.out.println(edge[j][0]+" "+edge[j][1]+" "+edge[j][2]);
			int[] v=new int[n+1];
			//for(int j=1;j<=n;j++) v[j]=0;
			int cnt=0,cost=0;
			for(int j=0;j<m;j++){
				if(cnt<n){
					if(v[edge[j][1]]!=1 ||v[edge[j][2]]!=1){
						cost+=edge[j][0];
						v[edge[j][1]]=1;
						v[edge[j][2]]=1;
					}
				}
				else break;
			}
			System.out.println(cost);
		}	
		in.close();
 }
}
class Sorting{
	void merge(int arr[][], int l, int m, int r)
	 {
	     int n1 = m - l + 1;
	     int n2 = r - m;
	     int L[][] = new int [n1][3];
	     int R[][] = new int [n2][3];

	     for (int i=0; i<n1; ++i){
	    	 L[i] = arr[l + i];
	     }
	     for (int j=0; j<n2; ++j)
	         R[j] = arr[m + 1+ j];

	     int i = 0, j = 0,k = l;
	     while (i < n1 && j < n2)
	     {
	         if (L[i][0] <= R[j][0]) arr[k++] = L[i++];
	         else arr[k++] = R[j++];
	     }
	     while (i < n1) arr[k++] = L[i++];
	     while (j < n2) arr[k++] = R[j++];
	 }

	 void sort(int arr[][], int l, int r)
	 {
	     if (l < r)
	     {
	         int m = (l+r)/2;
	         sort(arr, l, m);
	         sort(arr , m+1, r);
	         merge(arr, l, m, r);
	     }
	 }
}

