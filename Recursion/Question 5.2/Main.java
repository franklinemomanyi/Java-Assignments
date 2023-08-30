package Qn5SolutionTwo;

public class Main
{
    public static void main(String[] args)
    {
        String x = "xyz(abc)123", y = "x(hello)", z = "(xy)1";
        System.out.println(Solution.Solve(x)+" in string "+x);
        System.out.println(Solution.Solve(y)+" in string "+y);
        System.out.println(Solution.Solve(z)+" in string "+z);
    }
}
