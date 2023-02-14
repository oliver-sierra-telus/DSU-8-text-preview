package textPreviewerApp.src.main.java.com.textPreview.app;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses.RightFormat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        RightFormat derecha = new RightFormat();
        derecha.formatText(10, "Bienvenidos a DSU Telus International");
    }
}
