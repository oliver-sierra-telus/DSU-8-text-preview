package com.textPreview.app.textFormatterClasses.formatedClasses;

import java.util.ArrayList;

import com.textPreview.app.textFormatterClasses.TextFormarter;

public class CenterFormat extends TextFormarter {

    // Singleton Pattern
    private static CenterFormat centerFormat;

    public static CenterFormat getInstance() {
        if (centerFormat == null) {
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
            int whiteSpaces = Math.round((intColumnSize - totalColumns) / 2);
            for (int j = 0; j < whiteSpaces; j++) {
                addSpaces += " ";
            }
            String provisional = addSpaces + textInLines.get(i) + addSpaces;
            if (provisional.length() == intColumnSize) {
                provisional = provisional.substring(0, intColumnSize - 1);
            }
            linesPrepared.add(provisional);
            addSpaces ="";
        }
        return linesPrepared;
    }

    private ArrayList<String> lineProcessor(int intColumnSize, String[] arrayWords) {
        ArrayList<String> wordsByLine = new ArrayList<>();
        String miCadena = "";
        for (int i = 0; i < arrayWords.length; i++) {
            if ((miCadena.length() + (arrayWords[i]).length() + 1) < (intColumnSize)) {
                miCadena += arrayWords[i];
                miCadena += " ";
            } else {
                String removeLastSpace = miCadena.substring(0,miCadena.length()-1);
                wordsByLine.add(removeLastSpace);
                wordsByLine.add(arrayWords[i]);
                miCadena = "";
            }
        }
        return wordsByLine;
    }
}