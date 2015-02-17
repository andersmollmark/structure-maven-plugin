package structure.analyze;

import java.util.List;

/**
 * Created by molas on 2015-02-13.
 */
public class FileAnalyzeResult {

    private String packageRow;

    private List<String> importRows;

    public void setPackageRow(String packageRow){
        this.packageRow = packageRow;
    }

    public void setImportRows(List<String> importRows){
        this.importRows = importRows;
    }

    public String getPackageRow(){
        return packageRow;
    }

    public List<String> getImportRows(){
        return importRows;
    }
}
