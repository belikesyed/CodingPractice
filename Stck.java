import java.util.Scanner;

public class Stck{
 public static void main(String[] args){
 	Scanner in=new Scanner(System.in);
 	int K=in.nextInt();
 	int N=in.nextInt();
 	String[] sbstr=new String[K];
 	String[] str=new String[N];
 	for(int i=0;i<K;i++)
 		sbstr[i]=in.next();
 	for(int i=0;i<N;i++)
 		str[i]=in.next();
 	int j=0;
 	for(int i=0;i<N;i++){
 		if(str[i].length()>=47)
 			System.out.println("Good");
 		else{
 			for(j=0;j<K;j++){
 				if(str[i].contains(sbstr[j])){
 					System.out.println("Good");
 					break;
 				}
 			}
 			if(j==K){
 				System.out.println("Bad");
 			}
 		}
 	}
 	
 	in.close();
 }
}