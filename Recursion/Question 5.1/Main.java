package Qn5SolutionOne;

public class Main
{
    public static void main(String[] args)
    {
        String x = "xyz(abc)123", y = "x(hello)", z = "(xy)1";
        System.out.println(Solution.Counter(x)+" in string "+x);
        System.out.println(Solution.Counter(y)+" in string "+y);
        System.out.println(Solution.Counter(z)+" in string "+z);
    }
}
