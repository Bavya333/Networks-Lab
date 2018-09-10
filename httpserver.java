import java.net.*;
import java.io.*;
import java.util.Date;
public class httpserver
{
  public static void main(String args[] ) throws IOException
  {
    ServerSocket server=new ServerSocket(9999);
    while(true)
    {
      try(Socket socket=server.accept())
      {
        System.out.println("Listening to the port 9999");
        Date today=new Date();
        String httpresponse="HTTP/1.1 200 0k\r\n\r\n"+today;
        socket.getOutputStream().write(httpresponse.getBytes("UTF-8"));
      }
    }
  }
}
