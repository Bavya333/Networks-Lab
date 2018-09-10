import java.net.*;
import java.io.*;
public class arpclient
{
  public static void main(String [] args)throws Exception
  {
    try{
    Socket socket=new Socket("localhost",9999);
    DataInputStream in=new DataInputStream(socket.getInputStream());
    DataOutputStream out=new DataOutputStream(socket.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("IP Address:");
    String str=br.readLine();
    out.writeUTF(str);
    str=in.readUTF();
    System.out.println("MAC Address:"+str);
    socket.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}
