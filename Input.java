import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class Input {
    String htmlFile, text, typeOf;
    public Input(String file, String typeOf, String text){
        this.htmlFile = file;
        this.text = text;
        this.typeOf = typeOf;
    }

    public void addInput(){
        try {
            File file = new File(htmlFile);
            String line;
            List<String> lines = Files.readAllLines(file.toPath());

            for (ListIterator<String> i = lines.listIterator(); i.hasNext();) {
                String element = i.next();
                if(element.equals("</body>"))
                {
                    i.set("\r\n" + "<input type = '" + typeOf + "'> " + text + " </input> " + "\r\n" + element);
                    break;
                }
            }
            Files.write(file.toPath(), lines);
 
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
}