package Qn5SolutionOne;

public class Solution
{
    public static String Counter(String name)
    {
        //System.out.println(name);
        if (!name.contains("(") && !name.contains(")"))
        {
            return null;
        }
        if (name.charAt(0) != '(')
        {
            return Counter(name.substring(1));
        }
        else
        {
            return name.substring(name.indexOf("("),name.indexOf(")")+1);
        }
    }
}
