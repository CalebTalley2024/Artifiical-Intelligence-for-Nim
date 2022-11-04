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
        if (this.isEmpty() == true) {
            if (player instanceof User) {
                System.out.println("Winner: User");

            } else if (player instanceof CPU) {
                System.out.println("Winner: Cpu");
            }
            // if the game isn't over, print a line
            else {
                System.out.println("no winner yet");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        } return true;
    }

    public void Initialize(){
        Scanner initializeGame = new Scanner(System.in);
        System.out.println("Who do you want to start the game first");
        System.out.println("1: The CPU");
        System.out.println("2: The User (You)" );
        Integer whosFirst = initializeGame.nextInt();

        System.out.println("Pick the difficulty of the CPU you face");
        // easy uses random selection
        System.out.println("1: Easy");
        System.out.println("2: Impossible" );

        Integer cpuDifficulty = initializeGame.nextInt();
       printBoard();
    }
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

    public void userMove(User user){

    }



}
