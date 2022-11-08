import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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
        System.out.println("----------------------");
        System.out.println("These are all of the remaining markers");
        System.out.println("Green" + this.greens);
        System.out.println("Yellow" + this.yellows);
        System.out.println("Oranges" + this.oranges);
        System.out.println("----------------------");
    }



    public void run(){
        // who goes first
        Scanner initializeGame = new Scanner(System.in);
        System.out.println("Who will go first?");
        System.out.println("1: The User (You)" );
        System.out.println("2: The CPU");
        System.out.println("----------------------");
        Integer whosFirst = initializeGame.nextInt();

        // random vs smart mode
        System.out.println("Pick the difficulty of the CPU:");
        System.out.println("----------------------");

        // easy uses random selection
        System.out.println("1: Random");
        System.out.println("2: Hard" );

        Integer cpuDifficulty = initializeGame.nextInt();
        User User = new User();
        // initial CPU (you should not see this)
        CPU Cpu = new CPU("not typed yet");
        // change type of CPU to random or XOR(hard)
        switch(cpuDifficulty){
            case 1:
                System.out.println("You chose the random CPU");
                System.out.println("----------------------");
                System.out.println("----------------------");
                Cpu = new CPU("random");
                break;
            case 2:
                System.out.println("You chose the hard CPU. Good luck!!");
                System.out.println("----------------------");
                System.out.println("----------------------");
                Cpu = new CPU("xor");
                break;
        }
        this.printBoard();
        switch (whosFirst){
            case 1:
                this.userFirstOrder(User,Cpu);
                break;
            case 2:
                this.cpuFirstOrder(User,Cpu);
                break;

        }
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Thank you for Playing :D");

    }

    public void userFirstOrder(User User,CPU Cpu){

        boolean gameover = false;
        while(gameover == false) {

            // User moves
            this.userMove(User,gameover);
            this.printBoard();
            this.updateValidColors();

            gameover = this.isWinner(User);

            // CPU moves
//            this.RandomMove(Cpu,gameover);
//            this.printBoard();
//            this.updateValidColors();
//
//            if(gameover == false){
//                gameover = this.isWinner(Cpu);
//            }
            // if the winner has not yet been determined, let the CPU play a turn
            if(gameover == false){
            if(Cpu.type == "random"){
                this.RandomMove(Cpu,gameover);

            }
            else if(Cpu.type == "xor"){
                // calculate the XOR value
                int xorSum = opXOR(this.greens.size(),this.yellows.size(),this.oranges.size());
                // if the CPU is in a losing position, the CPU will play randomly
                if(xorSum == 0){
                    this.RandomMove(Cpu,gameover);
                    this.printBoard();
                    this.updateValidColors();
                }
                else{
                    // make array for winning moves [color, amountToRemove]
                    ArrayList<String[]> winXORs = new ArrayList<String[]>();
                    if(oneGroupRemaining(this.greens,this.yellows,this.oranges)){
                        this.greens.clear();
                        this.yellows.clear();
                        this.oranges.clear();
                        System.out.println("The CPU took the last remaining set of markers");

                    }

                    else {

                        // add all winning pairs to winXOR
                        Cpu.getWinPairs(winXORs, "g", this);
                        Cpu.getWinPairs(winXORs, "y", this);
                        Cpu.getWinPairs(winXORs, "o", this);

                        // get random pair from winXOR
                        // we will use this to remove some markers

                        if (winXORs.size() == 0) {

                        } else {
                            String[] xorPairToRemove = Cpu.getXORmove(winXORs);
                            Cpu.xorMarkerRemoval(xorPairToRemove, this);
                        }
                    }




                }
            }

            this.printBoard();
            this.updateValidColors();


                gameover = this.isWinner(Cpu);
            }



//            System.out.println(gameover);

        }
    }
    public void cpuFirstOrder(User User,CPU Cpu){

        // results tell player who won the game
        boolean gameover = false;
        while(gameover == false) {
            if(Cpu.type == "random"){
                this.RandomMove(Cpu,gameover);

            }
            else if(Cpu.type == "xor"){
                // calculate the XOR value
                int xorSum = opXOR(this.greens.size(),this.yellows.size(),this.oranges.size());
                // if the CPU is in a losing position, the CPU will play randomly
                if(xorSum == 0){
                    this.RandomMove(Cpu,gameover);
                    this.printBoard();
                    this.updateValidColors();
                }
                else{
                    // make array for winning moves [color, amountToRemove]
                    ArrayList<String[]> winXORs = new ArrayList<String[]>();
                    if(oneGroupRemaining(this.greens,this.yellows,this.oranges)){
                        this.greens.clear();
                        this.yellows.clear();
                        this.oranges.clear();
                        System.out.println("The CPU took the last remaining set of markers");

                    }

                    else {

                        // add all winning pairs to winXOR
                        Cpu.getWinPairs(winXORs, "g", this);
                        Cpu.getWinPairs(winXORs, "y", this);
                        Cpu.getWinPairs(winXORs, "o", this);

                        // get random pair from winXOR
                        // we will use this to remove some markers

                        if (winXORs.size() == 0) {

                        } else {
                            String[] xorPairToRemove = Cpu.getXORmove(winXORs);
                            Cpu.xorMarkerRemoval(xorPairToRemove, this);
                        }
                    }

                }
            }

            this.printBoard();
            this.updateValidColors();
            gameover = this.isWinner(Cpu);



//            System.out.println(gameover);

            /// ADD CASE FOR SMART CPU
            // if a winner has not been determines yet, the User gets a chance to play
            if(gameover == false){
            this.userMove(User,gameover);
            this.printBoard();
            this.updateValidColors();


                gameover = this.isWinner(User);
            }

        }
    }
