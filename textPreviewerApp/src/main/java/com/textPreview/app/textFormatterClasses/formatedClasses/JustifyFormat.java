package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class JustifyFormat extends TextFormarter {
    private static int wordTextIndex = 0;

    @Override
    public void formatText(int intColumnSize, String texStringFormat){
        int rows = (texStringFormat.length() / intColumnSize) + 1;
        String words[] = splitWords(texStringFormat);

        for (int i = 0; i < rows; i++) {
            String line = lineGenerator(intColumnSize, words);
            System.out.println(line);
        }
 
    }

    private String[] splitWords(String texStringFormat){
        return texStringFormat.trim().split("[,.' ]+");
    }
    
    private String lineGenerator(int intColumnSize, String words[]){
        int wordCounter = 0;
        int spaceCounter = 0;
        int remainingSpace = 0;
        int spaceDistribution = 0;
        int wordIndex = 0;
        int spaceDistributionCounter = 0;
        int spacesToAdd = 0;
        String lineBuilding = "";
        String whiteSpace = " ";


        while((spaceCounter += words[wordIndex].length()) < intColumnSize ){
            spaceCounter+= words[wordIndex].length();
            if(spaceCounter!=intColumnSize){
                spaceCounter++;
            }
            wordCounter++;
        }

        spaceDistribution = ((intColumnSize-spaceCounter)/wordCounter)+1;
        spacesToAdd = (intColumnSize-spaceCounter);


        for (int i = 0; i < wordCounter; i++) {
            if(wordTextIndex == words.length-1) return lineBuilding;


            lineBuilding += words[wordTextIndex];
            if(lineBuilding.length() != intColumnSize){

                if(spaceDistributionCounter!=spacesToAdd){
                    
                    //TODO FIX THIS
                    lineBuilding += whiteSpace.repeat(spaceDistribution);

                    spaceDistributionCounter++;
                }
                else{
                    lineBuilding += whiteSpace;
                }


            }
            wordTextIndex++;


            
        }

        return lineBuilding; 
    }
}
