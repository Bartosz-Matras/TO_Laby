import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.w3c.dom.Document;

public class ReadFromURL {

    public static void read(URL url) throws Exception{

//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document document = builder.parse(url.openStream());
//
//        System.out.println(document.toString()  );
        File file = new File(String.valueOf(url));
        file.createNewFile();
    }

    public static void downloadFile(URL url, String filename) throws IOException{
        File myFile = new File(filename);
        if (myFile.createNewFile()){
            System.out.println("Create file: " + myFile.getName());
        }
    }
}
