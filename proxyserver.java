import java.net.*;
import java.io.*;
public class proxyserver
{
  public static void main(String [] args)
  {
    try
    {
      ServerSocket ss=new ServerSocket(9999);
      Socket socket=ss.accept();
      DataInputStream in=new DataInputStream(socket.getInputStream());
      DataOutputStream out=new DataOutputStream(socket.getOutputStream());
      BufferedReader br=new BufferedReader(new FileReader("input.txt"));
      String str=in.readUTF();
      String filedata=br.readLine();
      Integer flag=0;
      while(filedata!=null)
      {
        System.out.println(str);
        String array[]=filedata.split(" ");
        if(str.equals(array[0]))
        {
            System.out.println("IP found in Proxy server:");
            out.writeUTF(array[1]);
            flag=1;
            break;
        }
        filedata=br.readLine();
      }
      if(flag==0)
      {
        Socket psocket=new Socket("localhost",6666);
        DataInputStream pin=new DataInputStream(psocket.getInputStream());
        DataOutputStream pout=new DataOutputStream(psocket.getOutputStream());
        System.out.println("Redirecting to Root DNS");
        pout.writeUTF(str);
        String string=str;
        str=pin.readUTF();
        string=string+" "+str;
        out.writeUTF(str);
        FileOutputStream fout=new FileOutputStream("input.txt",true);
        fout.write(string.getBytes(),0,string.length());
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}
