//yohay elmakis//
import java.util.Scanner;
public class Triangle1
{
 public static void main (String [] args)
 {
 //this program recieve the lentghs of the triangle sides and calculate the perimeter and the area of the triangle//
 Scanner scan = new Scanner (System.in);
 System.out.println ("This program calculates the area "
 + "and the perimeter of a given triangle. ");
 System.out.println ("Please enter the three lengths"
 + " of the triangle's sides");
 // represent variables as integers
 int a = scan.nextInt();
 int b = scan.nextInt();
 int c = scan.nextInt();
 double s,k; //represent s and k as double because they might be not a whole number
 s =(double) (a + b + c) / 2;  // this line calculate the area of the triangle and put half of the value in s
 k = (s * (s-a) * (s-b) * (s-c)); // this line use the half of the area to calculate the perimeter of the triangle and put it as k
 //taking k to the power of 2 and then square root it twice to arease the minus if there is a one
 k = Math.pow(k,2);
 k = Math.sqrt(k);
 k = Math.sqrt(k);
 System.out.println("The lengths of the triangle sides are: " + a + "," + b + "," + c); 
 s=s*2; // making s my half area 2 times bigger to get s to represent area
 System.out.println("The perimeter of the triangle is: " + s);
 System.out.println("The area of the triangle is: " + k );

 } // end of method main
} //end of class Triangle