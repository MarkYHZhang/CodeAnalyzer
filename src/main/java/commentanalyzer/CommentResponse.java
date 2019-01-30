package commentanalyzer;

public class CommentResponse {

    private int totalLineCnt = 0,
            singleCommentLinesCnt = 0,
            blockCommentCnt = 0,
            blockCommentLinesCnt = 0,
            todoCnt=0;

    CommentResponse(int totalLineCnt) {
        this.totalLineCnt = totalLineCnt;
    }

    public int getTotalLineCnt() {
        return totalLineCnt;
    }

    public void setTotalLineCnt(int totalLineCnt) {
        this.totalLineCnt = totalLineCnt;
    }

    public int getTotalCommentCnt() {
        return singleCommentLinesCnt+blockCommentLinesCnt;
    }

    public int getSingleCommentLinesCnt() {
        return singleCommentLinesCnt;
    }

    public void incrementSingleCommentLinesCnt(){
        this.singleCommentLinesCnt++;
    }

    public int getBlockCommentCnt() {
        return blockCommentCnt;
    }

    public void incrementBlockCommentCnt(){
        this.blockCommentCnt++;
    }

    public int getBlockCommentLinesCnt() {
        return blockCommentLinesCnt;
    }

    public void addBlockCommentLines(int n){
        this.blockCommentLinesCnt+=n;
        incrementBlockCommentCnt();
    }

    public int getTodoCnt() {
        return todoCnt;
    }

    public void incrementTodoCnt(){
        this.todoCnt++;
    }

    @Override
    public String toString() {
        return "CommentResponse{" +
                "totalLineCnt=" + totalLineCnt +
                ",totalCommentLineCount" + getTotalCommentCnt() +
                ", singleCommentLinesCnt=" + singleCommentLinesCnt +
                ", blockCommentCnt=" + blockCommentCnt +
                ", blockCommentLinesCnt=" + blockCommentLinesCnt +
                ", todoCnt=" + todoCnt +
                '}';
    }
}
