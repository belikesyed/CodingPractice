import java.util.Scanner;

public class Test {

	public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	int t=in.nextInt();
    	for(int i=0;i<t;i++){
			int n=in.nextInt();
	
			System.out.println(convertfive(n));
    	}
        in.close();
    }
	static int convertfive(int num)
    {
	    int n=num,cnt=0;
	    while(n>0){
	    	if(n%10==0) num=num+ pow(10,cnt)*5;
	    	cnt++;
	    	n=n/10;
	    	
	    }
	    return num;
    }
	static int pow(int base, int pw){
	    if(pw == 0) return 1;
	    return base * pow(base, --pw);
	}
	
	
}
