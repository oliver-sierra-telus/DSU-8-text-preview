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
                while(line.length()!=intColumnSize){
                    line +=" ";
                }
                myArray.add(line);
                line = "";
            }
            if (!line.isEmpty()) {
                line += " ";
            }
            line += word;
        }

        if (!line.isEmpty()) {
            while(line.length()!=intColumnSize){
                line +=" ";
            }
            myArray.add(line);
        }

        return myArray;
    }
}