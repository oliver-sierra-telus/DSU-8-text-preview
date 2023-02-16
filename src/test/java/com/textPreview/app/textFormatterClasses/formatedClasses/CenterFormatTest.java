
package com.textPreview.app.textFormatterClasses.formatedClasses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class CenterFormatTest {
    @Test
    public void checkTheCenterFormatTest() {
        CenterFormat c = new CenterFormat();

        String mySentence = "Donec quis mi eros Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nec hendrerit dolor. Donec convallis";
        String [] myArraySentence = mySentence.trim().split("[,.' ]+");
        ArrayList<String> expectedArray = new ArrayList<>();
        
        String[] expectedResult = {" Donec quis mi eros","       Lorem       ","  ipsum dolor sit  ","        amet       ","    consectetur    ","     adipiscing    ","   elit Duis nec   ","     hendrerit     ","    dolor Donec    ","     convallis     "};
        
        for (int i = 0; i < expectedResult.length; i++) {
            expectedArray.add(i, expectedResult[i]);
        }
        
        assertEquals(expectedArray, c.formatText(20, myArraySentence));
        
    }

    @Test
    public void checkSingletonPatternTest() {
        CenterFormat firstInstance;
        CenterFormat secondInstance;

        firstInstance = CenterFormat.getInstance();
        secondInstance = CenterFormat.getInstance();

        assertEquals(firstInstance, secondInstance);
    }
}
