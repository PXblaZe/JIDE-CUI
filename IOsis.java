import java.io.PrintWriter;

class IOsis
{
  
  protected static void outsis(String text, String fileName)
  {
    try {
      PrintWriter out = new PrintWriter(fileName);
      out.print(text);
      out.close();
    } catch (java.io.FileNotFoundException e) { System.out.println("Error: " + e);
    }
  }
  
  protected static void outsisAdd(String text, String fileName) {
    try { String[] in = insis(fileName);
      long pl = in.length;
      PrintWriter out = new PrintWriter(fileName);
      for (int i = 0; i < pl; i++)
        out.println(in[i]);
      out.print(text);
      out.close();
    } catch (java.io.FileNotFoundException e) { System.out.println("Error: " + e);
    }
  }
  
  protected static String[] insis(String fileName) { 
    java.util.ArrayList<String> lines = new java.util.ArrayList();
    try
    {
      java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(fileName));
      String str = null;
      while ((str = in.readLine()) != null)
        lines.add(str);
    } catch (java.io.IOException e) { System.out.println("Error: " + e); }
    String[] linesArray = (String[])lines.toArray(new String[lines.size()]);
    return linesArray;
  }
  
  protected static void outsis(String[] text, String fileName) 
  {
        try
        {
            int l = text.length;
            PrintWriter out = new PrintWriter(fileName);
            for (int i = 0; i < l; i++) 
            {
                out.println(text[i]);
            }
            out.close();
        }catch (java.io.FileNotFoundException e) 
        {
            System.out.println("Error: " + e);
        }
  }
  
}