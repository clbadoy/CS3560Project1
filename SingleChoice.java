public class SingleChoice extends Question {

    public SingleChoice(String quest, String ans, int numAns) {
        super(quest, ans, 1, numAns);
    }

    @Override
    public String getQuestion() {
        return this.question;
    }
    
    @Override
    public String getAnswerChoices() {
        return this.answerChoices;
    }

    @Override
    public int getQuestionType() {
        return this.questionType;
        
    }

    @Override
    public int getNumAnswers() {
        return this.numberAnswers;
    }

    public String toString() {
        String questionText = getQuestion() + "\n" + getAnswerChoices();
        return questionText;
    }
    
}
