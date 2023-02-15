package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses;

import java.util.Scanner;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses.JustifyFormat;

public class TextFormattingMenu {
    private int columnSize;
    private String[] words;
    private String textToFormat;

    public TextFormattingMenu() {

    }

    public void startMenu() {
        Scanner in = new Scanner(System.in);
        int option = 0;


        System.out.println("Ingrese el texto a justificar");
        textToFormat = in.nextLine();

        System.out.println("Ingrese el numero de columnas para el nuevo formato");
        columnSize = in.nextInt();

        words = splitWords(textToFormat);

        System.out.println();
        System.out.println();
        System.out.println("Cual formato quieres utilizar?");
        System.out.println("1. Justificado a la izquierda");
        System.out.println("2. Justificado a la derecha");
        System.out.println("3. Centrado");
        System.out.println("4. Justificado");
        System.out.println("5. Salir");
        option = in.nextInt();

        justifyText(option);

        



    }

    private String[] splitWords(String texStringFormat) {
        return texStringFormat.trim().split("[,.' ]+");
    }

    private void getWordCountForLine(){
        int spaceCounter = 0;
        int wordIndex = 0;
        int wordCounter = 0;


        
    }

    private void justifyText(int option) {

        switch (option) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                var justify = new JustifyFormat();
                var prueba = justify.formatText(columnSize, words);
                prueba.forEach((n)-> System.out.println(n));
                
                //return justify.formatText(columnSize,words);

                break;

            case 5:
                System.out.println("Saliendo...");
                break;

            default:
                break;
        }

    }

}
