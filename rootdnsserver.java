import java.net.*;
import java.io.*;
public class rootdnsserver
{
  public static void main(String [] args)
  {
    try
    {
      ServerSocket ss=new ServerSocket(6666);
      Socket socket=ss.accept();
      DataInputStream in=new DataInputStream(socket.getInputStream());
      DataOutputStream out=new DataOutputStream(socket.getOutputStream());
      BufferedReader br=new BufferedReader(new FileReader("output.txt"));
      String str=in.readUTF();
      String filedata=br.readLine();
      while(filedata!=null)
      {
        System.out.println(str);
        String array[]=filedata.split(" ");
        if(str.equals(array[0]))
        {
            System.out.println("IP found in Root server:");
            out.writeUTF(array[1]);
            break;
        }
        filedata=br.readLine();
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}
