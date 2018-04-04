import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
class Process
{
    private static int np,nc,nf;
    
    private ArrayList<String[]> ctlbd = new ArrayList<>();
    private static String clName,
    body[][],
    pkg="",inbd[],
    sta,fnbd[],
    fnabd[]=new String[100000],
    ctabd[]=new String[100000],
    staa[]=new String[100000],
    pkga[]=new String[100000],
    rtp,fnName,
    rta[]=new String[100000],ctpr="",
    ctpra[]=new String[100000],
    mdc="",cp="",cpa[]=new String[100000],
    mdfa[]=new String[100000],
    ftpr,ftpra[]=new String[100000],
    mdf="",fp="",fpa[]=new String[100000],
    mdcta[]=new String[100000],ctbd[],ftbd[];
    private static void pkgImp()
    {
        Scanner ios = new Scanner(System.in);
        String pk;
        System.out.print("Number of package(s) need to be imported:~ ");
        try{np=ios.nextInt();}catch(InputMismatchException e){System.out.println("Error: "+e);}
        if(np==1)
        {
            System.out.print("Enter a package name(Press[*]to import default pkg java.lang):~ ");
            pk = ios.next();
            if(pk.equals("*"))
                pkg="import java.lang.*;";
            else
                if(pk.charAt(pk.length()-1)!='*')
                    pkg="import "+pk+";";
                else
                    pkg="import "+pk+".*;";
        }
        else if (np<0)
        {
            System.out.print("Invalid Input: Please enter a whole number.");
            pkgImp();
        }
        for(int pkgi = 0;np>1&&pkgi<np;pkgi++)
        {
            System.out.print("Enter package name to be imported:~ ");
            pk = ios.next();
            pkga[pkgi]="import java."+pk+".*;";
        }
    }
    private static void getClField()
    {
        Scanner sc = new Scanner(System.in); 
        System.out.println("Do you like to use instane variable(s) for this class(Y/n):~ ");
        String op = sc.next();
        if(op.equalsIgnoreCase("Y"))
        {
			System.out.println("Class Field:~ ");
            inbd = Func.ibody();
        }
    }
    private static void getClName()
    {
        Scanner ios = new Scanner(System.in);
        System.out.print("Enter class name:~ ");
        clName = ios.next();
    }
    private static void getConst()
    {
        Scanner ios = new Scanner(System.in);
        Scanner ios2 = new Scanner(System.in);
        String ctm,ctp,ctb;
        System.out.print("Number of constructor(s) need to be imported:~ ");
        try{nc=ios.nextInt();}catch(InputMismatchException e){System.out.println("Error: "+e);}
        if(nc==1)
        {
            System.out.print("Enter a modifier for constructor(Press[*] for default):~ ");
            ctm = ios.next();
            if(ctm.equals("*"))
                mdc=" "+clName;
            else
                mdc=ctm+" "+clName;
            System.out.print("Enter the parameter of this constructor(Press[*] to make it non-parameterized one):~ ");
            ctp=ios2.nextLine();
            if(ctp.equals("*"))
                cp="()";
            else
                cp="("+ctp+")";
            ctpr = mdc+cp;
        }
        else if (nc<=0)
        {
            System.err.println("Invalid Input: Please enter a natural number.");
            getConst();
        }
        for(int cti = 0;nc>1&&cti<nc;cti++)
        {
            if((((cti+1)%10)==0))
                System.out.print("Enter a modifier for "+(cti+1)+"th constructor:~ ");
            else if((((cti+1)%10)==1))
                System.out.print("Enter a modifier for "+(cti+1)+"st constructor:~ ");
            else if((((cti+1)%10)==2))
                System.out.print("Enter a modifier for "+(cti+1)+"nd constructor:~ ");
            else if((((cti+1)%10)==3))
                System.out.print("Enter a modifier for "+(cti+1)+"rd constructor:~ ");
            else
                System.out.print("Enter a modifier for "+(cti+1)+"th constructor:~ ");
            ctm = ios.next();
            mdcta[cti]=ctm+" "+clName;
            System.out.print("Enter the parameter of this constructor(Press[*] to make it non-parameterized one):~ ");
            ctp=ios2.nextLine();
            if(ctp.equals("*"))
                cpa[cti]="()";
            else
                cpa[cti]="("+ctp+")";
            ctpra[cti]=mdcta[cti]+cpa[cti];
        }
        ios.close();
        ios2.close();
    }
    
