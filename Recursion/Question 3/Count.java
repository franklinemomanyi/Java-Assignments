package Qn3;

public class Count
{
    public static int Counter(String name)
    {
        if (!name.contains("x"))
        {
            return 0;
        }
        if (name.charAt(0) == 'x')
        {
            return 1 + Counter(name.substring(1));
        }
        return Counter(name.substring(1));
    }
}
