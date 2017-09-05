package pdf.books;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import core.pdf.builder.PdfCellBuilder;
import core.pdf.writer.AbstractDocumentWriter;
import dao.BookDAOMock;

import java.math.BigDecimal;

/**
 * Created by mtumilowicz on 2017-09-05.
 */
final class SummaryBooksCollectionTable extends AbstractInsertablePdfTable {


    SummaryBooksCollectionTable(AbstractDocumentWriter writer) {
        super(writer);
    }

    public void insertInto(Document doc) {
        Table table = new Table(new float[]{1, 1});
        table.setDocument(doc);

        table.setWidthPercent(40)
                .addHeaderCell(
                        getCellBuilder()
                                .value(getBundles().get("report.table.summary.header"))
                                .noBorder()
                                .singleCellFontSize(20)
                                .build())
                .addHeaderCell(PdfCellBuilder.EMPTY_CELL)
                .addCell(
                        getCellBuilder()
                                .value(getBundles().get("report.table.summary.quantity"))
                                .build())
                .addCell(
                        getCellBuilder()
                                .value(getBundles().get("report.table.summary.value"))
                                .build())
                .addCell(
                        getCellBuilder()
                                .value(BookDAOMock.getAllEntities().size())
                                .build())
                .addCell(
                        getCellBuilder()
                                .value(BookDAOMock.sumPriceOfAllEntities().orElse(BigDecimal.ZERO))
                                .build())
                .complete();
    }
}