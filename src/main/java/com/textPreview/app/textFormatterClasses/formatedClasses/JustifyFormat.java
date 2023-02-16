package com.textPreview.app.textFormatterClasses.formatedClasses;

import java.util.ArrayList;

import com.textPreview.app.textFormatterClasses.TextFormarter;

public class JustifyFormat extends TextFormarter {
    private static JustifyFormat justifyFormatInstance;
    private int wordTextIndex = 0;
    private int wordIndex = 0;
    private JustifyFormat(){}

    public static JustifyFormat getInstance(){
        if(justifyFormatInstance==null){
            justifyFormatInstance = new JustifyFormat();
        }
        return justifyFormatInstance;
    }

    @Override
    public ArrayList<String> formatText(int intColumnSize, String[] words){
        wordTextIndex = 0;
        wordIndex = 0;
        ArrayList<String> textFormatted= new ArrayList<>();

        while(wordIndex!=words.length){
            String line = lineGenerator(intColumnSize, words);
            textFormatted.add(line);
        }
        
        wordTextIndex = 0;
        wordIndex = 0;
        return textFormatted;
    }

    private String lineGenerator(int intColumnSize, String words[]) {
        int wordCounter = 0;
        int spaceCounter = 0;
        int spaceDistribution = 0;
        int spacesToAdd = 0;
        int minimumSpaces = 0;
        int spacesAdded = 0;
        String lineBuilding = " ";
        String whiteSpace = " ";

        do {
            spaceCounter += words[wordIndex].length() + 1;
            wordIndex++;
            wordCounter++;
            if (wordIndex == words.length)
                break;
        } while ((spaceCounter + words[wordIndex].length() < intColumnSize));

        spaceCounter--;

        // Espacios entre palabras
        minimumSpaces = wordCounter - 1;
        if (minimumSpaces == 0){
            minimumSpaces = 1;
        }

        // Espacios que se van a distribuir
        spaceDistribution = (intColumnSize - (spaceCounter));

        // Entre n espacios : minimumSpaces
        spacesToAdd = Math.ceilDiv(spaceDistribution, minimumSpaces);
        int aux = spaceDistribution % spacesToAdd;

        for (int i = 0; i < wordCounter; i++) { 
            lineBuilding += words[wordTextIndex];
            wordTextIndex++;
            lineBuilding += " ";
            if ((spaceDistribution - spacesAdded == aux) ) {
                lineBuilding += whiteSpace.repeat(aux);
                spacesAdded += aux;
            }
            if(spacesAdded != spaceDistribution) {
                lineBuilding += whiteSpace.repeat(spacesToAdd);
                spacesAdded += spacesToAdd;
            }
            
        }

        return lineBuilding;
    }
}
