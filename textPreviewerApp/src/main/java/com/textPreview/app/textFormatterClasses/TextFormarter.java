package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses;

public abstract class TextFormarter {

    protected int intColumnSize;
    protected String textToFormat;

    protected abstract void formatText(int intColumnSize, String texStringFormat);
        
}
