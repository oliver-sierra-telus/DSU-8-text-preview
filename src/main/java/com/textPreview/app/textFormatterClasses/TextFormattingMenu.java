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
        columnSize = 0;

        System.out.println("-----------------------------------------------------");
        System.out.println("-Enter text to justify:");
        textToFormat = in.nextLine();
        words = splitWords(textToFormat);
        System.out.println();
        System.out.println("-Enter the amount of columns to the new format: (Between 10 to 50 columns)");
        while (columnSize < 10 || columnSize > 50) {
            System.out.print("\tYour option: ");
            columnSize = in.nextInt();
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("--------------------------------");
        System.out.println("-Select your prefered justification style:-");
        System.out.println("--------------------------------");
        System.out.println("-1. Left justified             -");
        System.out.println("-2. Right justified            -");
        System.out.println("-3. Center justified           -");
        System.out.println("-4. Justified                  -");
        System.out.println("-5. Salir                      -");
        System.out.println("--------------------------------");
        while (option < 1 || option > 5) {
            System.out.print("\tYour option: ");
            option = in.nextInt();
        }
        justifyText(option);
    }

    private String[] splitWords(String texStringFormat) {
        return texStringFormat.trim().split("[,.' ]+");
    }

    private void paintFormatedText(ArrayList<String> rowList, String borderChar) {
        String headerFoot = borderChar.repeat(rowList.get(0).length() + 2);
        System.out.println(headerFoot);
        rowList.forEach((e) -> {
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
