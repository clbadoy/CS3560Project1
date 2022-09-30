/**
 * Christian Badoy
 * CS3560
 * Professor Sun
 * 29 September 2022
 * 
 * The purpose of this project is to create a poll-like program while trying to use principles of OOP.
 * This is the Driver method that attempts to simulate the program functioning.
 */
public class SimulationDriver {
    public static void main(String[] args) {
        
        // Create Student Classes of individual students with UUIDs.
        Student studentOne = new Student();
        Student studentTwo = new Student();
        Student studentThree = new Student();
        Student studentFour = new Student();
        Student studentFive = new Student();
        Student studentSix = new Student();
        Student studentSeven = new Student();
        Student studentEight = new Student();
        Student studentNine = new Student();
        Student studentTen = new Student();
        Student studentEleven = new Student();
        Student studentTwelve = new Student();
        Student studentThirteen = new Student();
        Student studentFourteen = new Student();
        Student studentFifteen = new Student();
        Student studentSixteen = new Student();
        Student studentSeventeen = new Student();

        // Create iVote class of students' individual votes, respectively.
        iVote voteOne = new iVote(studentOne);
        iVote voteTwo = new iVote(studentTwo);
        iVote voteThree = new iVote(studentThree);
        iVote voteFour = new iVote(studentFour);
        iVote voteFive = new iVote(studentFive);
        iVote voteSix = new iVote(studentSix);
        iVote voteSeven = new iVote(studentSeven);
        iVote voteEight = new iVote(studentEight);
        iVote voteNine = new iVote(studentNine);
        iVote voteTen = new iVote(studentTen);
        iVote voteEleven = new iVote(studentEleven);
        iVote voteTwelve = new iVote(studentTwelve);
        iVote voteThirteen = new iVote(studentThirteen);
        iVote voteFourteen = new iVote(studentFourteen);
        iVote voteFifteen = new iVote(studentFifteen);
        iVote voteSixteen = new iVote(studentSixteen);
        iVote voteSeventeen = new iVote(studentSeventeen);

        // Configures the first question to be answered.
        Question questionOne = new SingleChoice("1. To be or not to Be");
        questionOne.addAnswerChoice("What is the question?");
        questionOne.addAnswerChoice("That is the question.");
        questionOne.addAnswerChoice("Never be.");
        questionOne.addAnswerChoice("Be the be.");
        
        // Sets QuestionType to SingleChoice
        iVote.insertQuestion(questionOne);

        // Store vote Data to the VotingService.
        VotingService serviceP = new VotingService();
        serviceP.addStudentInput(voteOne);
        serviceP.addStudentInput(voteTwo);
        serviceP.addStudentInput(voteThree);
        serviceP.addStudentInput(voteFour);
        serviceP.addStudentInput(voteFive);
        serviceP.addStudentInput(voteSix);
        serviceP.addStudentInput(voteSeven);
        serviceP.addStudentInput(voteEight);
        serviceP.addStudentInput(voteNine);
        serviceP.addStudentInput(voteTen);
        serviceP.addStudentInput(voteEleven);
        serviceP.addStudentInput(voteTwelve);
        serviceP.addStudentInput(voteThirteen);
        serviceP.addStudentInput(voteFourteen);
        serviceP.addStudentInput(voteFifteen);
        serviceP.addStudentInput(voteSixteen);
        serviceP.addStudentInput(voteSeventeen);


        // Calls simulator to generate randomly generated answers for SingleChoice.
        serviceP.generateRandAnsForRoster();
        serviceP.getStatistics();
        
        // Prints SingleChoice Info and Statistics.
        System.out.println(questionOne.toString());
        System.out.println(serviceP.toString());
        

        // Clears Data.
        serviceP.clearInputData();

        // Configures the second question to be answered.
        Question questionTwo = new MultipleChoice("2. Is this the right answer?");
        questionTwo.addAnswerChoice("This is the real Answer.");
        questionTwo.addAnswerChoice("That answer is the one.");
        questionTwo.addAnswerChoice("An answer.");
        questionTwo.addAnswerChoice("Some answer.");

        iVote.insertQuestion(questionTwo);

        // Generates Randomly Generated Data for Multiple Choice Questions. (Breaks unfortunately.)
        serviceP.generateRandAnsForRoster();
        serviceP.getStatistics();
    }
}
