package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import java.util.ArrayList;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class CenterFormat extends TextFormarter {

    @Override
    public void formatText(int intColumnSize, String texStringFormat) {
        
        String[] cadenaSplit = texStringFormat.split(" ", 100);

        int remanente = intColumnSize;
        String myNewText = "";
        String textWithSpace = "";
        int whiteSpaces;
        for (int i = 0; i < cadenaSplit.length; i++) {
            
            if(cadenaSplit[i].length() <= remanente) {
                myNewText += cadenaSplit[i];
                myNewText+= " ";
                remanente = remanente - cadenaSplit[i].length()-1;
                
                // System.out.println("tamanio " + cadenaSplit[i].length() + " linea lleva " + (line.length()) + " y restante " + (remanente) );
                
            } else {
                // System.out.println("el remanente es: " + Math.round(remanente/2));
                whiteSpaces = Math.round((remanente/2));
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
