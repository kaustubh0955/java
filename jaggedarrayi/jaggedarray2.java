package jaggedarrayi;
import java.util.*;
public class jaggedarray2 
{
    public static void main(String args[])
    {
        System.out.println("Enter the number of rows for the array");
        Scanner input=new Scanner(System.in);
        int numrows=input.nextInt();
        int a[][]=new int[numrows][];
        int rowlength=0;
        for(int i=0;i<numrows;i++)
        {
            System.out.println("Enter the size of the row");
            rowlength=input.nextInt();
            a[i]=new int[rowlength];
        }
        System.out.println("Enter the elements for the jagged array");
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                a[i][j]=input.nextInt();
            }
        }
        for(int[]k:a)
        {
            for(int s:k)
            {
                System.out.println(s);
            }
            System.out.println();
        }
    }   
}
