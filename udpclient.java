import java.net.*;
import java.io.*;
public class udpclient
{
  public static void main(String [] args) throws Exception
  {
    DatagramSocket socket=new DatagramSocket();
    String str="Hi";
    InetAddress ip=InetAddress.getByName("127.0.0.1");
    DatagramPacket pckt=new DatagramPacket(str.getBytes(),str.length(),ip,9999);
    socket.send(pckt);
    socket.close();
  }
}
