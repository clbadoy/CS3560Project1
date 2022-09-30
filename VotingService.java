/**
 * Christian Badoy
 * CS3560
 * Professor Sun
 * 29 September 2022
 * 
 * The purpose of this project is to create a poll-like program while trying to use principles of OOP.
 * This is a class that conducts statistical data on all of the students' inputs along with simulating randomly
 * generated answers.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VotingService {
    private ArrayList<iVote> voteData;
    private ArrayList<Integer> voteStats;

    /**
     * Constructor for the VotingService Class.
     * Instantiates two ArrayLists to store voter data and collected statistics.
     */
    public VotingService() {
        voteData = new ArrayList<iVote>();
        voteStats= new ArrayList<Integer>();
    }

    /**
     * Method that stores student input made from the iVote Class.
     * @param vote the object containing data info about the student's input + UUID
     */
    public void addStudentInput(iVote vote) {
        voteData.add(vote);
    }

    /**
     * Public getter method that obtains statistical data of # of times a student chose a letter in the poll.
     * Calls collectStats() helper method to calculate the total.
     */
    public void getStatistics()
    {
        int totalAnswerChoice = voteData.get(0).getNumAnswers();
        String temp;
        int sumOfAnswerType;
        for(int i = 0; i < totalAnswerChoice; i++)
        {
            temp = Character.toString((char)65 + i);
            sumOfAnswerType = collectStats(temp);
            voteStats.add((Integer)sumOfAnswerType);
        }
    }

    /**
     * Private helper method that conducts calculations to retrieve the total # of picks for a certain choice.
     * @param aLetter The letter to be measured
     * @return int type totalling the # of picks conducted by the students from iVote data.
     */
    private int collectStats(String aLetter) {
        int studentCount = voteData.get(0).getStudentCount();
        int traverse = 0;
        String studentAns = ""; 
        int counter = 0;
        boolean alreadyChecked = false;

        // Attempted method to avoid counting duplicates in the Student's string
        for(int i = 0; i < studentCount; i++)
        {
            traverse = voteData.get(i).getStudentAnswer().length();
            studentAns = voteData.get(i).getStudentAnswer();
            alreadyChecked = false;
            for(int j = 0; j < traverse; j++)
            {
                if(studentAns.charAt(j) == aLetter.charAt(0)) {
                    if(alreadyChecked == false)
                    {
                        alreadyChecked = true;
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    /**
     * Method used to eradicate voter data and statistical data collected for a new set of questions to use again.
     */
    public void clearInputData() {
        clearData();
    }

    /**
     * Helper method used to properly clear student inputted data and clear other data.
     */
    private void clearData() {
        for(int i = 0; i < voteData.size(); i++)
        {
            voteData.get(i).clearVoteData();
        }
        voteStats.clear();
    }

    /**
     * A String method to properly print Statistical data onto the console.
     * @return String properly formatting the data.
     */
    public String toString()
    {
        String text = "STATISTICS\n***********\n";
        for(int i = 0; i < voteData.get(0).getNumAnswers(); i++)
        {
            text += Character.toString((char) 65 + i) + ": " + voteStats.get(i) + "\n";
        }

        return text;
    }

    /**
     * An attempted method to simulate student answers by automatically generating data and writing to
     * every student that are currently in the poll.
     */
    public void generateRandAnsForRoster() {
        generateAnswers();
    }

    /**
     * Helper method attempting to manipulate data to give every student an answer.
     * Gives answers to both Single Choice (working) and Multiple Choice (Strugging to debug truthfully.)
     * Used to assist to make valid data in getStatistics().
     */
    private void generateAnswers() {
        ArrayList<String> letterChoices = new ArrayList<String>();
        ArrayList<String> indivAnswer = new ArrayList<String>();
        int randomNumberSelect = -1, numberAnswerSelected = -1;
        String tempAnsString = "";


        // Simulates and writes data for Single Choice Answers.
        for(int i = 0; i < voteData.get(0).getNumAnswers(); i++)
            letterChoices.add(Character.toString((char)65 + i));
        
        if(voteData.get(0).getQuestionType() == 1)
            for(int i = 0, j = voteData.get(i).getNumAnswers(); i < voteData.get(i).getStudentCount() -1  ; i++)
            {
                randomNumberSelect = (int)(Math.random() * j);
                voteData.get(i).insertStudentAnswer(Character.toString((char)65 + randomNumberSelect));
                
            }
        else
        // Simulates and writes data for Multiple Choice Answers. (Triggers an Error unfortunately)
        {
            for(int i = 0; i < voteData.get(i).getStudentCount() -1 ; i++)
            {
                numberAnswerSelected = (int)(Math.random() * (voteData.get(i).getNumAnswers())+1);
                for(int k = 0, j = voteData.get(i).getNumAnswers(); k < numberAnswerSelected; k++, j--)
                {
                    randomNumberSelect = (int)(Math.random() * (j)) +1;
                    indivAnswer.add(Character.toString((char)65 + randomNumberSelect));
                    Collections.swap(letterChoices, randomNumberSelect, j-1);
                }
                letterChoices.sort(Comparator.naturalOrder());
                indivAnswer.sort(Comparator.naturalOrder());
                tempAnsString = "";
                for(int m = 0; m < indivAnswer.size(); m++)
                {
                    tempAnsString += indivAnswer.get(m);
                    if(m == numberAnswerSelected - 1)
                        tempAnsString += indivAnswer.get(m) + "";
                    else
                        tempAnsString += indivAnswer.get(m) + ", ";
                }

                voteData.get(i).insertStudentAnswer(tempAnsString);
            }
        }
    }
}
