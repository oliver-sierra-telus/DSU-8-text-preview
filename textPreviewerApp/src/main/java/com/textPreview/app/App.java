package textPreviewerApp.src.main.java.com.textPreview.app;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses.CenterFormat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        CenterFormat centerFormat = new CenterFormat();
        centerFormat.formatText(20, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard");

    }
}
