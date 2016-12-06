import java.util.*;

class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Linklistremovedup
{
    public static Node removeDuplicates(Node head) {
        Node temp=head;
      if(temp==null) return null;
       else{
           while(temp.next!=null){
               Node temp1=temp;
               while(temp1.next!=null){
                   if(temp.data==temp1.next.data){
                       Node rm=temp1.next;
                       temp1.next=rm.next;
                       rm=null;
                   }
                   else if(temp1.next!=null) {
                	   temp1=temp1.next;
                   }
               }
               if(temp1.next!=null) temp=temp.next;
           }
       }
        return head;
    }
    public static  Node insert(Node head,int data)
    {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    
    public static Node reorderlist(Node head)
    {
        int cnt=0;
		 Node temp=head,half=head;
	        while(temp.next!=null && temp.next.next!=null){
	            temp=temp.next.next;
	            half=half.next;
	            cnt++;
	        }
	        
	        int[] a=new int[cnt];
	        if(temp.next!=null){
	        	half=half.next;
	        }
	        int i=0;
	        while(half.next!=null){
	            a[i++]=half.next.data;
	            Node rm=half.next;
	            half.next=rm.next;
	            rm=null;
	        }
	        display(head);
	        System.out.println();
	        for(i=0;i<cnt;i++)
	        	System.out.print(a[i]+" ");
	        temp=head;
	        Node put;
	        i=cnt-1;
	        while(i>=0 && temp.next!=null){
	        	put=new Node(a[i--]);
	        	put.next=temp.next;
	        	temp.next=put;
	        	temp=put.next;
	        	System.out.print(put.next.data+" ");
	        }
	        return head;
    }
    
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=reorderlist(head);
              //head=removeDuplicates(head);
              display(head);
              sc.close();
       }
    }