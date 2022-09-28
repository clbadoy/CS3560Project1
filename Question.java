abstract class Question {

    String question;
    String answerChoices;
    int questionType;
    int numberAnswers;

    public Question(String quest, String ans, int qType, int numAns)
    {
        question = quest;
        answerChoices = ans;
        questionType = qType;
        numberAnswers = numAns;
    }

    public abstract String getQuestion();

    public abstract String getAnswerChoices();

    public abstract int getQuestionType();

    public abstract int getNumAnswers();

    public abstract String toString();
}
