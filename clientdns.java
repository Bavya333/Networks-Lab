import java.net.*;
import java.io.*;
public class clientdns
{
  public static void main(String [] args)
  {
    try
    {
      Socket socket=new Socket("localhost",9999);
      DataInputStream in=new DataInputStream(socket.getInputStream());
      DataOutputStream out=new DataOutputStream(socket.getOutputStream());
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String str;
      str=br.readLine();
      out.writeUTF(str);
      str=in.readUTF();
      System.out.println(str);
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}
