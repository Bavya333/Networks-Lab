import java.net.*;
import java.io.*;
public class arpserver
{
  public static void main(String [] args)
  {
    try{
    ServerSocket ss=new ServerSocket(9999);
    Socket socket=ss.accept();
    DataInputStream in=new DataInputStream(socket.getInputStream());
    DataOutputStream out=new DataOutputStream(socket.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String ip[]={"167.1.2.3","178.2.2.1"};
    String mac[]={"6A:08:CF:3B","5E:8A:D3:E2"};
    String data=in.readUTF();
    for(int i=0;i<ip.length;i++)
    {
      if(ip[i].equals(data))
      {
        out.writeUTF(mac[i]);
        break;
      }
    }
    socket.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}
