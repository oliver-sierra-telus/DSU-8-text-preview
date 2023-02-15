package com.textPreview.app.textFormatterClasses.formatedClasses;

import java.util.ArrayList;

import com.textPreview.app.textFormatterClasses.TextFormarter;

public class RightFormat extends TextFormarter {
    private int wordTextIndex = 0;
    private int wordIndex = 0;

    private static RightFormat intancia;

    public static RightFormat getInstance(){
        if(intancia == null){
            intancia = new RightFormat();
        }
        return intancia;
    }

    @Override
    public ArrayList<String> formatText(int intColumnSize, String[] wordsArray) {

        ArrayList<String> textFormatted= new ArrayList<>();
        
        while(wordIndex!=wordsArray.length){
            String line = generateLine(intColumnSize, wordsArray);
            textFormatted.add(line);
        }
        wordTextIndex = 0;
        wordIndex = 0;
        return textFormatted;
    }

    public String generateLine(int intColumnSize, String words[]){
        int wordCounter = 0;
        int spaceDistribution = 0;
        int spaceCounter = 0;
        String lineBuilding = " ";
        String space = " ";

        //Cuenta palabras que quepan en una fila.
        do {
            spaceCounter += words[wordIndex].length() + 1;
            wordIndex++;
            wordCounter++;
            if (wordIndex == words.length){
                break;
            }
                
        } while ((spaceCounter + words[wordIndex].length() < intColumnSize));

        //Espacio que se tiene que agregar.
        spaceDistribution = (intColumnSize - (spaceCounter));

        //Asignacion de espacios a la linea
        lineBuilding += space.repeat(spaceDistribution);

        //Agrega espacio entre las palabras
        for (int i = 0; i < wordCounter; i++) {
            lineBuilding += words[wordTextIndex];
            wordTextIndex++;

            if(i+1 == wordCounter){
                //lineBuilding += "|";
            }
            else{
                lineBuilding += space;
            }
        }

        return lineBuilding;
    }
}

