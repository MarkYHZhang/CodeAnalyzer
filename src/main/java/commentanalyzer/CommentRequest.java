package commentanalyzer;

import java.util.Base64;

public class CommentRequest {

    private String fileName;
    private String base64EncodedData;

    public CommentRequest(String fileName, String base64EncodedData){
        this.fileName = fileName;
        this.base64EncodedData = base64EncodedData;
    }

    public String[] getLines(){
        return new String(Base64.getDecoder().decode(base64EncodedData)).split("\n");
    }

    public String getBase64EncodedData() {
        return base64EncodedData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setBase64EncodedData(String base64EncodedData) {
        this.base64EncodedData = base64EncodedData;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
