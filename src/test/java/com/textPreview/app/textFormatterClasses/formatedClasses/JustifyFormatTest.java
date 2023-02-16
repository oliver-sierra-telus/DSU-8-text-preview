package com.textPreview.app.textFormatterClasses.formatedClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.textPreview.app.textFormatterClasses.TextFormarter;

public class JustifyFormatTest {
    @Test
    public void testLenghtJustifiedText() {
        JustifyFormat testing = JustifyFormat.getInstance();
        String words[] = { "hola", "Probando" };
        int length = (testing.formatText(25, words).get(0).length());

        assertEquals(25, length);
    }

    @Test
    public void testingSingletonIstance() {
        TextFormarter testing = JustifyFormat.getInstance();
        assertNotNull((testing));
    }
}
