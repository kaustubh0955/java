package Exception2;
import java.util.*;
public class main 
{
    public static void main(String args[])
    {
        try
        {
            System.out.println(3/0);
            try
            {
                System.out.println(4/0);
            }
            catch(Exception e)
            {
                System.out.println("handled in the inner block");
            }
        }
        catch(ArithmeticException e)
        {
            System.out.println("handled in the outer block");
        } 
        System.out.println("Thanks for using our software");
    } 
}