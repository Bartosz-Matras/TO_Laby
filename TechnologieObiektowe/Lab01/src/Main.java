import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {

        ReadFromURL.read(new URL("https://www.nbp.pl/kursy/xml/lasta.xml"));

        ReadFromURL.downloadFile(new URL("https://www.nbp.pl/kursy/xml/lasta.xml"), "file.xml");
    }

}
