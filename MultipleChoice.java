import java.util.ArrayList;
public class MultipleChoice extends Question {
    
    private ArrayList<String> answers;
    private final int LETTER_A = 65;

    public MultipleChoice(String quest, String ans, int numAns) {
        super(quest, ans, 0, numAns);
        answers = new ArrayList<String>();
    }

    @Override
    public String getQuestion() {
        String tempQuestion = this.question;
        return tempQuestion;
    }
    
    @Override
    public String getAnswerChoices() {
        String tempAnswer = "";
        for(int i = 0; i < answers.size(); i++)
            tempAnswer += answers.get(i) + "\n";
        return tempAnswer;
    }

    @Override
    public void setQuestion(String str) {
        this.question = str;
    }

    @Override
    public void addAnswerChoice(String str) {
        String newAnswer = Character.toString((char) LETTER_A + answers.size()) + ": " + str;
        answers.add(newAnswer);
    }

    @Override
    public void replaceAnswerChoice(int index, String str) {
        
        String newAnswer = Character.toString((char) LETTER_A + index) + ": " + str;
        answers.set(index, newAnswer);
    }    

    @Override
    public int getQuestionType() {
        int tempQT = this.questionType;
        return tempQT;
        
    }

    @Override
    public int getNumAnswers() {
        int tempNumAns = this.numberAnswers;
        return tempNumAns;
    }

    public String toString() {
        String questionText = getQuestion() + "\n" + getAnswerChoices();
        return questionText;
    }
    
}
