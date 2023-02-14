package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class LeftFormat extends TextFormarter {

    @Override
    protected void formatText(int intColumnSize, String texStringFormat) {
        
        int length = texStringFormat.length();
        int lines = length / 10;

        if(length % 10 != 0) {
            lines++;
        }

        for (int i = 0; i < lines; i++) {
            int start = i * 10;
            int end = Math.min(length, start + 10);
            System.out.println(texStringFormat.substring(start, end));
        }
    }
    
}
