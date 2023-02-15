package com.textPreview.app.textFormatterClasses;

import java.util.ArrayList;
import java.util.Scanner;

import com.textPreview.app.textFormatterClasses.formatedClasses.CenterFormat;
import com.textPreview.app.textFormatterClasses.formatedClasses.JustifyFormat;
import com.textPreview.app.textFormatterClasses.formatedClasses.LeftFormat;
import com.textPreview.app.textFormatterClasses.formatedClasses.RightFormat;

public class TextFormattingMenu {
    private int columnSize;
    private String[] words;
    private String textToFormat;

    public TextFormattingMenu() {

    }

    public void startMenu() {
        Scanner in = new Scanner(System.in);
        int option = 0;
        System.out.println("-----------------------------------------------------");
        System.out.println("-Ingrese el texto a justificar");
        textToFormat = in.nextLine();
        System.out.println();
        System.out.println("-Ingrese el numero de columnas para el nuevo formato");
        columnSize = in.nextInt();
        System.out.println("-----------------------------------------------------");
        words = splitWords(textToFormat);
        do {
            
            option = 0;

            if(columnSize>=25){
                System.out.println("--------------------------------");
                System.out.println("-Cual formato quieres utilizar?-");
                System.out.println("--------------------------------");
                System.out.println("-1. Justificado a la izquierda -");
                System.out.println("-2. Justificado a la derecha   -");
                System.out.println("-3. Centrado                   -");
                System.out.println("-4. Justificado                -");
                System.out.println("-5. Salir                      -");
                System.out.println("--------------------------------");
                option = in.nextInt();
                justifyText(option);
            }
            else {
                System.out.println("**Ingresa un numero de columnas mayor a 25**");
            }

        } while(option!=5);

    }

    private String[] splitWords(String texStringFormat) {
        return texStringFormat.trim().split("[,.' ]+");
    }

    private void paintFormatedText(ArrayList<String> rowList, String borderChar) {
        String headerFoot = borderChar.repeat(rowList.get(0).length() + 2);
        System.out.println(headerFoot);
        rowList.forEach( (e) -> {
            System.out.print(borderChar);
            System.out.print(e);
            System.out.println(borderChar);
        });
        System.out.println(headerFoot);

    }

    private void justifyText(int option) {
        switch (option) {
            case 1:
                TextFormarter myFormat = LeftFormat.getInstance();
                ArrayList<String> leftFormatedText = myFormat.formatText(columnSize, words);
                //myArray.forEach(System.out::println);
                paintFormatedText(leftFormatedText, "-");
                break;
            case 2:
                TextFormarter formater = RightFormat.getInstance();
                ArrayList<String> rightFormatedText = formater.formatText(columnSize, words);
                paintFormatedText(rightFormatedText, "=");
                break;
            case 3:
                TextFormarter center = CenterFormat.getInstance();
                ArrayList<String> centerFormatedText = center.formatText(columnSize, words);
                paintFormatedText(centerFormatedText, "+");
                break;
            case 4:
                TextFormarter justify = JustifyFormat.getInstance();
                ArrayList<String> justifyFormatedText = justify.formatText(columnSize, words);
                paintFormatedText(justifyFormatedText, "*");

                // return justify.formatText(columnSize,words);
                // prueba.forEach(e -> System.out.println(e));

                break;

            case 5:
                System.out.println("Saliendo...");
                break;

            default:
                System.out.println("Ingresa una opcion valida");
                break;
        }

    }

}
