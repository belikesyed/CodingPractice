import java.util.Scanner;

public class LCSS {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String str1=in.nextLine();
		String str2=in.nextLine();
		System.out.println("Longest common Substring="+substr(str1,str2));
	}
	public static String substr(String str1, String str2){
		String str="";
		int l1=str1.length();
		int l2=str2.length();
		int flagi=0,cnt=0;
		int[][] strTable=new int[l1][l2];
		
		for(int i=0;i<l1;i++){
			for(int j=0;j<l2;j++){
				strTable[i][j]=0;
			}
		}
		for(int i=0;i<l1;i++){
			for(int j=0;j<l2;j++){
				if(str1.charAt(i)==str2.charAt(j)){
					if(i<1 || j<1)
						strTable[i][j]=1;
					else
						strTable[i][j]=strTable[i-1][j-1]+1;
					if(strTable[i][j]>cnt){
						cnt=strTable[i][j];
						flagi=i;
					}
				}
				//System.out.print(strTable[i][j]+" ");
			}
			//System.out.println();
		}
		for(int i=cnt;i>0;i--){
			str=str1.substring(flagi-cnt+1,flagi+1);
		}
		return str;
	}
}
