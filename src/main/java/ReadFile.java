import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

 class ReadFile {
     List<String[]> getFileData(String file)
    {
        List<String[]> fileList=null;
        CSVReader readerMatch = null;
        try {
            readerMatch = new CSVReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assert readerMatch != null;
            fileList=readerMatch.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return fileList;
    }
}
