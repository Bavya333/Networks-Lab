import java.net.*;
import java.io.*;
public class chatclient
{
  public static void main(String [] args)
  {
    try
    {
    Socket socket=new Socket("localhost",9999);
    DataOutputStream out=new DataOutputStream(socket.getOutputStream());
    DataInputStream in=new DataInputStream(socket.getInputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String data="";
    String s="";
    while(!data.equals("Podhum"))
    {
      data=br.readLine();
      out.writeUTF(data);
      out.flush();
      s=in.readUTF();
      System.out.println("From Server:"+s);
    }
    socket.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}
