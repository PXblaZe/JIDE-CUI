import java.awt.Robot;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
class Func{
    protected final static ArrayList<String> list = new ArrayList();
    protected final static ArrayList<String> list1 = new ArrayList();
    protected final static ArrayList<String> list2 = new ArrayList();
    private static String cln=null;
    protected static void resetJVM()
    {
        try
        {
            Robot r = new Robot();
            r.keyPress(17);
            r.keyPress(KeyEvent.VK_SHIFT);
            r.keyPress(KeyEvent.VK_R);
            r.keyRelease(17);
            r.keyRelease(KeyEvent.VK_SHIFT);
            r.keyRelease(KeyEvent.VK_R);
        }
        catch(AWTException e)
        {System.out.println("Error: "+e);}
    }
    protected static String[] body()
    {
        int fi = 0;
        final String[] bd;
        ArrayList<String> listB = new ArrayList(),
        Bdata = new ArrayList();
        String st="",ln="",l="";
        boolean dob = false,swb=false,
        ctb=false,fnb=false,otclb=true,elb=false,
        clb=false,wlb=false,flb=false,dftb=false,
        ifb=false,elifb=false,csb=false;
        do
        {
            Scanner bsc = new Scanner(System.in);
            st=bsc.nextLine();
            st=st.trim();
            if((st.startsWith("sop(")&&st.endsWith(");"))&&(fnb==true||ctb==true))
                st="System.out.print"+st.substring(st.indexOf("("));
            else if((st.startsWith("sopln(")&&st.endsWith(");"))&&(fnb==true||ctb==true))
                st="System.out.println"+st.substring(st.indexOf("("));
            else if(st.startsWith("imp ")&&otclb==true&&st.endsWith(";"))
                st="import "+(st.substring(st.indexOf(" ")+1));
            else if((st.startsWith("elif(")&&st.endsWith(")"))&&(fnb==true||ctb==true))
                st="else if"+st.substring(st.indexOf("("));
            if(st.startsWith("class ")&&otclb)
            {
                otclb=false;
                clb=true;;
                cln = st.substring(st.indexOf(" ")+1);
                ln+=":   ";
                fi++;
                listB.add(l+"{");
                l+="    ";
                Bdata.add("class "+cln);
            }
            
            else if(clb==true&&(st.substring(st.indexOf(" ")+1).startsWith(cln+"(")||
                    st.startsWith(cln+"("))&&st.endsWith(")"))
            {
                clb=false;
                ctb=true;
                ln+=":   ";
                fi++;
                listB.add(l+"{");
                l+="    ";
            }
            else if(st.startsWith("if(")&&st.endsWith(")"))
            {
                fnb=dob=csb=dftb=flb=wlb=elifb=elb=ctb=false;
                ifb=true;
                ln+=":   ";
                fi++;
                listB.add(l+"{");
                l+="    ";
            }
            else if(st.startsWith("else if(")&&st.endsWith(")"))
            {
                fnb=ifb=csb=dftb=flb=wlb=dob=elb=ctb=false;
                elifb=true;
                ln+=":   ";
                fi++;
                listB.add(l+"{");
                l+="    ";
            }
            else if(st.equals("else"))
            {
                fnb=ifb=csb=dftb=flb=wlb=elifb=dob=ctb=false;
                elb=true;
                ln+=":   ";
                fi++;
                listB.add(l+"{");
                l+="    ";
            }
            else if(st.startsWith("for(")&&st.endsWith(")"))
            {
                fnb=ifb=csb=dftb=dob=wlb=elifb=elb=ctb=false;
                flb=true;
                ln+=":   ";
                fi++;
                listB.add(l+"{");
                l+="    ";
            }
            else if(st.startsWith("while(")&&st.endsWith(")"))
            {
                fnb=ifb=csb=dftb=flb=dob=elifb=elb=ctb=false;
                wlb=true;
                ln+=":   ";
                fi++;
                listB.add(l+"{");
                l+="    ";
            }
            else if(st.equals("do"))
            {            
                fnb=ifb=csb=dftb=flb=wlb=elifb=elb=ctb=false;
                dob=true;
                ln+=":   ";
                fi++;
                listB.add(l+"{");
                l+="    ";
            }
            else if(st.startsWith("switch(")&&st.endsWith(")"))
            {
                fnb=ifb=csb=dftb=flb=wlb=elifb=elb=dob=ctb=false;
                swb=true;
                ln+=":   ";
                fi++;
                listB.add(l+"{");
                l+="    ";
            }
            else if(st.startsWith("case")&&st.endsWith(":")&&swb==true)
            {
                fnb=ifb=dob=dftb=flb=wlb=elifb=elb=ctb=false;
                csb=true;
                ln+=":   ";
                fi++;
                listB.add(l);
                l+="    ";
            }
            else if(st.startsWith("default")&&st.endsWith(":")&&swb==true)
            {
                fnb=ifb=csb=dftb=flb=wlb=elifb=elb=ctb=false;
                dftb=true;
                ln+=":   ";
                fi++;
                listB.add(l);
                l+="    ";
            }
            if(!st.equalsIgnoreCase("-e"))
            {
                if(fi>-1)
                    listB.add(l+st);
            }
            if((st.equalsIgnoreCase("-e"))||(swb==true&&st.equals("break;")))
            {
                for(int i=listB.size()-1;i>-1;i--)
                {
                    if(listB.get(i).equals("do")&&dob==true)
                    {
                        dob=false;
                        
                        break;
                    }
                    else if((listB.get(i).substring(listB.get(i).indexOf(" ")+1).startsWith(cln+"(")
                    ||listB.get(i).startsWith(cln+"("))&&st.endsWith(")")&&ctb==true)
                    {
                        ctb=false;
                        clb=true;
                        break;
                    }
                    else if(listB.get(i).startsWith("whlie(")&&listB.get(i).endsWith(")")&&wlb==true)
                    {
                        wlb=false;
                        break;
                    }
                    else if(listB.get(i).startsWith("for(")&&listB.get(i).endsWith(")")&&flb==true)
                    {
                        flb=false;
                        break;
                    }
                    else if(listB.get(i).startsWith("class ")&&clb==true)
                    {
                        clb=false;
                        break;
                    }
                    else if(listB.get(i).startsWith("switch(")&&listB.get(i).endsWith(")")&&swb==true)
                    {
                        swb=false;
                        break;
                    }
                    else if(listB.get(i).startsWith("case")&&listB.get(i).endsWith(":")&&csb==true)
                    {
                        csb=false;
                        
                        break;
                    }
                    else if(listB.get(i).startsWith("default")&&listB.get(i).endsWith(":")&&dftb==true)
                    {
                        dftb=false;
                        otclb=false;
                        break;
                    }
                    else if(listB.get(i).startsWith("if(")&&listB.get(i).endsWith(")")&&ifb==true)
                    {
                        ifb=false;
                        otclb=false;
                        break;
                    }
                    else if(listB.get(i).startsWith("else if(")&&listB.get(i).endsWith(")")&&elifb==true)
                    {
                        elifb=false;
                        otclb=false;
                        break;
                    }
                }
                try
                {
                    ln=ln.substring(0,ln.lastIndexOf(":"));
                }catch(StringIndexOutOfBoundsException e){ }
                fi--;
                try
                {
                    l=l.substring(0,l.lastIndexOf(" ")-3);
                }catch(StringIndexOutOfBoundsException e){ }
                listB.add(l+"}");
            }
            System.out.print(ln);
            listB.add(st);
        }while(((!st.equalsIgnoreCase("-e"))||(fi>-1)));
        return bd=(String[])listB.toArray(new String[listB.size()]);
    }
    protected static String[] ibody()
    {
        String[] bd;
        String st="";
        boolean inStatic = false;
        do
        {
            Scanner bsc = new Scanner(System.in);
            st=bsc.nextLine();
            st=st.trim();
            if(st.equals("static"))
                
            if(!st.equalsIgnoreCase("-e"))
                list2.add("    "+st);            
        }while(!st.equalsIgnoreCase("-e"));
        return bd=(String[])list2.toArray(new String[list2.size()]);
    }
    protected static String[] fbody()
    {
        int fi = 0;
        String[] bd;
        list.add("{");
        ArrayList<String> lines = new ArrayList();
        String st="",ln="",l="    ";
        boolean dob = false,sh=false;
        do
        {
            Scanner bsc = new Scanner(System.in);
            st=bsc.nextLine();
            st=st.trim();
            if(st.startsWith("sop(")&&st.endsWith(");"))
                st="System.out.print"+st.substring(st.indexOf("("));
            else if(st.startsWith("sopln(")&&st.endsWith(");"))
                st="System.out.println"+st.substring(st.indexOf("("));
            if(!st.equalsIgnoreCase("-e"))
            {
                if(fi>-1)
                    list.add(l+st);
            }
            if(st.startsWith("if(")&&st.endsWith(")"))
            {
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if(st.startsWith("for(")&&st.endsWith(")"))
            {
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if(st.startsWith("while(")&&st.endsWith(")"))
            {
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if(st.equals("do"))
            {
                dob=true;
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if(st.startsWith("switch(")&&st.endsWith(")"))
            {
                sh=true;
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if(st.startsWith("case")&&st.endsWith(":")&&sh==true)
            {
                ln+=":   ";
                fi++;
                list.add(l);
                l+="    ";
            }
            if(st.startsWith("default")&&st.endsWith(":"))
            {
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if((st.equalsIgnoreCase("-e"))||(sh==true&&st.equals("break;")))
            {
                if(st.equalsIgnoreCase("-e"))
                    dob=sh=false;
                try
                {
                    ln=ln.substring(0,ln.lastIndexOf(":"));
                }catch(StringIndexOutOfBoundsException e){ }
                fi--;
                try
                {
                    l=l.substring(0,l.lastIndexOf(" ")-3);
                }catch(StringIndexOutOfBoundsException e){ }
                list.add(l+"}");
            }
            
            System.out.print(ln);
            lines.add(st);
        }while(((!st.equalsIgnoreCase("-e"))||(fi>-1)));
        return bd=(String[])list.toArray(new String[list.size()]);
    }
    protected static String[] cbody()
    {
        int fi = 0;
        String[] bd;
        list.add("{");
        ArrayList<String> lines = new ArrayList();
        String st="",ln="",l="    ";
        boolean dob = false,sh=false;
        do
        {
            Scanner bsc = new Scanner(System.in);
            st=bsc.nextLine();
            st=st.trim();
            if(st.startsWith("sop(")&&st.endsWith(");"))
                st="System.out.print"+st.substring(st.indexOf("("));
            else if(st.startsWith("sopln(")&&st.endsWith(");"))
                st="System.out.println"+st.substring(st.indexOf("("));
            if(!st.equalsIgnoreCase("-e"))
            {
                if(fi>-1)
                    list.add(l+st);
            }
            if(st.startsWith("if(")&&st.endsWith(")"))
            {
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if(st.startsWith("for(")&&st.endsWith(")"))
            {
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if(st.startsWith("while(")&&st.endsWith(")"))
            {
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if(st.equals("do"))
            {
                dob=true;
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if(st.startsWith("switch(")&&st.endsWith(")"))
            {
                sh=true;
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if(st.startsWith("case")&&st.endsWith(":")&&sh==true)
            {
                ln+=":   ";
                fi++;
                list.add(l);
                l+="    ";
            }
            if(st.startsWith("default")&&st.endsWith(":"))
            {
                ln+=":   ";
                fi++;
                list.add(l+"{");
                l+="    ";
            }
            if((st.equalsIgnoreCase("-e"))||(sh==true&&st.equals("break;")))
            {
                if(st.equalsIgnoreCase("-e"))
                    dob=sh=false;
                try
                {
                    ln=ln.substring(0,ln.lastIndexOf(":"));
                }catch(StringIndexOutOfBoundsException e){ }
                fi--;
                try
                {
                    l=l.substring(0,l.lastIndexOf(" ")-3);
                }catch(StringIndexOutOfBoundsException e){ }
                list.add(l+"}");
            }
            
            System.out.print(ln);
            lines.add(st);
        }while(((!st.equalsIgnoreCase("-e"))||(fi>-1)));
        return bd=(String[])list.toArray(new String[list.size()]);
    }
    protected static void closeTml()
    {
        try
        {
            Robot r = new Robot();
            r.keyPress(17);
            r.keyPress(KeyEvent.VK_W);
            r.keyRelease(17);
            r.keyRelease(KeyEvent.VK_W);
        }catch(AWTException e){}
    }
     static int checkSmlr(String s1, String s2)
    {
        int ch = -1, lc = s1.compareTo(s2), s1l = s1.length(), s2l = s2.length();
        if(lc<0)
        {
            for(int i = 0;i<s1l;i++)
            {
                if(s1.charAt(i)==s2.charAt(i))
                    ch=0;
                else if(s1.charAt(i)<s2.charAt(i))
                {
                    ch=1;
                    break;
                }
                else
                {
                    ch=2;
                    break;
                }
            }
        }
        return ch;
    }
    protected static String getPri(String ar[],int index)
    {
        String st=null;
        for(int i = index-1;i>0;i--)
        {
            st=ar[i];
            if(st!=null)
            {
                if(st.startsWith("if(")&&st.endsWith(")"))
                    break;
                else if(st.startsWith("class "))
                    break;
                else if((st.substring(st.indexOf(" ")+1).startsWith(cln+"(")||
                    st.startsWith(cln+"("))&&st.endsWith(")"))
                    break;
                else if(st.startsWith("else if(")&&st.endsWith(")"))
                    break;
                else if(st.equals("else"))
                    break;
                else if(st.startsWith("for(")&&st.endsWith(")"))
                    break;
                else if(st.startsWith("while(")&&st.endsWith(")"))
                    break;
                else if(st.equals("do"))
                    break;
                else if(st.startsWith("switch(")&&st.endsWith(")"))
                    break;
            }
        }
        return st;
    }
    protected static int idxOfPri(String[] ar,int index)
    {
        String st=null;
        int i;
        for(i = index-1;i>0;i--)
        {
            st=ar[i];
            if(st!=null)
            {
                if(st.startsWith("if(")&&st.endsWith(")"))
                    break;
                else if(st.startsWith("class "))
                    break;
                else if((st.substring(st.indexOf(" ")+1).startsWith(cln+"(")||
                    st.startsWith(cln+"("))&&st.endsWith(")"))
                    break;
                else if(st.startsWith("else if(")&&st.endsWith(")"))
                    break;
                else if(st.equals("else"))
                    break;
                else if(st.startsWith("for(")&&st.endsWith(")"))
                    break;
                else if(st.startsWith("while(")&&st.endsWith(")"))
                    break;
                else if(st.equals("do"))
                    break;
                else if(st.startsWith("switch(")&&st.endsWith(")"))
                    break;
            }
        }
        return i;
    }
}