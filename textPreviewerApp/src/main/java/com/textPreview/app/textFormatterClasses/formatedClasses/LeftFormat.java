package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class LeftFormat extends TextFormarter {

    @Override
    protected void formatText(int intColumnSize, String texStringFormat) {
        
        int length = texStringFormat.length();
        int lines = length / intColumnSize;

        if(length % intColumnSize != 0) {  //aqui termino de calcular cuantas lineas voy a tener para imprimir por eso es el limite en el for
            lines++;
        }

        for (int i = 0; i < lines; i++) {
            int start = i * intColumnSize;
            int end = Math.min(length, start + intColumnSize);
            System.out.println(texStringFormat.substring(start, end));
        }
    }
    
}
