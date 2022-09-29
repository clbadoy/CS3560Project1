import java.util.ArrayList;

public class VotingService {
    private ArrayList<iVote> voteData;
    private ArrayList<Integer> voteStats;

    public VotingService() {
        voteData = new ArrayList<iVote>();
        voteStats = new ArrayList<Integer>();
    }

    public void addStudentInput(iVote vote) {
        voteData.add(vote);
    }

    public void getStatistics()
    {
        int totalAnswerChoice = voteData.get(0).getNumAnswers();
        String temp = "";
        int sumOfAnswerType = 0;
        for(int i = 0; i < totalAnswerChoice; i++)
        {
            temp = Character.toString((char)65 + i);
            sumOfAnswerType = collectStats(temp);
            voteStats.add(sumOfAnswerType);
        }
    }

    private int collectStats(String aLetter) {
        int studentCount = voteData.get(0).getStudentCount();
        int traverse = 0;
        String studentAns = ""; 
        int counter = 0;
        boolean alreadyChecked = false;

        for(int i = 0; i < studentCount; i++)
        {
            traverse = voteData.get(i).getStudentAnswer().length();
            studentAns = voteData.get(i).getStudentAnswer();
            alreadyChecked = false;
            for(int j = 0; j < traverse; j++)
            {
                if(studentAns.charAt(j) == aLetter.charAt(0))
                    if(alreadyChecked == false)
                    {
                        alreadyChecked = true;
                        counter++;
                    }
            }
        }
        return counter;
    }

    public void clearInputData() {
        clearData();
    }

    private void clearData() {
        for(int i = 0; i < voteData.size(); i++)
        {
            voteData.get(i).clearVoteData();
        }
        voteStats.clear();
    }

    public String toString()
    {
        String text = "STATISTICS\n***********";
        for(int i = 0; i < voteData.get(0).getNumAnswers(); i++)
        {
            text += Character.toString((char) 65 + i) + ": " + voteStats.get(i) + "\n";
        }

        return text;
    }
}
