import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class Image {
    String htmlFile;
    public Image(String file)
    {
        this.htmlFile = file;
    }

    public void addImage(){
        try {
            File file = new File(htmlFile);
            String line;
            List<String> lines = Files.readAllLines(file.toPath());

            for (ListIterator<String> i = lines.listIterator(); i.hasNext();) {
                String element = i.next();
                if(element.equals("</body>"))
                {
                    i.set("\r\n" + "<img src = 'stonks.jpg' >" + "\r\n" + element);
                    break;
                }
            }
            Files.write(file.toPath(), lines);
 
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}