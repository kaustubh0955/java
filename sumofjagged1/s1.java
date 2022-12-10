package sumofjagged1;

public class s1
{
    public static void main(String args[])
    {
        int r[][]={{1,1,1,1},{2,2,2,},{3,3,3,3}};
        sumofjagged(r);
    }   
    public static void sumofjagged(int k[][])
    {
        int sumofrow=0;
        for(int h[]:k)
        {
            for(int s:h)
            {
                sumofrow+=s;
            }
            System.out.println("The sum is:"+sumofrow);
            sumofrow=0;
        }
    }
}
