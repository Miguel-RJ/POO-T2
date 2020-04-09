import java.util.*;
import java.io.*;

public class Principal {
    static String htmlFile = "PaginaBonita.html";
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido al Creador de Paginas :)");
        System.out.println("La pagina se llamara PaginaBonita.html");
        System.out.println("PaginaBonita.html se encuentra en la carpeta del proyecto :)");
        System.out.println("Desea sobreescribir la pagina o formatearla.");
        System.out.println("1. Editar.");
        System.out.println("2. Formatear.");
        int opc = scan.nextInt();
        switch(opc){
            case 1:
                editarHtml();
                break;
            case 2: 
                formatearHtml();
                break;
            default:
                System.out.println("Opción no incluida en el menú.");
                break;
        }        
    }

    public static void formatearHtml()
    {
        try {
            FileWriter fwOb = new FileWriter("PaginaBonita.html", false); 
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
            writeHtmlFormat();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }

    public static void editarHtml()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione que quiere agregar a la pagina: ");
        System.out.println("1) Agregar etiqueta header.");
        System.out.println("2) Cambiar color de fondo.");
        System.out.println("3) Agregar titulo.");
        System.out.println("4) Agregar boton.");
        System.out.println("5) Agregar input.");
        System.out.println("6) Agregar imagen predeterminada.");

        int opc = scan.nextInt();
        switch(opc){
            case 1: 
                System.out.println("Elija el tamaño de la etiqueda header. Recuerde que es del 1 al 6.");
                String typeOf = scan.next();
                System.out.println("Introduzca el contenido del header");
                scan.nextLine();
                String contenido = scan.nextLine();
                Header newHeader = new Header(htmlFile, typeOf, contenido);
                newHeader.addHeader();
                break;
            case 2:
                System.out.println("Elija el color. Favor de escribirlo como en CSS (blue, grey...). ");
                String color = scan.next();
                BGColor newColor = new BGColor(htmlFile, color);
                newColor.changeBGColor();
                break;
            case 3:
                scan.nextLine();
                System.out.println("Elija el titulo.");
                String titulo = scan.nextLine();
                Title nuevoTitulo = new Title(htmlFile, titulo);
                nuevoTitulo.addOrChangeTitle();
                break;
            case 4: 
                scan.nextLine();
                System.out.println("Ingrese el texto del boton.");
                String text = scan.nextLine();
                Button nuevoBoton = new Button(htmlFile, text);
                nuevoBoton.addButton();
                break;
            case 5:
                System.out.println("Elija el tipo de input. (Pueder ser checkbox, text, radio, date)");
                String type = scan.next();
                System.out.println("Introduzca el texto del input");
                scan.nextLine();
                String texto = scan.nextLine();
                Input newInput = new Input(htmlFile, type, texto);
                newInput.addInput();
                break;

            case 6: 
                Image newImage = new Image(htmlFile);
                newImage.addImage();
        }

    }

    public static void writeHtmlFormat()
    {
        try {
            HtmlFormat newFormat = new HtmlFormat(htmlFile);
            newFormat.writeHtmlFormat();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
}