import java.net.*;
import java.io.*;
public class chatserver
{
  public static void main(String [] args)
  {
    try
    {
    ServerSocket ss=new ServerSocket(9999);
    Socket socket=ss.accept();
    System.out.println("Client Accepted!");
    DataOutputStream out=new DataOutputStream(socket.getOutputStream());
    DataInputStream in=new DataInputStream(socket.getInputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String data="";
    String s="";
    while(!data.equals("Podhum"))
    {
      data=in.readUTF();
      System.out.println("From Client:"+data);
      s=br.readLine();
      out.writeUTF(s);
      out.flush();
    }
    socket.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}
