package Qn3;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("NUMBER OF 'x' IN A STRING:");
        String x = "xxhixx";
        String y = "xhixhix";
        String z = "hi";
        System.out.print(Count.Counter(x));
        System.out.println(" times in String "+x);

        System.out.print(Count.Counter(y));
        System.out.println(" times in String "+y);

        System.out.print(Count.Counter(z));
        System.out.println(" times in String "+z);
    }
}
