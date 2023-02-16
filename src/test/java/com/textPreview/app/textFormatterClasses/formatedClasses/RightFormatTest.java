package com.textPreview.app.textFormatterClasses.formatedClasses;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import com.textPreview.app.textFormatterClasses.TextFormarter;

public class RightFormatTest {
    private static RightFormat intancia;

    @Test
    public void shouldSingleton() {
        TextFormarter myFormat = RightFormat.getInstance();
        TextFormarter mySecondFormat = RightFormat.getInstance();
        assertEquals(myFormat, mySecondFormat);
    }

    @Test
    public void shouldSplitWords() {
        String[] words = { "Hola", "Andres", "Cordova" };
        String text = "Hola, Andres. Cordova";
        String[] wordsSplit;

        wordsSplit = splitWords(text);

        assertArrayEquals(words, wordsSplit);
    }

    @Test
    public void shouldRightFormat() {
        RightFormat rightFormat = new RightFormat();

        String mySentence = "Hola a todos esta es una prueba de nuestro test para justificar a la derecha.";
        String[] myArraySentence = mySentence.trim().split("[,.' ]+");
        ArrayList<String> expected = new ArrayList<>();
        expected.add(0, "   Hola a todos esta");
        expected.add(1, "    es una prueba de");
        expected.add(2, "   nuestro test para");
        expected.add(3, "     justificar a la");
        expected.add(4, "             derecha");

        assertEquals(expected, rightFormat.formatText(20, myArraySentence));
    }

    @Test
    public void shouldSameSize() {
        RightFormat rightFormat = new RightFormat();

        String mySentence = "Hola a todos esta es una prueba de nuestro test para justificar a la derecha.";
        String[] myArraySentence = mySentence.trim().split("[,.' ]+");
        ArrayList<String> expected = rightFormat.formatText(20, myArraySentence);

        int num = expected.size();

        assertEquals(5, num);
    }

    public static RightFormat getInstance() {
        if (intancia == null) {
            intancia = new RightFormat();
        }
        return intancia;
    }

    private String[] splitWords(String texStringFormat) {
        return texStringFormat.trim().split("[,.' ]+");
    }
}
