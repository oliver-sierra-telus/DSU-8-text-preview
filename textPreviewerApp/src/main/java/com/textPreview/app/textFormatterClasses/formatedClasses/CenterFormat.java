package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import java.util.ArrayList;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class CenterFormat extends TextFormarter {

    @Override
    public void formatText(int intColumnSize, String texStringFormat) {
        
        // String[] cadenaSplit = texStringFormat.split(" ", 100);
        char[] cadenaSplit = new char[texStringFormat.length()];
        
        for (int i = 0; i < texStringFormat.length(); i++) {
            cadenaSplit[i] = texStringFormat.charAt(i);
        }

        int remanente = intColumnSize;
        String myNewText = "";
        String textWithSpace = "";
        int whiteSpaces;

        for (int i = 0; i < cadenaSplit.length; i++) {
            
            if(remanente >= 0) {
                myNewText += cadenaSplit[i];
                remanente = remanente - 1;
            } else {
                whiteSpaces = remanente;
                myNewText+="\n";
                remanente = intColumnSize;
                i--;
                for (int j = 0; j < whiteSpaces; j++) {
                    textWithSpace+=" ";
                }
                textWithSpace += myNewText;
                System.out.print(textWithSpace);
                myNewText = "";
                textWithSpace = "";
            }
            
        }
    }

}
