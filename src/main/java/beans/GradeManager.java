package beans;

import jakarta.ejb.Stateless;

@Stateless
public class GradeManager {

    public String getGrade(int mark) {

        if (mark < 0 || mark > 100) {
            return "Invalid Mark";
        }

        if (mark >= 75) {
            return "A";
        } else if (mark >= 65) {
            return "B";
        } else if (mark >= 55) {
            return "C";
        } else if (mark >= 45) {
            return "D";
        } else {
            return "F";
        }
    }
}
