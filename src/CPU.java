import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CPU implements Player {
    String type = "Easy";

    public CPU(String type){
        this.type = type;
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

    public int getRandomNumber(String color, Board GameBoard){
//        String color = this.getRandomColor();

        // maxNumber: max number of values to remove
        int maxNumber = 0;
        switch (color){

            // make sure that the max number that you can pick is  not larger than the arrayList
            case "g":
                maxNumber = GameBoard.greens.size();

            case "y":
                maxNumber = GameBoard.yellows.size();

            case "o":
                maxNumber = GameBoard.oranges.size();
        }

        Random r = new Random();
        // gets random number btw 1 and the maxNumber - 1
        int randAmount= r.nextInt((maxNumber-1) - 1) + 1;

        System.out.println("The selected random amount: " + randAmount);
        return randAmount;
    }

    public void getXORmarker(Board GameBoard){
        /*
    if you have a winning position, do this \

        test removing a stone increasingly in each marker pile. make an array of marker removals that result in a xor of 0

    if you dont, just use random
     */

        // current XOR
        int xorNum = GameBoard.opXOR(GameBoard.greens.size(), GameBoard.yellows.size(),GameBoard.oranges.size());




        if(xorNum != 0){
            // iterate through each marker array and find combinations that make xorNum = 0


        }

    }
    public void getWinPairs(ArrayList<String[]> winXOR,String color,Board GameBoard){
//        ArrayList<String[]> winXOR = new ArrayList<String[]>();
        switch(color){
            case "g":
                // go through all pairs that give you 0 with XOR operator
                for(int i = 1; i< GameBoard.greens.size();i++){
                    int newGreens = GameBoard.greens.size() - i;
                    if(GameBoard.opXOR(newGreens,GameBoard.yellows.size(),GameBoard.oranges.size()) == 0 ){
                        String[] winPair = {"g",Integer.toString(i)};
                        winXOR.add(winPair);
                    }
                }
                break;
            case "y":
                for(int i = 1; i< GameBoard.yellows.size();i++){
                    int newYellows = GameBoard.yellows.size() - i;
                    if(GameBoard.opXOR(GameBoard.greens.size(),newYellows,GameBoard.oranges.size()) == 0 ){
                        String[] winPair = {"y",Integer.toString(i)};
                        winXOR.add(winPair);
                    }
                }
                break;
            case "o":
                for(int i = 1; i< GameBoard.oranges.size();i++){
                    int newOranges = GameBoard.oranges.size() - i;
                    if(GameBoard.opXOR(GameBoard.greens.size(),GameBoard.yellows.size(),newOranges) == 0 ){
                        String[] winPair = {"o",Integer.toString(i)};
                        winXOR.add(winPair);
                    }
                }
                break;
        }
//        return winXOR;

    }

    public String[] getXORmove(ArrayList<String[]> getWinPairs){
        //// deal with case when there are NO string arrays


        Random random = new Random();
        int randomMoveIndex = random.nextInt(getWinPairs.size());
        String[] randomPair = getWinPairs.get(randomMoveIndex);

        System.out.println("CPU has decided to pick the color: " + randomPair[0]);
        System.out.println("CPU has decided to take out " + randomPair[1]+ " pairs");
        return randomPair;
    }

    public void xorMarkerRemoval(String[] move,Board GameBoard){
        String color = move[0];
        int amount = Integer.parseInt(move[1]);

        switch (color) { //////// maybe make a helper function
            case "g":
                GameBoard.removeMarker(GameBoard.greens,  amount);
                break;
            case "y":
                GameBoard.removeMarker(GameBoard.yellows,  amount);
                break;
            case "o":
                GameBoard.removeMarker(GameBoard.oranges, amount);
                break;
        }
    }

    public void smartColorPick(){}
    public void smartRemoval(){}
}
