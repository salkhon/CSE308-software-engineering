import Errors.InvalidCreditsException;
import Errors.MarksOutOfBoundsException;
import Errors.NonNumberMarksException;

public class Grader {
    public static enum Grade {
        A, B, C, F
    }

    public Grade assignGrade(double credits, double marks) {
        int aLo = Integer.MAX_VALUE, bLo = Integer.MAX_VALUE, cLo = Integer.MAX_VALUE;

        if (credits == 3) {
            aLo = 240;
            bLo = 210;
            cLo = 180;
        } else if (credits == 4) {
            aLo = 320;
            bLo = 280;
            cLo = 240;
        } else {
            throw new InvalidCreditsException();
        }

        if (Double.isNaN(marks)) {
            throw new NonNumberMarksException();
        } else if (marks > 400 || marks < 0) {
            throw new MarksOutOfBoundsException();
        }

        marks = (int) Math.ceil(marks);
        if (marks <= 400 && marks >= aLo) {
            return Grade.A;
        } else if (marks >= bLo) {
            return Grade.B;
        } else if (marks >= cLo) {
            return Grade.C;
        } else if (marks >= 0) {
            return Grade.F;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}