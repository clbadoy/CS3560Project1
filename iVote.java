/**
 * Christian Badoy
 * CS3560
 * Professor Sun
 * 29 September 2022
 * 
 * The purpose of this project is to create a poll-like program while trying to use principles of OOP.
 * This is the iVote class, a class that records an individual student's answers selected on the poll.
 */
import java.util.ArrayList;
import java.util.Scanner;
public class iVote { 
    
    private static ArrayList<Student> classRoster = new ArrayList<Student>();
    private Student student;
    private static Question theQuestion;
    private boolean hasAnswered;
    private String studentStringAnswers;

    /**
     * Constructor for the iVote class.
     * @param person The student associated to what he/she may supply the answer with.
     */
    public iVote(Student person) {
        student = person;
        classRoster.add(student);
        theQuestion = null;
        hasAnswered = false;
        studentStringAnswers = "";
    }
    
    /**
     * Static method that stores a question into the iVote class.
     * @param q The question to be used in the iVote class.
     */
    public static void insertQuestion(Question q){
        Question tempQ = q;
        theQuestion = tempQ;
    }

    /**
     * Getter method that retrieves the student's answer.
     * @return String type of the student's answer.
     */
    public String getStudentAnswer() {
        String tempAnswer = this.studentStringAnswers;
        return tempAnswer;
    }

    /**
     * A method that inputs the student's answer.
     * Verifies if the answer is valid by calling to helper method(s).
     * Contains verification for both MultipleChoice answers and SingleChoice answers.
     * Replaces/Overwrites old answers if the student has already answered.
     * @param str The new answer that the student potentially answered the question with.
     */
    public void insertStudentAnswer(String str) { //TODO: Fix MULTI
        String[] multipleAnswers;
        boolean isValidAnswer = false;
        String temp = str;

        // Initial check for verification before calling to helper method.
        switch(theQuestion.getQuestionType()){
            case 0:
                multipleAnswers = str.split(",\\s*");
                for(int i = 0; i < multipleAnswers.length; i++)
                {
                    isValidAnswer = verifyValidAnswer(multipleAnswers[i]);
                    if(isValidAnswer == false)
                        break;
                }
                break;
            case 1:
                isValidAnswer = verifyValidAnswer(str);
                break; 
        }

        // If the answer format is incorrect (Format: "A, B, C" or "A"), 
        // user must correct the answer before moving on.
        while(isValidAnswer == false)
        {
            temp = fixAnswer();
            isValidAnswer = verifyValidAnswer(temp);
        }

        // If the user has answered before, they will be prompted if he/she wants to overwrite the
        // old response. Otherwise, it automatically writes the answer to the private instance.
        if(hasAnswered == false)
        {
            hasAnswered = true;
            replace(temp);
        }
        else
        {
            replacePreviousAnswerPrompt(temp);
        }
    }

    /**
     * Private method that requires the user to correct his or her answer.
     * @return String type that contains the user's corrected answer.
     */
    private String fixAnswer() 
    {
        boolean valid = verifyValidAnswer(studentStringAnswers);
        boolean flag = true;
        Scanner kb = new Scanner(System.in);
        String[] multipleAnswers;
        String newAnswer = "";
        while(valid == false)
        {
            System.out.println("Error: Invalid answer. Please try again. Input new answer: ");
            newAnswer = kb.nextLine();

            if(theQuestion.getQuestionType() == 0)
            {
                multipleAnswers = newAnswer.split(",\\s*");
                for(int i = 0; i < multipleAnswers.length; i++)
                {   
                    valid = verifyValidAnswer(multipleAnswers[i]);
                    if(valid == false)
                        flag = false;
                }
                valid = flag;
                flag = true;
            }
            else
                valid = verifyValidAnswer(newAnswer);
        }
        kb.close();
        return newAnswer;
    }

    /**
     * Boolean method that is used to validate the User input.
     * @param str The new string that the user hopes to answer with.
     * @return true if the answer format is valid, false otherwise.
     */
    private boolean verifyValidAnswer(String str) 
    {
        if(str.length() == 1 && ('A' <= str.charAt(0) && str.charAt(0) <= (char)theQuestion.getNumAnswers() + 65))
            return true;
        else
            return false;
    }
    
    /**
     * Public method that replaces the previous entry that the user inputted.
     * @param str Potential answer to replace the old answer with.
     */
    public void replacePreviousAnswerPrompt(String str)
    {
        Scanner kb = new Scanner(System.in);
        String tempInput = "";
        System.out.println("Do you want to replace your previous answer? Your previous answer was: " + studentStringAnswers);
        System.out.println("\n Y/N:");
        tempInput = kb.nextLine();
        verifyValidAnswer(str);
        if(tempInput.equalsIgnoreCase("Y"))
            replace(tempInput);
        kb.close();
    }
    
    /**
     * Private method that conducts the replacement process of the old answer intot the new Answer.
     * @param newAnswer The new answer to replace the old entry.
     */
    private void replace(String newAnswer)
    {
        this.studentStringAnswers = newAnswer;
    }

    /**
     * Method that erases the user's answer from the data.
     */
    public void clearVoteData()
    {
        clearData();
    }

    /**
     * Helper method that conducts the process to reset data inputted by the user.
     */
    private void clearData()
    {
        hasAnswered = false;
        studentStringAnswers = "";
    }

    /**
     * Getter method that obtains the number of Students in the current poll.
     * @return int type totalling the number of players in the poll.
     */
    public int getStudentCount()
    {
        return classRoster.size();
    }

    /**
     * Getter method that obtains the Question class's number of answers.
     * @return int type of number of answers for a question.
     */
    public int getNumAnswers()
    {
        return theQuestion.getNumAnswers();
    }

    /**
     * Getter method that obtains the Question class's question type info
     * @return int type depicting which question type it currently is. (1 = SC, 0 = MC)
     */
    public int getQuestionType()
    {
        return theQuestion.getQuestionType();
    }
} 
