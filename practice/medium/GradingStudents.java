package medium;

public class GradingStudents {

    /*
     * Grading Students
     */
    static int[] gradingStudents(int[] grades) {
        for(int i = 0; i < grades.length; i++){

            int ele = grades[i];

            if(i < 38){
                continue;
            }
            int r = ele % 5;
            if(r > 2){
                grades[i] = ele + 5 - r;
            }
        }
        return grades;
    }



}
