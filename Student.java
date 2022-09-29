import java.util.UUID;

public class Student {
    
    private static int studentCount = 0;
    private int studentIndex;
    private String UID;

    public Student() {
        studentIndex = studentCount++;
        UID = UUID.randomUUID().toString(); 
    }

    public int getStudentNum() {
        int tempIndex = this.studentIndex;
        return tempIndex;
    }

    public String getStudentUID() {
        String tempID = this.UID;
        return tempID;
    }

    public void resetStudentIDCount() {
        reset();
    }

    private static void reset() {
        studentCount = 0;
    }

}
