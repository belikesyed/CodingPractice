import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketClient {
	public static void main(String[] args) throws Exception{
		SocketClient cl1=new SocketClient();
		cl1.run();
		
	}
	public void run() throws Exception
	{
		Scanner in=new Scanner(System.in);
		Socket client=new Socket("localhost",444);
		PrintStream ps=new PrintStream(client.getOutputStream());
		ps.println("Client:Hello from Client!");
		InputStreamReader ir=new InputStreamReader(client.getInputStream());
		BufferedReader br=new BufferedReader(ir);
		
		String msg=br.readLine();
		System.out.println(msg);
		String var="";
		do{
			System.out.println("Type Msgs:: -1 to exit.");
			var=in.nextLine();
			ps.println(var);
		}while(!var.equals("-1"));
	}

}