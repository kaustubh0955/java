package Exception1;
import java.util.*;
public class main 
{
    public static void main(String args[])
    {
        try
        {
            student satish=new student();
        }
        catch(InputMismatchException e)
        {
          System.out.println("Enter the correct input");  
        }
    }    
}
class student
{
    String name;
    int marks;
    public student() throws InputMismatchException
    {
        System.out.println("Enter the name");
        Scanner input=new Scanner(System.in);
        this.name=input.next();
        System.out.println("Enter the marks");
        this.marks=input.nextInt();
    }
    public void test() throws ArithmeticException,InputMismatchException
    {
        System.out.println(4/0);
    }
}