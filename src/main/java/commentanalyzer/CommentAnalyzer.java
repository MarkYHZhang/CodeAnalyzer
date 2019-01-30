package commentanalyzer;

import java.util.Arrays;

class CommentAnalyzer {

    /**
     * Matching language based on extension name
     * @param name Extension name
     * @return Language ENUM
     */
    private static Language matchLanguage(String name){
        if (!name.contains("."))return null;
        String[] fileArgs = name.trim().split("\\.");
        if (fileArgs[0].trim().equals(""))return null;
        String extension = fileArgs[1];
        System.out.println(Arrays.toString(fileArgs));
        for (Language lang : Language.values()) {
            if (extension.toLowerCase().equals(lang.getExtension())){
                return lang;
            }
        }
        return null;
    }

    /**
     * Handles and processes the request it acts as a helper function
     * @param request An CommentRequest object
     * @return An CommentResponse object
     */
    static CommentResponse analyze(CommentRequest request){
        Language lang = matchLanguage(request.getFileName());
        if (lang==null){
            Logger.error("Language not supported");
            return null;
        }

        return generateResponse(lang, request.getLines());
    }

    /**
     * Response generator
     * @param lang Language ENUM
     * @param lines String array containing of each lines of code
     * @return CommentReponse object
     */
    private static CommentResponse generateResponse(Language lang, String[] lines){
        System.out.println(Arrays.toString(lines));

        CommentResponse response = new CommentResponse(lines.length);

        String mainCommentSymbol = lang.getMainCommentSymbol();
        String blockCommentStarter = lang.getBlockCommentStarter();
        String blockCommentTerminator = lang.getBlockCommentTerminator();

        int tmpBlockCommentLinesCnt = 0;
        boolean isPreviousLineComment = false;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            if (lang != Language.PYTHON && lang != Language.HTML && lang!= Language.CSS) {
                if(tmpBlockCommentLinesCnt!=0){
                    tmpBlockCommentLinesCnt++;
                    if(line.contains(blockCommentTerminator)) {
                        response.addBlockCommentLines(tmpBlockCommentLinesCnt);
                        tmpBlockCommentLinesCnt = 0;
                    }
                }else if (line.contains(mainCommentSymbol)){
                    response.incrementSingleCommentLinesCnt();
                    if (line.contains("TODO")){
                        response.incrementTodoCnt();
                    }
                }else if(line.contains(blockCommentStarter)){
                    tmpBlockCommentLinesCnt++;
                    if(line.contains(blockCommentTerminator)){
                        response.addBlockCommentLines(tmpBlockCommentLinesCnt);
                        tmpBlockCommentLinesCnt=0;
                    }
                }
            }else if (lang == Language.PYTHON) {
                if (line.contains("TODO")){
                    response.incrementTodoCnt();
                }
                if (line.contains(mainCommentSymbol)) {
                    if (isPreviousLineComment) {
                        tmpBlockCommentLinesCnt++;
                    } else {
                        isPreviousLineComment = true;
                        tmpBlockCommentLinesCnt = 0;
                        tmpBlockCommentLinesCnt++;
                    }
                    if (i != lines.length - 1) continue;
                }
                isPreviousLineComment = false;
                if (tmpBlockCommentLinesCnt == 1) {
                    response.incrementSingleCommentLinesCnt();
                } else if (tmpBlockCommentLinesCnt > 1) {
                    response.addBlockCommentLines(tmpBlockCommentLinesCnt);
                    tmpBlockCommentLinesCnt = 0;
                }

            }else{
                boolean isSameLine = false, end = false;
                if (line.contains(blockCommentStarter)) {
                    tmpBlockCommentLinesCnt++;
                    isSameLine = true;
                }
                if (line.contains(blockCommentTerminator)){
                    end = true;
                    if (isSameLine){
                        response.incrementSingleCommentLinesCnt();
                    }else{
                        response.addBlockCommentLines(++tmpBlockCommentLinesCnt);
                    }
                    tmpBlockCommentLinesCnt=0;
                }
                if (!isSameLine&&!end){
                    if (tmpBlockCommentLinesCnt!=0){
                        tmpBlockCommentLinesCnt++;
                    }
                }
            }
        }
        System.out.println(response);
        return response;
    }

}
