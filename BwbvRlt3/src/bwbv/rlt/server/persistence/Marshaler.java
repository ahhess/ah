package bwbv.rlt.server.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import bwbv.rlt.client.domain.Options;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;

/**
 * 
 * Marshal and unmarshal XML 
 * 
 */
public abstract class Marshaler {
    private static XStream xStream = initializeXStream();

    private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

    public static String toXML(Object xmlTree) {
        return XML_HEADER + toXMLNoHeader(xmlTree);
    }
    
    public static String toXMLNoHeader(Object xmlTree) {
        return xStream.toXML(xmlTree);
    }

    public static void toXML(Object xmlTree, FileOutputStream fos) {
        xStream.toXML(xmlTree, fos);
    }

    public static Options optionsFromFile(FileInputStream fis) {
    	Options options = new Options();
        xStream.fromXML(fis, options);
        return options;
    }

    private static XStream initializeXStream() {
        // This constructor prevents underscores from being replaced with double
        // underscores
        XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyReplacer("|", "_")));

        //if you use annotated xstream POJOs register them here
//      xStream.processAnnotations(CssParameter.class);
        return xStream;
    }
}
