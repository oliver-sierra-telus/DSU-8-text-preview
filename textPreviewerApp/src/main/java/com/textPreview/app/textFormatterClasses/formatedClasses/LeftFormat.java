package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import java.util.ArrayList;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class LeftFormat extends TextFormarter {

    @Override
    protected ArrayList<String> formatText(int intColumnSize, String[] texStringFormat) {
        // TODO Auto-generated method stub

        
        int length = texStringFormat.length;//Comentado x Oscar
        int lines = length / intColumnSize;

        if(length % intColumnSize != 0) {  //aqui termino de calcular cuantas lineas voy a tener para imprimir por eso es el limite en el for
            lines++;
        }

        for (int i = 0; i < lines; i++) {
            int start = i * intColumnSize;
            int end = Math.min(length, start + intColumnSize);
            System.out.println(texStringFormat[i].substring(start, end));//Comentado x Oscar
        }
        

        return new ArrayList<>();
    }
    
}
