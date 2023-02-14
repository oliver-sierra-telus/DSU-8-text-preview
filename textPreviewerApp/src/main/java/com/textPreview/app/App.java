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
        String cadena = "normal distribution of letters as "+
        "readable content of a page when looking at its layout. The point of using Lorem Ipsum is "+
        "that it has a more or less reader will be distracted by the opposed to using 'Content here, "+
        "content here', making it look like readable English. Many desktop publishing packages and web";


        prueba.formatText(40, cadena);

    }
}
