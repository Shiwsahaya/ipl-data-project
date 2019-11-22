import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class ReadFile {
    private List<String[]> fileList;
    private CSVReader csvReader;
    public void setFileData(String file)
    {
        try {
            csvReader = new CSVReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("CSV File Not Found");
        }
        try {
            csvReader.skip(1);
            fileList= csvReader.readAll();
        } catch (IOException | CsvException e) {
            System.out.println("Error in CSV File Reading");
        }
    }
    public List<String[]> getFileData()
    {
        return fileList;
    }
}