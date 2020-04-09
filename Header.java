import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class Header {
    String htmlFile, typeOfHeader, content;
    public Header(String file, String typeOfHeader, String content){
        this.htmlFile = file;
        this.typeOfHeader = typeOfHeader;
        this.content = content;
    }

    public void addHeader(){
        try {
            File file = new File(htmlFile);
            String line;
            List<String> lines = Files.readAllLines(file.toPath());

            for (ListIterator<String> i = lines.listIterator(); i.hasNext();) {
                String element = i.next();
                if(element.equals("</body>"))
                {
                    i.set("\r\n" + "<h" + typeOfHeader + "> " + content + " </h"+ typeOfHeader + ">" + "\r\n" + element);
                    break;
                }
            }
            Files.write(file.toPath(), lines);
 
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
}