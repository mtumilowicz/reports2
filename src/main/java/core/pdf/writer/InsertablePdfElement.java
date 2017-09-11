package core.pdf.writer;

import com.itextpdf.layout.element.Table;
import core.bundle.BundleHandler;

/**
 * Created by mtumilowicz on 2017-09-11.
 */
public interface InsertablePdfElement {
    Table get();
    InsertablePdfElement withBundles(BundleHandler bundles);
}
