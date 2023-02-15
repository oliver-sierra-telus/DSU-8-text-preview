package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import java.util.ArrayList;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class CenterFormat extends TextFormarter {

    @Override
    public void formatText(int intColumnSize, String texStringFormat) {
        
        String[] cadenaSplit = texStringFormat.split(" ", 100);
        
        ArrayList<String> matrix = new ArrayList<>();
        String miCadena = "";
        for (int i = 0; i < cadenaSplit.length; i++) {
            if ((miCadena.length()+cadenaSplit[i].length())<intColumnSize) {
                miCadena += cadenaSplit[i];
                miCadena += " ";
            } else {
                String firstPart = cadenaSplit[i].substring(0,2) + "-";
                String secondPart = cadenaSplit[i].substring(2);
                miCadena += firstPart;
                matrix.add(miCadena);
                miCadena = "";
                miCadena += secondPart;
                miCadena += " ";
            }
        }
        matrix.forEach(element -> System.out.println(element));
    }

}
