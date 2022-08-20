import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        String firstname = null, lastname = null, course = null;
        int grades[] = new int[5];
        int fail = 0;

        student stud = new student(lastname, firstname, course, grades);

        Scanner in = new Scanner(new FileReader("students.txt"));
        
        ArrayList<String> list = new ArrayList<String>();

        while(in.hasNextLine()){

            lastname = in.nextLine();
            firstname = in.nextLine();
            course = in.nextLine();
            
            for(int i = 0; i < 5; i++)
                grades[i] = in.nextInt();

            if(in.hasNextLine())
                in.nextLine();
                
            stud = new student(lastname, firstname, course, grades);
            stud.hasFailingGrade();

            if(stud.hasFailingGrade() == false)
                fail++;
            
            stud.showDetails();

            list.add(stud.toListDetails());

            for(int index = 0; index < 5; index++)
                list.add(stud.toListGrades(index));
        }
        System.out.print(fail + " Student/s have failed subjects.");
        // for(String i : list)
        // System.out.println(i);
    }
}