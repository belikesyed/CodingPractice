import java.util.Scanner;

class Node{
	Node left,right;
	int data;
	public Node(int data){
		this.data=data;
		left=right=null;
	}
}
class BTree{
	private Node root;
	public BTree(){
		root=null;
	}
	public boolean isEmpty(){
		return root==null;
	}
	public void insert(int data){
		root=insert(root,data);
	}
	public void inorder(){
		inorder(root);
		System.out.println("null.");
	}
	public void preorder(){
		preorder(root);
		System.out.println("null.");
	}
	public void postorder(){
		postorder(root);
		System.out.println("null.");
	}
	public void levelorder(){
		levelorder(root);
		System.out.println("null.");
	}
	public int height(){
		return height(root);
	}
	
	private Node insert(Node node, int data){
		if(node==null) node=new Node(data);
		else{
			if(data<node.data)
				node.left=insert(node.left,data);
			else
				node.right=insert(node.right,data);
		}
		return node;
	}
	public boolean search(int data){
		return search(root,data);
	}
	private boolean search(Node node, int data){
		if(node!=null){
			if(node.data==data) return true;
			if(data<node.data) return search(node.left,data);
			else return search(node.right,data);
		}
		return false;
	}
	private void inorder(Node node){
		if(node!=null){
			inorder(node.left);
			System.out.print(node.data+"->");
			inorder(node.right);
		}
	}
	private void preorder(Node node){
		if(node!=null){
			System.out.print(node.data+"->");
			preorder(node.left);
			preorder(node.right);
		}
	}
	private void postorder(Node node){
		if(node!=null){
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data+"->");
		}
	}
	private void levelorder(Node node){
		for(int i=1;i<=height();i++){
			printlvlorder(node,i);
		}
	}
	private void printlvlorder(Node node, int level){
		if(node==null) return;
		else if(level==1) System.out.print(node.data+"->");
		else{
			printlvlorder(node.left, level-1);
			printlvlorder(node.right, level-1);
		}
	}
	private int height(Node node){
		if(node==null) return 0;
		else{
			int lft=height(node.left);
			int rgt=height(node.right);
			if(lft>rgt) return lft+1;
			else return rgt+1;
		}
	}
}

public class BinaryTree {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		BTree bt=new BTree();
		for(int i=0;i<n;i++)
			bt.insert(in.nextInt());
		int var=0;
		do{
			System.out.println("1.Check Empty\t2. Search\t3. Inorder\t4. Preorder");
			System.out.println("5. Postorder\t6. Level order\t7. height\t-1. Exit");
			var=in.nextInt();
			switch(var){
			case -1:
				System.out.println("Exiting..."); break;
			case 1:
				System.out.println(bt.isEmpty()?"empty":"not empty."); break;
			case 2:
				System.out.println(bt.search(in.nextInt())?"found.":"not found."); break;
			case 3:
				bt.inorder(); break;
			case 4:
				bt.preorder(); break;
			case 5:
				bt.postorder(); break;
			case 6:
				bt.levelorder(); break;
			case 7:
				System.out.println("Height:"+bt.height()); break;
			default:
				System.out.println("Choice input is wrong"); break;
			}
		}while(var!=-1);
	in.close();
	}
}
