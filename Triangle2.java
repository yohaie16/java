//yohay elmakis//
import java.util.Scanner;
public class Triangle2
{
 public static void main (String [] args)
 {
 //*This program takes the lentghs of a triangle and by mathematical rules returns the type of the triangle *//
 Scanner scan = new Scanner (System.in);
 double X,Y,Z; //* variables as double - lentgh might be not an integer*//
 X = scan.nextInt();
 Y = scan.nextInt();
 Z = scan.nextInt();
 if (Z==Y && Z==X) // check if all lines are equals//
 System.out.println("The numbers: " + X + " , " + Y + " and " + Z + " represent an equilateral triangle"); 
 else if ((Z==Y && X != Z) || (Z==X && Z != Y) || (X==Y && X != Z))// check if only 2 lines are equals//
 System.out.println("The numbers: " + X + " , " + Y + " and " + Z + " represent an isosceles triangle"); 
 else if (Math.sqrt(Math.pow(X,2) + Math.pow(Y,2)) == Z || (Math.sqrt(Math.pow(X,2) + Math.pow(Z,2)) == Y || (Math.sqrt(Math.pow(Z,2) + Math.pow(Y,2)) == X)))//check if pythagorean theorem works//
 System.out.println("The numbers: " + X + " , " + Y + " and " + Z + " represent an right-angle triangle");
 else if (X + Y <= Z || X + Z <= Y || Y + Z <= X) //check if these 3 lines can represent triangle by mathematical rule//
 System.out.println("The numbers: " + X +  " , " + Y + " and " + Z + " cannot represent a triangle");
 else System.out.println("The numbers: " + X + " , " + Y + " and " + Z + " represent a common triangle");//when none of the rules above works returns an output of a common triangle//
 
 
 
 
 
}
}