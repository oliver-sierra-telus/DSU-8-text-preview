package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import java.util.ArrayList;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class JustifyFormat extends TextFormarter {
    private int wordTextIndex = 0;
    private int wordIndex = 0;

    @Override
    public ArrayList<String> formatText(int intColumnSize, String[] words){
        ArrayList<String> textFormatted= new ArrayList<>();

        while(wordIndex!=words.length){

            String line = lineGenerator(intColumnSize, words);
            //System.out.println(line);
            textFormatted.add(line.trim());
        }
        return textFormatted;
    }


    private String lineGenerator(int intColumnSize, String words[]) {
        int wordCounter = 0;
        int spaceCounter = 0;
        int spaceDistribution = 0;
        int spacesToAdd = 0;
        int minimumSpaces = 0;
        int spacesAdded = 0;
        String lineBuilding = "";
        String whiteSpace = " ";

        do {
            spaceCounter += words[wordIndex].length() + 1;
            wordIndex++;
            wordCounter++;
            if (wordIndex == words.length)
                break;
        } while ((spaceCounter + words[wordIndex].length() < intColumnSize));

        // spaceCounter+= (wordCounter-1);
        spaceCounter--;

        // Espacios entre palabras
        minimumSpaces = wordCounter - 1;
        if (minimumSpaces == 0)
            minimumSpaces = 1;

        // Espacios que se van a distribuir
        spaceDistribution = (intColumnSize - (spaceCounter));
        // Entre n espacios : minimumSpaces

        spacesToAdd = Math.ceilDiv(spaceDistribution, minimumSpaces);
        int aux = spaceDistribution % spacesToAdd;

        for (int i = 0; i < wordCounter; i++) { 
            lineBuilding += words[wordTextIndex];
            wordTextIndex++;
            lineBuilding += " ";
            if(spacesAdded != spaceDistribution) {
                lineBuilding += whiteSpace.repeat(spacesToAdd);
                spacesAdded += spacesToAdd;
            }
            //Bug, a veces se ejecutan los 2 ifs a la vez
            if ((spaceDistribution - spacesAdded == aux)) {
                lineBuilding += whiteSpace.repeat(aux);
                spacesAdded += aux;
            }
        }

        

        return lineBuilding;
    }
}
