import java.util.Scanner;

public class Main2 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		int m,n;
		for(int i=0;i<t;i++){
			m=in.nextInt();
			n=in.nextInt();
			int[][] c=new int[n+1][m+1];
			int[][] p=new int[n+1][m+1];
			for(int j=1;j<=n;j++)
				for(int k=1;k<=m;k++)
					c[j][k]=in.nextInt();
			for(int j=1;j<=n;j++)
				for(int k=1;k<=m;k++)
					p[j][k]=in.nextInt();
			int cost=c[1][1],flag=0,x,y;
			if(c[1][2]>c[2][1]){
				cost +=c[2][1];
				x=2;y=1; flag=0;
			}
			
			else {
				cost +=c[1][2];
				x=1;y=2; flag=1;
			}
			//System.out.println("starting "+cost+flag);
			while(x<n && y<m){
				if(flag==0){
					if(c[++x][y]<(c[x-1][y]+p[x-1][y]))
						cost +=c[x][y];
					else{
						cost +=p[--x][y];
						flag=1;
					}	
				}
				else
				{
					if(c[x][++y]<(c[x][y-1]+p[x][y]))
						cost +=c[x][y];
					else{
						cost +=p[x][--y];
						flag=0;
					}
				}
			}
			if(x>=n){
				if( flag==0){
					cost +=p[x][y];
					while(y<m){
						cost +=c[x][++y];
						//System.out.println("flag=0 "+cost);
					}
				}
				else
					while(y<m){
						cost +=c[x][++y];
						//System.out.println("flag=0 "+cost);
					}	
				
			}
			else if(y>=m){
				if( flag==1){
					cost +=p[x][y];
					while(x<n){
						cost +=c[++x][y];
						System.out.println("flag=1 "+cost);
					}
				}
				else
					while(x<n){
						cost +=c[++x][y-1];
						System.out.println(cost);
					}	
				
			}
			System.out.println(cost);
			
		}
					
		in.close();
    }
	
}
