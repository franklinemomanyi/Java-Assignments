package SoftwareEngineering;
import java.util.Scanner;
public class GradeCalculator
{
    public static void main(String[] args) {
        int process = options();
        while(process==1)
        {
            input();
            process = options();
        }
    }

    private static int options() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("PLEASE SELECT AN OPTION");
        System.out.println("1.Grading.");
        System.out.println("0.Log Out.");
        return in.nextInt();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("PLEASE ENTER A NUMERICAL RESULT:");
        int num = sc.nextInt();
        System.out.println("STUDENT SCORE: "+ getGrade(num));
    }

    public static String getGrade(int num)
    {
        String Grade = null;
        if (num>=80 && num<=100)
            Grade = "GRADE A";
        else if (num>=65 && num<=79)
            Grade = "GRADE B";
        else if (num>=50 && num<=64)
            Grade = "GRADE C";
        else if (num>=0 && num<=49)
            Grade = "GRADE D";
        else
            Grade = "INVALID ENTRY!";
        return Grade;
    }
}
