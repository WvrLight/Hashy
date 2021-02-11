import java.util.ArrayList;

public class TestAnalysis {
    public static void main(String[] args) {
        // Create the object that will automatically store info from all provided databases
        ReadAnalysis analysis = new ReadAnalysis();

        // Get a sample list from the analysis
        ArrayList<String> test = analysis.tweet_lists.getPositiveTweets();

        // Print out the values of the list
        for (String i : test) {
            System.out.println(i);
        }
    }
}
