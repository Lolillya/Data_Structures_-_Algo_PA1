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
        
        ArrayList<student> list = new ArrayList<student>();

        while(in.hasNext()){

            lastname = in.nextLine();
            firstname = in.nextLine();
            course = in.nextLine();
            
            for(int i = 0; i < 5; i++)
            grades[i] = in.nextInt();
            
            stud = new student(lastname, firstname, course, grades);
            list.add(stud);
            
            if(in.hasNextLine())
            in.nextLine();
            
            stud.hasFailingGrade();
            
            if(stud.hasFailingGrade() == true)
            fail++;
            
            stud.showDetails();
        }

        for(student ii : list){
            System.out.println(ii.studDetails());
            System.out.println(Arrays.toString(ii.studGrades()) + "\n");
        }

        System.out.println();
        System.out.print(fail + " Student/s have failed subjects.");
    }
}