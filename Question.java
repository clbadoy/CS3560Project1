//import java.util.ArrayList;
abstract class Question {

    String question;
    //ArrayList<String> answers;
    int questionType;

    public Question(String quest, int qType)
    {
        question = quest;
        questionType = qType;
    }

    public abstract String getQuestion();

    public abstract String getAnswerChoices();

    public abstract int getQuestionType();

    public abstract int getNumAnswers();

    public abstract void setQuestion(String str);

    public abstract void addAnswerChoice(String str);

    public abstract void replaceAnswerChoice(int index, String str);

    public abstract void clearQuestion();
    
    public abstract String toString();

}
