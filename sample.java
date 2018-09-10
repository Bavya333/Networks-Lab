import java.io.*;
public class sample {

   public static void main(String args[]) throws IOException {
      FileInputStream in = null;
      FileOutputStream out = null;
      BufferedReader br=null;
      try
      {
         //in = new FileInputStream("input.txt");
         out = new FileOutputStream("output.txt");
         br=new BufferedReader(new FileReader("input.txt"));
         String str=br.readLine();
         while(!str.equals(null))
         {
           String arr[]=str.split(" ");
           for(int i=0;i<arr.length;i++)
           {
             System.out.println(arr[i]);
           }
           str=br.readLine();
         }
      }
      finally
      {
         if (in != null)
         {
            in.close();
         }
         if (out != null)
         {
            out.close();
         }
         br.close();
      }
   }
}
