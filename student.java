public class student {
    
    private String lastName;
    private String firstName;
    private String course;
    private int grades[];

    
    private String arr_Grades[] = new String[5];


    public student(String lastName, String firstName, String course, int[] grades) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
        this.grades = grades;
    }


    public boolean hasFailingGrade(){
        boolean Failed = false;
        float temp1;
        String temp2;

        for(int i = 0; i < grades.length; i++){
            if(this.grades[i] < 75 && Failed == false){
                Failed = true;
                temp1 = this.grades[i];
                temp2 = String.format("%.2f",temp1);
                arr_Grades[i] = temp2 + " Failed";
            }
            else{
                temp1 = this.grades[i];
                temp2 = String.format("%.2f",temp1);
                arr_Grades[i] = temp2 + " Passed";
            }
        }
        return Failed;
    }

    public void showDetails(){
        float average = 0;
        boolean failedStudent = false;

        for(int i = 0; i < this.grades.length; i++){
            average += this.grades[i];
            
            if(this.grades[i] < 75 && failedStudent == false){
                System.out.println("Name: " + this.lastName + ',' + this.firstName);
                System.out.println("Course: " + this.course);
                System.out.println(this.arr_Grades[i]);
                failedStudent = true;
            }
        }
        if(failedStudent == true){
            System.out.println("Average: " + String.format("%.2f",(average/this.grades.length)) + "\n");
        }
    }

    public String studDetails(){
        return "Name: " + lastName + ", " + firstName + "\nCourse: " + course;
    }

    public String[] studGrades(){
        return arr_Grades;
    }
}