package textPreviewerApp.src.main.java.com.textPreview.app;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses.JustifyFormat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var prueba = new JustifyFormat();
        String cadena = "It is a long established fact that a reader will be distracted by the "+
        "readable content of a page when looking at its layout. The point of using Lorem Ipsum is "+
        "that it has a more or less normal distribution of letters, as opposed to using 'Content here, "+
        "content here', making it look like readable English. Many desktop publishing packages and web";


        prueba.formatText(25, cadena);

    }
}
