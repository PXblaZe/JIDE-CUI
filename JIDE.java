public class JIDE
{
    public static void main(String[] args)throws Exception
    {
        Process.build();
        Thread.sleep(1000);
        Func.closeTml();
        Thread.sleep(1000);
        Func.resetJVM();
    }
}