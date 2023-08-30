package Qn4;

public class Solve
{
    public static int Sol(int num)
    {
        if (num<=1)
        {
            return num;
        }
        return num + Sol(num-1);
    }
}
