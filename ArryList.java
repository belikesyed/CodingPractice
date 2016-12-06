import java.util.*;

public class ArryList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int a=97;
        char[][] grid=new char[m][n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(a<123)
        			grid[i][j]=(char)a++;
        		else{
        			a=97;
        			grid[i][j]=(char)a++;
        		}
        	}
        	System.out.println(grid[i]);
        }
        String str=in.next();
        if(findWord(grid,m,n, str)) System.out.println(str+":true");
        else System.out.println(str+":false ");
        in.close();
    }
    public static boolean findWord(char[][] grid,int m,int n, String str){
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			if(str.charAt(0)==grid[i][j]){
    				System.out.println("check at 0 char match:"+j+","+i);
    				if(check(grid,m,n,i,j,str,0)) return true;
    				System.out.println("no match:");
    			}
    		}
    	}
    		
    	return false;
    }
    public static boolean check(char[][] grid,int m, int n,int k, int l,String str, int cnt){
    	if(k>m && l>n && k<0 && l<0) return false;
    	int len=str.length()-1;
    	if(cnt==len) return true;
    	cnt=cnt+1;
    	if(k+1<m && str.charAt(cnt)==grid[k+1][l]) check(grid,m,n,k+1,l,str,cnt);
    	else if(l+1<n && str.charAt(cnt)==grid[k][l+1]) check(grid,m,n,k,l+1,str,cnt);
    	else if(k+1<m && l+1<n && str.charAt(cnt)==grid[k+1][l+1]) check(grid,m,n,k+1,l+1,str,cnt);
    	else if(k-1>0 && str.charAt(cnt)==grid[k-1][l]) check(grid,m,n,k-1,l,str,cnt);
    	else if(l-1>0 && str.charAt(cnt)==grid[k][l-1]) check(grid,m,n,k,l-1,str,cnt);
    	else if(k-1>0 && l-1>0 && str.charAt(cnt)==grid[k-1][l-1]) check(grid,m,n,k-1,l-1,str,cnt);
    	else if(k-1>0 && l+1<n && str.charAt(cnt)==grid[k-1][l+1]) check(grid,m,n,k-1,l+1,str,cnt);
    	else if(k+1<m && l-1>0 && str.charAt(cnt)==grid[k+1][l-1]) check(grid,m,n,k+1,l-1,str,cnt);
    	else return false;
    	return true;
    }
}