    private static void constBody()
    {
        System.out.println("Write the body of this constructor:~ ");
        ctbd = Func.cbody();
        for(int i = 0;i<ctbd.length;i++)
        {
            ctbd[i]="    "+ctbd[i];
        }
    }
    private static void getMeth()
    {
        Scanner ios = new Scanner(System.in);
        Scanner ios2 = new Scanner(System.in);
        String fnm,fnp,fnb,stic,rt,fnn;
        System.out.print("Number of method(s) need to be imported:~ ");
        try{nf=ios.nextInt();}catch(InputMismatchException e){System.out.println("Error: "+e);}
        if(nf==1)
        {
            System.out.print("Enter a modifier for method(Press[*] for default):~ ");
            fnm = ios.next();
            if(fnm.equals("*"))
                mdf="";
            else
                mdf=fnm;
            System.out.print("Enter a name of this method:~ ");
            fnn = ios.next();
            fnName=fnn;
            System.out.print("Do you like to make this method as static (Y/n):~ ");
            stic = ios.next();
            if(stic.equalsIgnoreCase("Y"))
                sta = "static";
            else if(stic.equalsIgnoreCase("n"))
                sta = "";
            else
            {
                System.err.println("Error: Invalid Input");
                System.err.println("This may cause error in program please reset JVM and try again.");
            }
            System.out.print("Enter the return type of this method(Press[*] for void):~ ");
            rt=ios.next();
            if(rt.equals("*"))
                rtp="void";
            else
                rtp=rt;
            System.out.print("Enter the parameter of this method(Press[*] to make it non-parameterized one):~ ");
            fnp=ios2.nextLine();
            if(fnp.equals("*"))
                fp="()";
            else
                fp="("+fnp+")";
            ftpr = mdf+" "+sta+" "+rtp+" "+fnName+fp;
            
        }
        else if (nf<=0)
        {
            System.out.print("Invalid Input: Please enter a natural number.");
            getConst();
        }
        for(int fni = 0;nf>1&&fni<nf;fni++)
        {
            if((((fni+1)%10)==0))
                System.out.print("Enter a modifier for "+(fni+1)+"th method:~ ");
            else if((((fni+1)%10)==1))
                System.out.print("Enter a modifier for "+(fni+1)+"st method:~ ");
            else if((((fni+1)%10)==2))
                System.out.print("Enter a modifier for "+(fni+1)+"nd method:~ ");
            else if((((fni+1)%10)==3))
                System.out.print("Enter a modifier for "+(fni+1)+"rd method:~ ");
            else
                System.out.print("Enter a modifier for "+(fni+1)+"th method:~ ");
            fnm = ios.next();
            mdfa[fni]=fnm;
            System.out.print("Do you like to make this method as static (Y/n):~ ");
            stic = ios.next();
            if(stic.equalsIgnoreCase("Y"))
                staa[fni] = "static";
            else if(stic.equalsIgnoreCase("n"))
                staa[fni] = "";
            else
            {
                System.err.println("Error: Invalid Input");
                System.err.println("This may cause error in program please reset JVM and try again.");
            }
            System.out.print("Enter the return type of this method(Press[*] for void):~ ");
            rt=ios.next();
            if(rt.equals("*"))
                rta[fni]="()";
            else
                rta[fni]="("+rt+")";
            System.out.print("Enter the parameter of this method(Press[*] to make it non-parameterized one):~ ");
            fnp=ios2.nextLine();
            if(fnp.equals("*"))
                fpa[fni]="()";
            else
                fpa[fni]="("+fnp+")";
            ctpra[fni]=mdfa[fni]+" "+staa[fni]+" "+rta[fni]+" "+fpa[fni];
        }
        ios.close();
        ios2.close();
    }
    private static void methBody()
    {
        System.out.println("Write the body of this method:~ ");
        fnbd = Func.fbody();
        for(int i = 0;i<fnbd.length;i++)
        {
            fnbd[i]="    "+fnbd[i];
        }
    }
    private static String[] config()
    {
        ArrayList l  = new ArrayList();
        String s[];
        pkgImp();
        getClName();
        getClField();
        getConst();
        constBody();
        getMeth();
        methBody();
        if(np==1||np==0)
            l.add(pkg);
        l.add("class "+clName);
        l.add("{");
        if(inbd!=null)
        {
            for(int i = 0;i<inbd.length;i++)
                l.add(inbd[i]);
        }
        if(nc==1)
        {
            l.add("    "+ctpr);
            for(int i=0;i<ctbd.length;i++)
                l.add(ctbd[i]);
        }
        if(nf==1)
        {
            l.add("    "+ftpr);
            for(int i=0;i<fnbd.length;i++)
                l.add(fnbd[i]);
        }
        l.add("}");
        return s=(String[])l.toArray(new String[l.size()]);
    }
    protected static void build()
    {
        String st[]=config();
        IOsis.outsis(st,clName+".java");
    }
}