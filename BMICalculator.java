package SoftwareEngineering;

import java.util.Scanner;

public class BMICalculator
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
        System.out.println("1.BMI Calculator.");
        System.out.println("0.Log Out.");
        return in.nextInt();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("PLEASE ENTER YOUR WEIGHT(Kilograms):");
        float weight = sc.nextFloat();
        System.out.println("PLEASE ENTER YOUR HEIGHT(Meters):");
        float height = sc.nextFloat();


        System.out.println("YOUR BMI IS : "+ getBMI(weight, height)+" Kg/m2");
    }

    public static float getBMI(float weight,float height)
    {
        return (weight/(height*height));
    }
}
