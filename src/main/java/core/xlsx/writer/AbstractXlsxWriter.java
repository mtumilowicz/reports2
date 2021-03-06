package core.xlsx.writer;

import core.bundle.BundleHandler;
import core.writer.DocumentWriter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by mtumilowicz on 2017-08-19.
 */
public abstract class AbstractXlsxWriter implements DocumentWriter {
    protected final BundleHandler bundles = new BundleHandler(this.getClass());

    public abstract void prepare(Workbook workbook);
    
    public void save(String dest) {
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream outputStream = new FileOutputStream(dest)) {
            prepare(workbook);
            create(workbook, outputStream);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    protected void add(InsertableXlsSheet sheet) {
        sheet.create();
    }
    
    private void create(Workbook workbook, FileOutputStream outputStream) throws IOException {
        workbook.write(outputStream);
    }
}
