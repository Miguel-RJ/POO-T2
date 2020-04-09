import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class BGColor {
    String htmlFile, bgColor;
    public BGColor(String file, String color){
        this.htmlFile = file;
        this.bgColor = color;
    }

    public void changeBGColor(){
        try {
            File file = new File(htmlFile);
            String line;
            List<String> lines = Files.readAllLines(file.toPath());

            for (ListIterator<String> i = lines.listIterator(); i.hasNext();) {
                String element = i.next();
                if(element.contains("<body"))
                {
                    i.set("<body style='background-color: " + bgColor+ "'>");
                }
            }
            Files.write(file.toPath(), lines);
 
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
}