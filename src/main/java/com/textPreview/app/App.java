package com.textPreview.app;

import com.textPreview.app.textFormatterClasses.TextFormattingMenu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //var prueba = JustifyFormat.getInstance();
        String cadena = "Donec quis mi eros Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nec hendrerit dolor. Donec convallis suscipit porta. Donec quis mi eros. Suspendisse aliquam ornare turpis, vel imperdiet erat elementum vitae. Nam accumsan risus eu risus tincidunt convallis. Donec varius congue mi, vitae pellentesque risus luctus sit amet. Suspendisse a interdum nisi, sed eleifend metus. Nunc sollicitudin quis dolor quis porta. Morbi fringilla quis tellus id finibus. Proin ornare eros eget mauris sodales, sed ornare ante dapibus.";

        TextFormattingMenu Menu = new TextFormattingMenu();
        Menu.startMenu();

        //prueba.formatText(70, cadena);
    }
}
