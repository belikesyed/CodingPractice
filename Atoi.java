import java.util.Scanner;


class Atoi {
	public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	int t=in.nextInt();
    	for(int i=0;i<t;i++){
			char[] str1=in.next().toCharArray();
			int ch,num=0,x=0,sign;
			while(str1[x]==' '||str1[x]=='\n') x++;
			sign=(str1[x]=='-')?-1:1;
			if(str1[x]=='+'||str1[x]=='-') x++;
			
			for(int j=x;j<str1.length;j++){
				ch=(int) str1[j]-'0';
				if(ch<0 || ch>9){
					num=-1;
					break;
				}
				else num=num*10+ch;
			}
			System.out.println(sign*num);
    	}
        in.close();
    }
    
}
