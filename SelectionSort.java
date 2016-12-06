import java.util.Scanner;


class SelectionSort {
	public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	int t=in.nextInt();
    	for(int i=0;i<t;i++){
			int n=in.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++)
				a[j]=in.nextInt();
			int cnt=0,min;
			for(int j=0;j<n;j++){
				min=j;
				for(int k=j+1;k<n;k++)
					if(a[k]<a[min]) min=k;
				if(min!=j) {
					int temp=a[min];
					a[min]=a[j];
					a[j]=temp;
					cnt++;
				}
			}
			System.out.println(cnt);
    	}
        in.close();
    }
    
}
