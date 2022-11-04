import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Board {
    ArrayList<String> greens;
    ArrayList<String> yellows;
    ArrayList<String> oranges;

    ArrayList<String> validColors;

    public Board(){
        greens = new ArrayList<>(Arrays.asList("g","g","g"));
        yellows = new ArrayList<>(Arrays.asList("y","y","y","y","y","y","y"));
        oranges = new ArrayList<>(Arrays.asList("o","o","o","o","o"));
        validColors = new ArrayList<>(Arrays.asList("g","y","o"));

    }
    public void printBoard(){
        System.out.println("Green" + this.greens);
        System.out.println("Yellow" + this.yellows);
        System.out.println("Oranges" + this.oranges);
        System.out.println();
    }



    public void run(){
        // who goes first
        Scanner initializeGame = new Scanner(System.in);
        System.out.println("Who do you want to start the game first");
        System.out.println("1: The User (You)" );
        System.out.println("2: The CPU");
        Integer whosFirst = initializeGame.nextInt();

        // random vs smart mode
        System.out.println("Pick the difficulty of the CPU you face");
        // easy uses random selection
        System.out.println("1: Easy");
        System.out.println("2: Impossible" );

        Integer cpuDifficulty = initializeGame.nextInt();
        User User = new User();
        CPU Cpu = new CPU();
        switch (whosFirst){
            case 1:
                this.userFirstOrder(User,Cpu);
            case 2:
                this.cpuFirstOrder(User,Cpu);

        }

       printBoard();
    }

    public void userFirstOrder(User User,CPU Cpu){
        boolean gameover = false;
        while(true) {
            this.userMove(User,gameover);
            this.updateValidColors();
            System.out.println();
            System.out.println("valid colors:   " + this.validColors);
            System.out.println();

                this.RandomMove(Cpu,gameover);
            this.updateValidColors();
            System.out.println();
            System.out.println("valid colors:   " + this.validColors);
            System.out.println();
            /// ADD CASE FOR SMART CPU
        }
    }
    public void cpuFirstOrder(User User,CPU Cpu){

        // results tell player who won the game
        boolean gameover = false;

        while(!gameover) {
            this.RandomMove(Cpu,gameover);
            this.printBoard();
//            this.updateValidColors();

            gameover = this.isWinner(Cpu);
            System.out.println(gameover);

            /// ADD CASE FOR SMART CPU

            this.userMove(User,gameover);
            this.printBoard();
//            this.updateValidColors();

            gameover = this.isWinner(User);

        }
    }
//    public void run(){
//        if(whosFirst = 1){
//
//        }
//    }

    public void removeMarker(ArrayList<String> markers, String color, int amount){
//        for(int i = 0; i<amount ;i++)
        // use counter to remove markers
        int counter = 0;
        // we use amount -1 because the array is 0-based
        while(counter < amount ){
            markers.remove(0);
            counter++;
        }
    }

    public void userMove(User User, boolean gameOver){
        if(gameOver == false){
            System.out.println("The User has lost the game");
        }
        else {
            String color = User.pickColor();
            int amount = User.pickAmount();
            switch (color) { //////// maybe make a helper function
                case "g":
                    this.removeMarker(this.greens, color, amount);
                    break;
                case "y":
                    this.removeMarker(this.yellows, color, amount);
                    break;
                case "o":
                    this.removeMarker(this.oranges, color, amount);
                    break;
            }
            this.isWinner(User);
        }
    }
    public void RandomMove(CPU Cpu,boolean gameOver){
        if(gameOver == false){
            System.out.println("The Cpu has lost the game");

        }
        else {
            String colorCPU = Cpu.getRandomColor(this);
//        while(!GameBoard.isRandomColorValid(colorCPU)){ /// FIX PICKING WRONG COLOR ERROR
//            colorCPU = Cpu.getRandomColor();
//            }
            // check to see if color is valid
            System.out.println("The selected random color:  " + colorCPU);
            int amountCPU = Cpu.getRandomNumber(colorCPU);

            switch (colorCPU) {
                case "g":
                    this.removeMarker(this.greens, colorCPU, amountCPU);
                    break;
                case "y":
                    this.removeMarker(this.yellows, colorCPU, amountCPU);
                    break;
                case "o":
                    this.removeMarker(this.oranges, colorCPU, amountCPU);
                    break;
            }
            this.isWinner(Cpu);
        }
    }

    public void updateValidColors(){
        if(this.greens.isEmpty()){
            this.validColors.remove("g");
        }
        if(this.yellows.isEmpty()){
            this.validColors.remove("y");
        }
        if(this.oranges.isEmpty()){
            this.validColors.remove("o");
        }
        System.out.println(this.validColors);
    }
    public boolean isEmpty(){
        // if all the markers are gone, return true
        if(this.greens.isEmpty()&& this.yellows.isEmpty() && this.oranges.isEmpty()){
            return true;
        }
        else {return false;}

    }
    public boolean isWinner(Player player) {
        // if all the arrays are empty, the person who took the last stone is the winner
        if (this.validColors.isEmpty()) {
            if (player instanceof User) {
                System.out.println("Winner: User");

            } else if (player instanceof CPU) {
                System.out.println("Winner: Cpu");
            }
            // if the game isn't over, print a line
            else {
                System.out.println();
                System.out.println("no winner yet");
                System.out.println();
            }

        } return true;
    }



}
