package textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.formatedClasses;

import textPreviewerApp.src.main.java.com.textPreview.app.textFormatterClasses.TextFormarter;

public class JustifyFormat extends TextFormarter {
    private static int wordTextIndex = 0;
    private static int wordIndex = 0;

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
        int spaceDistributionCounter = 0;
        int spacesToAdd = 0;
        String lineBuilding = "";
        String whiteSpace = " ";


        while((spaceCounter + words[wordIndex].length()) < intColumnSize ){
            spaceCounter+= words[wordIndex].length();
            wordIndex++;
            if(spaceCounter!=intColumnSize){
                spaceCounter++;
            }
            wordCounter++;
        }

        spaceDistribution = ((intColumnSize-(spaceCounter-1))/wordCounter)+1;
        spacesToAdd = (intColumnSize-(spaceCounter-1));


        for (int i = 0; i < wordCounter; i++) {
            if(wordTextIndex == words.length) return lineBuilding;


            lineBuilding += words[wordTextIndex];

            if(lineBuilding.length() <= intColumnSize){

                if(spaceDistributionCounter!=spacesToAdd && (spacesToAdd-spaceDistributionCounter)>=2){
                    
                    //TODO FIX THIS
                    lineBuilding += whiteSpace.repeat(spaceDistribution+1);
                    spaceDistributionCounter+=spaceDistribution;

                } else if((spacesToAdd-spaceDistributionCounter)==1){
                    lineBuilding += whiteSpace.repeat(spaceDistribution);
                    spaceDistributionCounter++;
                }
                else if(lineBuilding.length() == intColumnSize){
                    
                } else{
                    lineBuilding += whiteSpace;
                }

            }
            wordTextIndex++;


            
        }


        return lineBuilding+="|"; 
    }
}
