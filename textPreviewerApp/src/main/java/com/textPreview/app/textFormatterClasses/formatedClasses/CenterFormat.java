package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import java.util.ArrayList;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class CenterFormat extends TextFormarter {

    @Override
    public ArrayList<String> formatText(int intColumnSize, String[] arrayWords) {

        ArrayList<String> textInLines = new ArrayList<>();
        ArrayList<String> linesPrepared = new ArrayList<>();
        String addSpaces = "";

        textInLines = lineProcessor(intColumnSize, arrayWords);

        linesPrepared.add(writeHeaderAndFooter(intColumnSize, "*"));
        for (int i = 0; i < textInLines.size(); i++) {
            
            int totalColumns = textInLines.get(i).length();
            int whiteSpaces = Math.round((intColumnSize-totalColumns)/2);

            for (int j = 0; j < whiteSpaces; j++) {
                addSpaces += " ";
            }

            // System.out.println("*"+ addSpaces + textInLines.get(i) + addSpaces +"*");
            linesPrepared.add("*"+ addSpaces + textInLines.get(i) + addSpaces +"*\n");
            addSpaces ="";

        }
        linesPrepared.add(writeHeaderAndFooter(intColumnSize,"*"));

        return linesPrepared;

    }

    private String writeHeaderAndFooter(int intColumnSize, String kindOfChar) {
        String line = "";
        for (int i = 0; i < intColumnSize+3; i++) {
            line += kindOfChar;
        }
        line += "\n";
        return line;
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
