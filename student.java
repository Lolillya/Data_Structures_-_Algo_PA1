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
        boolean Passed = true;
        String arr_grade;

        for(int i = 0; i < grades.length; i++){
            if(this.grades[i] < 75 && Passed == true){
                Passed = false;
                arr_grade = String.valueOf(this.grades[i] + " Failed");
            }

            else
                arr_grade = String.valueOf(this.grades[i]) + " Passed";

            arr_Grades[i] = arr_grade;
        }
        return Passed;
    }

    public void showDetails(){
        float average = 0;

        System.out.println("Name: " + this.lastName + ',' + this.firstName);
        System.out.println("Course: " + this.course);

        for(int i = 0; i < this.grades.length; i++){
            average += this.grades[i];
            
            if(this.grades[i] < 75)
                System.out.println(this.arr_Grades[i]);
        }
        System.out.println("Average: " + average/this.grades.length + "\n");
    }

    public String toListDetails(){
        return this.lastName + "\n" + this.firstName + "\n" +
        this.course;
    }

    public String toListGrades(int index){
        return arr_Grades[index];
    }
}