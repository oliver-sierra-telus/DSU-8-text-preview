package com.textPreview.app.textFormatterClasses.formatedClasses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class LeftFormatTest {
    
@Test
public void isSingleton() {
    LeftFormat leftFormat = LeftFormat.getInstance();
    LeftFormat leftFormat2 = LeftFormat.getInstance();
    assertEquals(leftFormat, leftFormat2);
}


@Test
public void isTextFormattedByExpectedLines() {
    LeftFormat leftFormat = new LeftFormat();
    String[] words = { "Donec", "quis", "mi", "eros", "Lorem", "ipsum", "dolor", "amet", "consecteur", "adipiscing",
            "elit" };
    ArrayList<String> input = leftFormat.formatText(20, words);
    int number = input.size();
    assertEquals(4, number);
}
}
