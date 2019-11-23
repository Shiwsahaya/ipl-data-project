import java.util.List;
class Match {
     private String matchFileList;

    void setFile(String matchFileList)
    {
        this.matchFileList=matchFileList;
    }
    List<String[]> getMatchFileData()
    {
        ReadFile readFileObject=new ReadFile();
        readFileObject.setFileData(matchFileList);
        return readFileObject.getFileData();
    }
}