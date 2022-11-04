import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

// 1. FIND OUT ???????????????????????????
public class Main {

    ////////////////////////// function for who goes first


    // 1: User
    // 2: CPU
    public static void main(String[] args) {
        Board GameBoard = new Board();

        // initiallize GameBoard and players
        GameBoard.Initialize();
        User User = new User();
        CPU Cpu = new CPU("Easy");
        boolean gameContinue = true;
        while(gameContinue){

        // User
        // pick color and amount you want to remove
        String color = User.pickColor();
        int amount = User.pickAmount();

        // get rid of the marker
        switch (color) { //////// maybe make a helper function
            case "g":
                GameBoard.removeMarker(GameBoard.greens,color,amount);
                break;
            case "y":
                GameBoard.removeMarker(GameBoard.yellows,color,amount);
                break;
            case "o":
                GameBoard.removeMarker(GameBoard.oranges,color,amount);
                break;
        }
        // print the board after
        GameBoard.printBoard();
        GameBoard.isWinner(User);
        GameBoard.updateValidColors();
            System.out.println();
            System.out.println("valid colors:   " + GameBoard.validColors);
            System.out.println();
        System.out.println("CPU's turn");

        ////CPU

        String colorCPU = Cpu.getRandomColor(GameBoard);
//        while(!GameBoard.isRandomColorValid(colorCPU)){ /// FIX PICKING WRONG COLOR ERROR
//            colorCPU = Cpu.getRandomColor();
//            }
        // check to see if color is valid
        System.out.println("The selected random color:  "+ colorCPU);
        int amountCPU = Cpu.getRandomNumber(colorCPU);

        switch (colorCPU) {
            case "g":
                GameBoard.removeMarker(GameBoard.greens,colorCPU,amountCPU);
                break;
            case "y":
                GameBoard.removeMarker(GameBoard.yellows,colorCPU,amountCPU);
                break;
            case "o":
                GameBoard.removeMarker(GameBoard.oranges,colorCPU,amountCPU);
                break;
        }
        GameBoard.printBoard();
            GameBoard.updateValidColors();
            System.out.println();
            System.out.println("valid colors:   " + GameBoard.validColors);
            System.out.println();
        System.out.println("howd we do?");
    }
    }
}




