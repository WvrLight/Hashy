import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReadAnalysis
{
    Connection db = null;
    Sentiment s = new Sentiment(db);
    RelatedHashtags r_hashtags = new RelatedHashtags(db);
    Trends trends = new Trends(db);
    TweetList tweet_lists = new TweetList(db);
}

class Sentiment {
    private String positive;
    private String neutral;
    private String negative;

    public Sentiment(Connection c) {
        try {
            // create a database connection
            c = DriverManager.getConnection("jdbc:sqlite:SentimentPercentage.db");

            // create an sql statement variable
            Statement statement = c.createStatement();
            statement.setQueryTimeout(10);

            // store results in a set
            ResultSet rs = statement.executeQuery("select * from output"); // output is the name of the table
            while (rs.next()) { // go through every row
                // read the columns
                this.positive = rs.getString("positivesenti");
                this.neutral = rs.getString("neutralsenti");
                this.negative = rs.getString("negativesenti");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    public String getPositive() {
        return this.positive;
    }

    public String getNeutral() {
        return this.neutral;
    }

    public String getNegative() {
        return this.negative;
    }
}

class RelatedHashtags {
    private ArrayList<String> rt = new ArrayList<String>();

    public RelatedHashtags(Connection c) {
        try {
            // create a database connection
            c = DriverManager.getConnection("jdbc:sqlite:relatedHashtags.db");

            // create an sql statement variable
            Statement statement = c.createStatement();
            statement.setQueryTimeout(5);

            // store results in a set
            ResultSet rs = statement.executeQuery("select * from output"); // output is the name of the table
            while (rs.next()) { // go through every row
                this.rt.add(rs.getString("relatedhashtags"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    public ArrayList<String> getList() {
        return rt;
    }
}

class Trends {
    private ArrayList<String> trendName = new ArrayList<String>();
    private ArrayList<String> trendUrl = new ArrayList<String>();
    private ArrayList<String> trendCount = new ArrayList<String>();

    public Trends(Connection c) {
        try {
            // create a database connection
            c = DriverManager.getConnection("jdbc:sqlite:trends.db");

            // create an sql statement variable
            Statement statement = c.createStatement();
            statement.setQueryTimeout(5);

            // store results in a set
            ResultSet rs = statement.executeQuery("select * from trends");
            while (rs.next()) { // go through every row
                this.trendName.add(rs.getString("name"));
                this.trendUrl.add(rs.getString("url"));
                this.trendCount.add(rs.getString("tweet_volume"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    public ArrayList<String> getTrendNames() {
        return this.trendName;
    }

    public ArrayList<String> getTrendUrl() {
        return this.trendUrl;
    }

    public ArrayList<String> getTrendCount() {
        return this.trendCount;
    }
}

class TweetList {
    private ArrayList<String> positive_tweets = new ArrayList<String>();
    private ArrayList<String> neutral_tweets = new ArrayList<String>();
    private ArrayList<String> negative_tweets = new ArrayList<String>();

    public TweetList(Connection c) {
        try {
            // create a database connection
            c = DriverManager.getConnection("jdbc:sqlite:pickedtweets.db");

            // create an sql statement variable
            Statement statement = c.createStatement();
            statement.setQueryTimeout(5);

            // store results in a set
            ResultSet rs = statement.executeQuery("select * from output");
            while (rs.next()) { // go through every row
                this.positive_tweets.add(rs.getString("POSITIVETWEETS"));
                this.neutral_tweets.add(rs.getString("NEUTRALTWEETS"));
                this.negative_tweets.add(rs.getString("NEGATIVETWEETS"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    public ArrayList<String> getPositiveTweets() {
        return this.positive_tweets;
    }

    public ArrayList<String> getNeutralTweets() {
        return this.neutral_tweets;
    }

    public ArrayList<String> getNegativeTweets() {
        return this.negative_tweets;
    }
}