import java.io.*;
import java.net.*;

public class SocketServer {
	public static void main(String[] args) throws Exception{
		SocketServer sv1=new SocketServer();
		sv1.run();
		
	}
	public void run() throws Exception
	{
		ServerSocket server=new ServerSocket(444);
		Socket sock=server.accept();
		InputStreamReader ir=new InputStreamReader(sock.getInputStream());
		BufferedReader br=new BufferedReader(ir);
		String msg=br.readLine();
		System.out.println(msg);
		
		if(msg!=null){
			PrintStream ps=new PrintStream(sock.getOutputStream());
			ps.println("Server:Message Received!");
		}
	}

}
