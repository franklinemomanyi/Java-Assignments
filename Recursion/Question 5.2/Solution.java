package Qn5SolutionTwo;

public class Solution
{
    public static String Solve(String string)
    {
        if (!string.contains("(") && !string.contains(")"))
        {
            return null;
        }
        return string.substring(string.indexOf("("),string.indexOf(")")+1);
    }

}
