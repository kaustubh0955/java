package Assessment2;


import java.util.*;
import java.io.*;
public class q5 {
    public static void main(String[] args){
        try{
            Scanner input = new Scanner(System.in);
            String name, gender;
            int rollNum;
            
            ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("file.txt"));
            ObjectOutputStream objout1 = new ObjectOutputStream(new FileOutputStream("file1.txt"));
            ObjectOutputStream objout2 = new ObjectOutputStream(new FileOutputStream("file2.txt"));

            ObjectInputStream objin = new ObjectInputStream(new FileInputStream("file.txt"));
            ObjectInputStream objin1 = new ObjectInputStream(new FileInputStream("file1.txt"));
            ObjectInputStream objin2 = new ObjectInputStream(new FileInputStream("file2.txt"));
            
            student[] s1 = new student[2];
            student[] s2 = new student[2];

            setFile(input, objout1, s1);
            objout1.writeObject(new endofffile());
            objout1.close();
            setFile(input, objout2, s2);
            objout2.writeObject(new endofffile());
            objout2.close();

            student[] s = new student[s1.length+s2.length];

            Object objc = null;
            int i=0;
            while(!((objc = objin1.readObject()) instanceof endofffile)){
                s[i] = (student)objc;
                objout.writeObject(s[i]);
                i++;
            }

            objc = null;
            while(!((objc = objin2.readObject()) instanceof endofffile)){
                s[i] = (student)objc;
                objout.writeObject(s[i]);
                i++;
            }

            objout.writeObject(new endofffile());
            objout.close();

            ArrayList<String> t = new ArrayList<String>();
            ArrayList<String> m = new ArrayList<String>();
            ArrayList<String> f = new ArrayList<String>();

            objc = null;
            while(!((objc = objin.readObject()) instanceof endofffile)){
                System.out.println(((student)objc).name+((student)objc).gender+((student)objc).rollNum);
                t.add(((student)objc).name);

                if(Objects.equals(((student) objc).gender, "Male")){
                    m.add(((student)objc).name);
                }

                if(Objects.equals(((student) objc).gender, "Female")){
                    f.add(((student)objc).name);
                }

            }

            Collections.sort(t);
            String[] array = t.toArray(new String[0]);

            System.out.println("---------------Now Sorting by Name------------");

            for(String q:array){
                System.out.print(q+" ");
            }

            System.out.println();

            System.out.println("---------------Now Displaying Info------------");

            System.out.println("Male Students are: ");
            System.out.println(m);

            System.out.println("Female Students are: ");
            System.out.println(f);


        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void setFile(Scanner input, ObjectOutputStream objoutx, student[] ss) throws IOException {
        String name;
        int rollNum;
        String gender;
        for(int i = 0; i<ss.length; i++){
            System.out.println("Enter name");
            name = input.next();
            System.out.println("Enter rollNum");
            rollNum = input.nextInt();
            System.out.println("Enter gender");
            gender = input.next();
            
            ss[i] = new student(name, gender, rollNum);
            objoutx.writeObject(ss[i]);
        }
    }

}

class student implements Serializable{
    String name;
    String gender;
    int rollNum;

    public student(String name, String gender, int rollNum) {

        this.name = name;
        this.gender = gender;
        this.rollNum = rollNum;
    }

}

class endofffile implements Serializable{
}