import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import Errors.InvalidCreditsException;
import Errors.MarksOutOfBoundsException;
import Errors.NonNumberMarksException;

public class GraderTest {
    private final Grader grader = new Grader();

    @Test
    void credit3GradeTest() {
        assertEquals(Grader.Grade.A, this.grader.assignGrade(3, 400));
        assertEquals(Grader.Grade.A, this.grader.assignGrade(3, 240));

        assertEquals(Grader.Grade.B, this.grader.assignGrade(3, 239));
        assertEquals(Grader.Grade.B, this.grader.assignGrade(3, 210));

        assertEquals(Grader.Grade.C, this.grader.assignGrade(3, 209));
        assertEquals(Grader.Grade.C, this.grader.assignGrade(3, 180));

        assertEquals(Grader.Grade.F, this.grader.assignGrade(3, 179));
        assertEquals(Grader.Grade.F, this.grader.assignGrade(3, 0));
    }

    @Test
    void credit4GradeTest() {
        assertEquals(Grader.Grade.A, this.grader.assignGrade(4, 400));
        assertEquals(Grader.Grade.A, this.grader.assignGrade(4, 320));

        assertEquals(Grader.Grade.B, this.grader.assignGrade(4, 319));
        assertEquals(Grader.Grade.B, this.grader.assignGrade(4, 280));

        assertEquals(Grader.Grade.C, this.grader.assignGrade(4, 279));
        assertEquals(Grader.Grade.C, this.grader.assignGrade(4, 240));

        assertEquals(Grader.Grade.F, this.grader.assignGrade(4, 239));
        assertEquals(Grader.Grade.F, this.grader.assignGrade(4, 0));
    }

    @Test
    void fractionMarksTest() {
        assertEquals(Grader.Grade.A, this.grader.assignGrade(3, 239.4));
        assertEquals(Grader.Grade.B, this.grader.assignGrade(3, 209.5));
        assertEquals(Grader.Grade.C, this.grader.assignGrade(3, 179.6));
        assertEquals(Grader.Grade.F, this.grader.assignGrade(3, 0.1));

        assertEquals(Grader.Grade.A, this.grader.assignGrade(4, 319.3));
        assertEquals(Grader.Grade.B, this.grader.assignGrade(4, 279.9));
        assertEquals(Grader.Grade.C, this.grader.assignGrade(4, 239.1));
        assertEquals(Grader.Grade.F, this.grader.assignGrade(4, 0.1));
    }

    @Test
    void outOfBoundsTest() {
        assertThrows(MarksOutOfBoundsException.class, () -> {
            grader.assignGrade(3, 400.5);
        });
        assertThrows(MarksOutOfBoundsException.class, () -> {
            grader.assignGrade(3, -1);
        });
        assertThrows(MarksOutOfBoundsException.class, () -> {
            grader.assignGrade(4, Double.MAX_VALUE);
        });
    }

    @Test
    void nanTest() {
        assertThrows(NonNumberMarksException.class, () -> {
            grader.assignGrade(3, Double.NaN);
        });
        assertThrows(NonNumberMarksException.class, () -> {
            grader.assignGrade(4, Double.NaN);
        });
    }

    @Test
    void invalidCreditTest() {
        assertThrows(InvalidCreditsException.class, () -> {
            grader.assignGrade(1.5, 400);
        });
        assertThrows(InvalidCreditsException.class, () -> {
            grader.assignGrade(4.1, 239);
        });
    }
}