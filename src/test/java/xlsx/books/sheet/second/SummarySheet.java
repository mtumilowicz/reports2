package xlsx.books.sheet.second;

import core.bundle.BundleHandler;
import core.xlsx.writer.InsertableXlsSheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by mtumilowicz on 2017-09-12.
 */
public class SummarySheet extends InsertableXlsSheet {

    public SummarySheet(BundleHandler bundles, Workbook workbook) {
        super(bundles, workbook);
    }

    @Override
    public void create() {
        int rowCount = 0;

        add(new SummarySheetTitle(getBundles(), getSheet(), rowCount));

        rowCount++;

        add(new SummarySheetContent(getBundles(), getSheet(), rowCount));

    }

    @Override
    public String getBundleKeySheetName() {
        return "report.sheet.summary.name";
    }

    @Override
    public void setColumnWidthInSheet() {

    }
}
