import java.util.List;
class Deliveries {
    private String deliveriesFile;

    void setFile(String matchFileList)
    {
        this.deliveriesFile =matchFileList;
    }
    List<String[]> getMatchFileData()
    {
        ReadFile readFileObject=new ReadFile();
        readFileObject.setFileData(deliveriesFile);
        return readFileObject.getFileData();
    }
}