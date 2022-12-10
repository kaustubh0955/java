package arrayofobjects;
import java.util.*;
public class main 
{
    public static void main(String args[])
    {

            students[] s=new students[2];
            for(int i=0;i<s.length;i++)
            {
                s[i]=new students();
            }
            for(int i=0;i<s.length;i++)
            {
                s[i].set_profile();
            }
            for(int i=0;i<s.length;i++)
            {
                s[i].view_profile();
            }
            students.search_students(s);
            students.sorting(s);
    }    
}
class students
{
    public String name;
    public String regno;
    public String city;
    
        public void set_profile()
        {
                Scanner input=new Scanner(System.in);
                System.out.println("Enter the name of the students:");
                this.name=input.next();
                System.out.println("Enter the registration number: ");
                this.regno=input.next();
                System.out.println("Enter the city:");
                this.city=input.next();
        }
    public void view_profile()
    {
        System.out.println(this.name+this.regno+this.city);
    }
    public static void search_students(students[] t)
    {
        boolean found=false;
        for(int i=0;i<t.length;i++)
        {
            if(t[i].city.equals("vellore"))
            {
                System.out.println(t[i].name);
                found=true;
            }
        }
        if(!found)
        {
            System.out.println("No students from vellore found");
        }
    }
    public static void sorting(students[] k)
    {
        students temp=new students();
        for(int i=0;i<k.length;i++)
        {
            for(int j=0;j<k.length-1-i;j++)
            {
                if(k[j].name.compareTo(k[j+1].name)>0)
                {
                    temp=k[j];
                    k[j]=k[j+1];
                    k[j+1]=temp;
                }
            }
        }
    }
}
