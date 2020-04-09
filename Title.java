import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class Title {
    String htmlFile, title;
    public Title(String file, String title){
        this.htmlFile = file;
        this.title = title;
    }

    public void addOrChangeTitle(){
        try {
            File file = new File(htmlFile);
            String line;
            List<String> lines = Files.readAllLines(file.toPath());

            for (ListIterator<String> i = lines.listIterator(); i.hasNext();) {
                String element = i.next();
                if(element.equals("<head>"))
                {
                    element = i.next();
                    if(element.equals("</head>"))
                    {
                        i.set("<title>" + title + "</title>" + "\r\n" + element);
                        break;
                    }
                    else
                    {
                        i.set("<title>" + title + "</title>");
                        break;
                    }                    
                }
            }
            Files.write(file.toPath(), lines);
 
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }


}