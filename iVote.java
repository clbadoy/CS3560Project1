import java.util.ArrayList;
import java.util.Scanner;
public class iVote /*extends VotingService*/ { //MAYBE EXTENDS?
    
    private static ArrayList<Student> classRoster = new ArrayList<Student>();
    private Student student;
    private static Question theQuestion;
    private boolean hasAnswered;
    private String studentStringAnswers;

    public iVote(Student person, Question q) {
        student = person;
        classRoster.add(student);
        theQuestion = q;
        hasAnswered = false;
        studentStringAnswers = "";
    }
    
    public String getStudentAnswer() {
        String tempAnswer = this.studentStringAnswers;
        return tempAnswer;
    }

    public void insertStudentAnswer(String str) {
        String[] multipleAnswers;
        boolean isValidAnswer = false;
        String temp = "";

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

        if(isValidAnswer == false)
        {
            temp = fixAnswer();
        }
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

    private String fixAnswer() 
    {
        boolean valid = false;
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

    private boolean verifyValidAnswer(String str) 
    {
        if(str.length() == 1 && ('A' <= str.charAt(0) && str.charAt(0) <= (char)theQuestion.getNumAnswers() + 65))
            return true;
        else
            return false;
    }
    
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
    
    private void replace(String newAnswer)
    {
        this.studentStringAnswers = newAnswer;
    }

} 
