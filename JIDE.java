import java.util.Scanner;
public class JIDE
{
    public static void main(String[] args)throws Exception
    {
        boolean log=false;
        Scanner sc = new Scanner(System.in);
        System.out.println("''WelCome to .java file editor''");
        System.out.println("Option                   Press");
        System.out.println("Login                -       1");
        System.out.println("Create new Account   -       2");
        byte k = sc.nextByte();
        if(k==1)
        {
            System.out.println("''Login to your account''");
            log = Security.login();
        }
        else if(k==2)
        {
            Security.accAdd();
            System.out.println("''Login to your account''");
            log = Security.login();
        }
        else
            System.out.println("''Invalid Input''");
        if(log==true)
        {
            System.out.println();
            Process.build();
            Thread.sleep(1000);
            Func.closeTml();
            Thread.sleep(1000);
            Func.resetJVM();
        }
    }
}
