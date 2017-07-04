package xml.builder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by mtumilowicz on 2017-06-15.
 */
public interface XmlDocumentBuilder {
    
    Document getDocument();
    
    XmlDocumentBuilder addElement(Element e);

    XmlElementBuilder getElementBuilder();

    interface XmlElementBuilder {
        XmlElementBuilder element(String name);

        XmlElementBuilder attribute(String name, String value);

        XmlElementBuilder up();

        XmlElementBuilder addInnerElement(Element elem);

        XmlElementBuilder addInnerElement(String name);

        Element build();
    }
}
