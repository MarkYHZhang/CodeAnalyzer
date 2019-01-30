package commentanalyzer;

public class Logger {

    public static void print(String input){
        System.out.println("[CommentAnalyzer] (INFO): " + input);
    }

    public static void error(String input){
        System.err.println("[CommentAnalyzer] (ERROR): " + input);
    }

}
