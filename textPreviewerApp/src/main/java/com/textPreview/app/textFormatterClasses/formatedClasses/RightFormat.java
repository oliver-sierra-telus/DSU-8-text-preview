package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class RightFormat extends TextFormarter {

    @Override
    public void formatText(int intColumnSize, String texStringFormat) {

        int longitud =0, partes = 0, residuo=0, indice=0, num=intColumnSize;
        String cadena=texStringFormat;

        longitud = cadena.length();
        partes = longitud/num;
        residuo = longitud%num;

        for (int i = 0; i < partes; i++) {
            System.out.print("                   ");
            for(int j=0; j < num; j++){
                System.out.print(cadena.charAt(indice));
                indice++;
            }
            System.out.println("");
        }

        if(residuo != 0){
            System.out.print("                   ");
            for (int i = 0; i < residuo; i++) {
                System.out.print(cadena.charAt(indice));
                indice++;
            }
        }

    }

}
