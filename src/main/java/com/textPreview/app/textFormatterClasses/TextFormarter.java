package com.textPreview.app.textFormatterClasses;

import java.util.ArrayList;

public abstract class TextFormarter {

    protected int intColumnSize;
    protected String textToFormat;

    protected abstract ArrayList<String> formatText(int intColumnSize, String[] wordsArray);
        
}
