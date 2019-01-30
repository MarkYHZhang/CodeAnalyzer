package commentanalyzer;

public enum Language {
    JAVA("java", "//", "/*", "*/"),
    C("c", "//", "/*", "*/"),
    CPP("cpp", "//", "/*", "*/"),
    SCALA("scala", "//", "/*", "*/"),
    OBJECTIVE_C("m", "//", "/*", "*/"),
    JAVASCRIPT("js", "//", "/*",   "*/"),
    SWIFT("swift", "//", "/*", "*/"),

    //python's official way of block comment are just consecutive hashtags.
    PYTHON("py", "#", "\"\"\"" , "\"\"\""),

    //For HTML & CSS, if multiline, then it is considered block comment
    HTML("html", "","<!--","-->"),
    CSS("css", "", "/*", "*/"),
    RUBY("rb", "#", "=begin", "=end"),
    PERL("pl", "#", "=begin", "=cut");

    private String extension;
    private String mainCommentSymbol;
    private String blockCommentStarter, blockCommentTerminator;

    public String getExtension() {
        return this.extension;
    }

    public String getMainCommentSymbol(){
        return this.mainCommentSymbol;
    }

    public String getBlockCommentStarter(){
        return this.blockCommentStarter;
    }

    public String getBlockCommentTerminator(){
        return this.blockCommentTerminator;
    }

    Language(String extension, String mainCommentSymbol, String blockCommentStarter, String blockCommentTerminator) {
        this.extension = extension;
        this.mainCommentSymbol = mainCommentSymbol;
        this.blockCommentStarter = blockCommentStarter;
        this.blockCommentTerminator = blockCommentTerminator;
    }
}
