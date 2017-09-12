package pdf.books;

import com.itextpdf.layout.element.Table;
import core.pdf.builder.cell.PdfCellBuilder;
import core.pdf.writer.InsertablePdfTable;

/**
 * Created by mtumilowicz on 2017-09-05.
 */
final class SpacingTable extends InsertablePdfTable {

    public Table get() {
        Table table = new Table(new float[]{1});

        table.setWidthPercent(100)
                .setHeight(50)
                .addCell(PdfCellBuilder.EMPTY_CELL);
        
        return table;
    }
}
