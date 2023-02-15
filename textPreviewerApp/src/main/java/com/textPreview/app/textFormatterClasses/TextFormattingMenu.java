package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses;

import java.util.ArrayList;
import java.util.Scanner;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses.JustifyFormat;
import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses.RightFormat;
import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses.LeftFormat;

public class TextFormattingMenu {
    private int columnSize;
    private String[] words;
    private String textToFormat;

    public TextFormattingMenu() {

    }

    public void startMenu() {
        int option = 0;
        do {
            Scanner in = new Scanner(System.in);
            option = 0;

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
        } while (option != 5);

    }

    private String[] splitWords(String texStringFormat) {
        return texStringFormat.trim().split("[,.' ]+");
    }

    private void getWordCountForLine() {
        int spaceCounter = 0;
        int wordIndex = 0;
        int wordCounter = 0;

    }

    private void paintFormatedText(ArrayList<String> rowList, String borderChar) {

        String headerFoot = borderChar.repeat(rowList.get(0).length() + 2);
        System.out.println(headerFoot);
        rowList.forEach(e -> {
            System.out.print(borderChar);
            System.out.print(e);
            System.out.println(borderChar);
        });
        System.out.println(headerFoot);

    }

    private void justifyText(int option) {
        switch (option) {
            case 1:
                TextFormarter myFormat = new LeftFormat();
                ArrayList<String> myArray = myFormat.formatText(columnSize, words);
                myArray.forEach(System.out::println);
                break;
            case 2:
                TextFormarter formater = RightFormat.getInstance();
                var righText = formater.formatText(columnSize, words);
                paintFormatedText(righText, "+");
                break;
            case 3:

                break;
            case 4:
                var justify = new JustifyFormat();
                var prueba = justify.formatText(columnSize, words);
                paintFormatedText(prueba, "*");

                // return justify.formatText(columnSize,words);
                // prueba.forEach(e -> System.out.println(e));

                break;

            case 5:
                System.out.println("Saliendo...");
                break;

            default:
                break;
        }

    }

}
