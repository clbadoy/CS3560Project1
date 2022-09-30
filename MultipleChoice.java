/**
 * Christian Badoy
 * CS3560
 * Professor Sun
 * 29 September 2022
 * 
 * The purpose of this project is to create a poll-like program while trying to use principles of OOP.
 * This is the subclass of the abstract class Question, specifically tailored to multiple choice questions.
 */
import java.util.ArrayList;
public class MultipleChoice extends Question {
    
    private ArrayList<String> answers;
    private final int LETTER_A = 65;

    /**
     * Constructor for the subclass MultipleChoice
     * @param quest The string for the question to be asked.
     */
    public MultipleChoice(String quest) {
        super(quest, 0);
        answers = new ArrayList<String>();
    }

    /**
     * Getter method that retrieves the question.
     * @return a String of the question.
     */
    @Override
    public String getQuestion() {
        String tempQuestion = this.question;
        return tempQuestion;
    }
   
    /**
     * Getter method that retrieves the answer choices.
     * @return a String of the answer choices.
     */
    @Override
    public String getAnswerChoices() {
        String tempAnswer = "";
        for(int i = 0; i < answers.size(); i++)
            tempAnswer += answers.get(i) + "\n";
        return tempAnswer;
    }

    /**
     * Getter method that retrieves the type of question (Multiple Choice = 0, Single Choice = 1)
     * @return int type of a specific question type.
     */
    @Override
    public int getQuestionType() {
        int tempQT = this.questionType;
        return tempQT;
    }

    /**
     * Getter method that retrieves the number of possible answers in a question.
     * @return int type of number of answers.
     */
    @Override
    public int getNumAnswers() {
        int tempNumAns = answers.size();
        return tempNumAns;
    }

    /**
     * Method that overwrites the previous question.
     * @param str The new string containing the question to replace the old question.
     */
    @Override
    public void setQuestion(String str) {
        this.question = str;
    }

    /**
     * Method that adds a new answer selection to the pool of choices.
     * @param str The new possible answer to be added in the pool.
     */
    @Override
    public void addAnswerChoice(String str) {
        String newAnswer = Character.toString((char) LETTER_A + answers.size()) + ": " + str;
        answers.add(newAnswer);
    }

    /**
     * Replaces an undesired answer from the answer choice with a new answer
     * @param index Used to print the letter to console.
     * @param str The new possible answer to replace an old answer.
     */
    @Override
    public void replaceAnswerChoice(int index, String str) {
        
        String newAnswer = Character.toString((char) LETTER_A + index) + ": " + str;
        answers.set(index, newAnswer);
    }    

    /**
     * Method that clears the question along with the answers that were attached to the question.
     */
    public void clearQuestion() {
        clear();
    }

    /**
     * Helper Method that clears the question along with the answers that were attached to the question.
     */
    private void clear() {
        this.question = "";
        answers.clear();
    }

    /**
     * A toString method that helps easily print the question onto the console.
     */
    public String toString() {
        String questionText = getQuestion() + "\n" + getAnswerChoices();
        return questionText;
    }
    
}
