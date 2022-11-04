import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CPU implements Player {
//    String type = "Easy";

    public CPU(){
//        type = this.type;
    }
    public boolean isRandomColorValid(Board GameBoard, String color){
        boolean isValid = true;
        switch(color){
            case "g":
                isValid = GameBoard.greens.isEmpty();
            case "y":
                isValid = GameBoard.yellows.isEmpty();
            case "o":
                isValid = GameBoard.oranges.isEmpty();
        }
        return isValid;

    }
    // make array of all the different colors
    public  String getRandomColor(Board GameBoard){ ///////////// saying color twice
        ArrayList<String> colors= GameBoard.validColors; ////////////// make function for error messages when typing invalid letter
        //select a random color
        Random random = new Random();

        int randomColorIndex = random.nextInt(colors.size());
        String randomColor = colors.get(randomColorIndex);
        // if color is empty, do recursive call

        // if you get an invalid color, find a different random
//        boolean bool = isRandomColorValid(GameBoard,randomColor);
//        if(!bool){
//            colors.remove(randomColor);
//            randomColorIndex = random.nextInt(colors.size());
//            randomColor = colors.get(randomColorIndex);
//        }
        return randomColor; ///////////check if color is valid later
    }

    public int getRandomNumber(String color){
//        String color = this.getRandomColor();

        // maxNumber: max number of values to remove
        int maxNumber = 0;
        switch (color){

            case "g":
                maxNumber = 3;

            case "y":
                maxNumber = 7;

            case "o":
                maxNumber = 5;
        }

        Random r = new Random();
        // gets random number btw 1 and the maxNumber - 1
        int randAmount= r.nextInt((maxNumber-1) - 1) + 1;

        System.out.println("The selected random amount: " + randAmount);
        return randAmount;
    }
    public void smartColorPick(){}
    public void smartRemoval(){}
}
