package com.textPreview.app.textFormatterClasses.formatedClasses;

import java.util.ArrayList;

import com.textPreview.app.textFormatterClasses.TextFormarter;

public class LeftFormat extends TextFormarter {
    private static LeftFormat instance;

    public static LeftFormat getInstance() {
        if(instance == null) {
            instance = new LeftFormat();
        }
        return instance;
    }

    LeftFormat(){}

    @Override
    protected ArrayList<String> formatText(int intColumnSize, String[] texStringFormat) {
        ArrayList<String> myArray = new ArrayList<String>();
        String line = "";

        for (String word : texStringFormat) {
            if (line.length() + word.length() + 1 > intColumnSize) {
                // Add the current line to the list and reset it
                while(line.length()!=intColumnSize){
                    line +=" ";
                }
                myArray.add(line);
                line = "";
            }
            if (!line.isEmpty()) {
                // Add a space between words if the line is not empty
                line += " ";
            }
            line += word;
        }

        // Add the last line to the list
        if (!line.isEmpty()) {
            while(line.length()!=intColumnSize){
                line +=" ";
            }
            myArray.add(line);
        }

        return myArray;
    }
    
}

