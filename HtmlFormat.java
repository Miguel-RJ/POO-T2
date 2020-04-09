import java.util.*;
import java.io.*;

public class HtmlFormat {
    String htmlFile;
    public HtmlFormat(String file)
    {
        this.htmlFile = file;
    }

    public void writeHtmlFormat()
    {
        try {
            FileWriter writer = new FileWriter(htmlFile, true);
            writer.write("<!DOCTYPE html>");
            writer.write("\r\n");
            writer.write("<html>");
            writer.write("\r\n");
            writer.write("<head>");
            writer.write("\r\n");
            writer.write("</head>");
            writer.write("\r\n");
            writer.write("<body>");
            writer.write("\r\n");
            writer.write("</body>");
            writer.write("\r\n");
            writer.write("</html>");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }

}