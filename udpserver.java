import java.net.*;
public class udpserver
{
  public static void main(String [] args) throws Exception
  {
    DatagramSocket socket=new DatagramSocket(9999);
    byte[] rcv=new byte[1024];
    DatagramPacket pckt=new DatagramPacket(rcv,1024);
    socket.receive(pckt);
    String s=new String(pckt.getData(),0,pckt.getLength());
    System.out.println(s);
    socket.close();
  }
}
