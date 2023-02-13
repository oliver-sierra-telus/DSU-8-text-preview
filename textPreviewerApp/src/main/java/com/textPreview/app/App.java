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
        // System.out.println( "Hello World!" );
        JustifyFormat justifyFormat = new JustifyFormat();
        justifyFormat.formatText(15, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard");


    }
}
