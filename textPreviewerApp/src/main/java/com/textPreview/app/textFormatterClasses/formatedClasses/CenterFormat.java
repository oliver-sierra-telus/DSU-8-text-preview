package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import java.util.ArrayList;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class CenterFormat extends TextFormarter {

    //Singleton Pattern
    private static CenterFormat centerFormat;

    public static CenterFormat getInstance() {
        if(centerFormat == null) {
            centerFormat = new CenterFormat();
        }
        return centerFormat;
    }

    @Override
    public ArrayList<String> formatText(int intColumnSize, String[] arrayWords) {

        ArrayList<String> textInLines = new ArrayList<>();
        ArrayList<String> linesPrepared = new ArrayList<>();
        String addSpaces = "";

        textInLines = lineProcessor(intColumnSize, arrayWords);

        for (int i = 0; i < textInLines.size(); i++) {
            
            int totalColumns = textInLines.get(i).length();
            int whiteSpaces = Math.round((intColumnSize-totalColumns)/2);

            for (int j = 0; j < whiteSpaces; j++) {
                addSpaces += " ";
            }

            linesPrepared.add(addSpaces + textInLines.get(i) + addSpaces + " ");

            addSpaces ="";
        }
        return linesPrepared;
    }

    private ArrayList<String> lineProcessor(int intColumnSize, String[] arrayWords) {
        String firstPart;
        String secondPart;
        ArrayList<String> wordsByLine = new ArrayList<>();
        String miCadena = "";
        for (int i = 0; i < arrayWords.length; i++) {
            if ((miCadena.length()+arrayWords[i].length())<(intColumnSize-2)) {
                miCadena += arrayWords[i];
                miCadena += " ";
            } else {
                firstPart = arrayWords[i].substring(0,2) + "-";
                secondPart = arrayWords[i].substring(2);
                miCadena += firstPart;
                wordsByLine.add(miCadena);
                miCadena = "";
                miCadena += secondPart + " ";
                if(i==(arrayWords.length-1)){
                    wordsByLine.add(secondPart);
                }
            }
        }
        return wordsByLine;
    }
}
