import java.util.Scanner;
import java.util.StringTokenizer;
class Security
{
    protected static boolean login()
    {
        boolean cu,cp;
        cu=cp=false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Username :");
        String lpn=sc.next();
        System.out.print("Password :");
        String lpp=sc.next();
        String[] admindata = new String[Integer.valueOf(IOsis.insis("Total_logins.tln"))];
        String ru,rp;
        for(int i=1;i<=admindata.length;i++)
        {
            String data = IOsis.insis("admin"+i+".data");
            StringTokenizer st = new StringTokenizer(data);
            ru = st.nextToken();
            rp = st.nextToken();
            if(ru.equals(lpn)&&rp.equals(lpp))
            {
                cu=cp=true;
                break;
            }
        }
        return ((cu==true)&&(cp==true))?true:false;
    }
    protected static void accAdd()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("First name :");
        String fn = sc.next();
        System.out.print("Last name :");
        String ln = sc.next();
        System.out.println("Date Of Birth :-");
        System.out.print("Day :");
        String dy = sc.next();
        System.out.print("Month :");
        String mn = sc.next();
        System.out.print("Year :");
        String yr = sc.next();
        System.out.print("Username :");
        String un = sc.next();
        System.out.print("Password :");
        String pw = sc.next();
        long tp = Long.valueOf(IOsis.insis("Total_logins.tln"));
        IOsis.outsis(un+" ","admin"+(tp+1)+".data");
        IOsis.outsisAdd(pw+" ","admin"+(tp+1)+".data");
        IOsis.outsisAdd(fn+" ","admin"+(tp+1)+".data");
        IOsis.outsisAdd(ln+" ","admin"+(tp+1)+".data");
        IOsis.outsisAdd(dy+" ","admin"+(tp+1)+".data");
        IOsis.outsisAdd(mn+" ","admin"+(tp+1)+".data");
        IOsis.outsisAdd(yr,"admin"+(tp+1)+".data");
        IOsis.outsis(String.valueOf((tp+1)),"Total_logins.tln");
    }
}