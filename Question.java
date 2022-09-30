/**
 * Christian Badoy
 * CS3560
 * Professor Sun
 * 29 September 2022
 * 
 * The purpose of this project is to create a poll-like program while trying to use principles of OOP.
 * This is an abstract Question class for the subclass to refer to for ease of abstraction.
 */
abstract class Question {

    String question;
    int questionType;

    /**
     * Constructor method for the abstract class.
     * @param quest A string type for the question.
     * @param qType A label for the question Type. (0 = Multiple choice, 1 = Single Choice)
     */
    public Question(String quest, int qType)
    {
        question = quest;
        questionType = qType;
    }

    /**
     * Getter method that retrieves the question.
     * @return a String of the question.
     */
    public abstract String getQuestion();

    /**
     * Getter method that retrieves the answer choices.
     * @return a String of the answer choices.
     */
    public abstract String getAnswerChoices();

    /**
     * Getter method that retrieves the type of question (Multiple Choice = 0, Single Choice = 1)
     * @return int type of a specific question type.
     */
    public abstract int getQuestionType();

    /**
     * Getter method that retrieves the number of possible answers in a question.
     * @return int type of number of answers.
     */
    public abstract int getNumAnswers();

    /**
     * Method that overwrites the previous question.
     * @param str The new string containing the question to replace the old question.
     */
    public abstract void setQuestion(String str);

    /**
     * Method that adds a new answer selection to the pool of choices.
     * @param str The new possible answer to be added in the pool.
     */
    public abstract void addAnswerChoice(String str);

    /**
     * Replaces an undesired answer from the answer choice with a new answer
     * @param index Used to print the letter to console.
     * @param str The new possible answer to replace an old answer.
     */
    public abstract void replaceAnswerChoice(int index, String str);

    /**
     * Method that clears the question along with the answers that were attached to the question.
     */
    public abstract void clearQuestion();
    
    /**
     * A toString method that helps easily print the question onto the console.
     */
    public abstract String toString();

}
