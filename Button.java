import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class Button {
    String htmlFile, text;
    public Button(String file, String text){
        this.htmlFile = file;
        this.text = text;
    }

    public void addButton(){
        try {
            File file = new File(htmlFile);
            String line;
            List<String> lines = Files.readAllLines(file.toPath());

            for (ListIterator<String> i = lines.listIterator(); i.hasNext();) {
                String element = i.next();
                if(element.equals("</body>"))
                {
                    i.set("\r\n" + "<button>" + text + "</button>" + "\r\n" + element);
                    break;
                }
            }
            Files.write(file.toPath(), lines);
 
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

}