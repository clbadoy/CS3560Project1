/**
 * Christian Badoy
 * CS3560
 * Professor Sun
 * 29 September 2022
 * 
 * The purpose of this project is to create a poll-like program while trying to use principles of OOP.
 * This is the Student class, which contains data about a specific user that can be identified via the Unique ID.
 */
import java.util.UUID;

public class Student {

    private static int studentCount = 0;
    private int studentIndex;
    private String UID;

    /**
     * Constructor of student that automatically generates a Unique ID.
     */
    public Student() {
        studentIndex = studentCount++;
        UID = UUID.randomUUID().toString();
    }

    /**
     * Gets an index number of the student.
     * @return int type of student's index.
     */
    public int getStudentNum() {
        int tempIndex = this.studentIndex;
        return tempIndex;
    }

    /**
     * Gets student ID.
     * @return a String object of a Student's ID.
     */
    public String getStudentUID() {
        String tempID = this.UID;
        return tempID;
    }

    /**
     * Public method that calls to helper method to clear student roster.
     */
    public void resetStudentIDCount() {
        reset();
    }

    /**
     * Helper method that resets the student count.
     */
    private static void reset() {
        studentCount = 0;
    }

}