//    public void run(){
//        if(whosFirst = 1){
//
//        }
//    }

    public void removeMarker(ArrayList<String> markers,  int amount){
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
        if(gameOver == true){
            System.out.println("You, the User has lost the game. ");
        }
        else {
            String color = User.pickColor();
            int amount = User.pickAmount();
            switch (color) { //////// maybe make a helper function
                case "g":
                    this.removeMarker(this.greens,  amount);
                    break;
                case "y":
                    this.removeMarker(this.yellows,  amount);
                    break;
                case "o":
                    this.removeMarker(this.oranges, amount);
                    break;
            }
//            this.isWinner(User); ///////        remove??????
        }
    }
    public void RandomMove(CPU Cpu,boolean gameOver){
        if(gameOver == true){
            System.out.println("The CPU has lost the game");

        }
        else {
            String colorCPU = Cpu.getRandomColor(this);
//        while(!GameBoard.isRandomColorValid(colorCPU)){ /// FIX PICKING WRONG COLOR ERROR
//            colorCPU = Cpu.getRandomColor();
//            }
            // check to see if color is valid
            System.out.println("The CPU has selected the random color:  " + colorCPU);
            int amountCPU = Cpu.getRandomNumber(colorCPU,this);

            switch (colorCPU) {
                case "g":
                    this.removeMarker(this.greens,  amountCPU);
                    break;
                case "y":
                    this.removeMarker(this.yellows,  amountCPU);
                    break;
                case "o":
                    this.removeMarker(this.oranges, amountCPU);
                    break;
            }
//            this.isWinner(Cpu);
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

        System.out.println("This array shows what colored sets remain");
        System.out.println("----------------------");
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
        boolean isWinner = false;

        // if all the arrays are empty, the person who took the last stone is the winner
        if (this.validColors.isEmpty()) {
            boolean alreadyFoundWinner = true;
            isWinner = true;
            if (player instanceof User) {
                System.out.println("And the Winner is..... the User");
                System.out.println("----------------------");
//                System.out.println("----------------------");
//                System.out.println("----------------------");

            } else if (player instanceof CPU) {
                System.out.println("And the Winner is..... the Cpu");
            }
            // if the game isn't over, print a line
            else {
                System.out.println();
                System.out.println("no winner yet");
                System.out.println();
            }

        } return isWinner;
    }

    // Xor operation: ^
// function
    public int opXOR(int aOne, int aTwo, int aThree){

        //apply bit operator
        int xor = aOne ^ aTwo ^ aThree;

        return xor;
    }

    // check to see if only one pair remains in
    public boolean oneGroupRemaining(ArrayList<String> gs,ArrayList<String>ys, ArrayList<String>os){
        boolean bool = false;
        if((gs.size() != 0) && (ys.size() == 0) && (os.size() ==0)){
            bool = true;
        }
        if((gs.size() == 0) && (ys.size() != 0) && (os.size() ==0)){
            bool = true;
        }
        if((gs.size() == 0) && (ys.size() == 0) && (os.size() !=0)){
            bool = true;
        }

            return bool;
    }
}





