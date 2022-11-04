import java.util.ArrayList;
import java.util.Scanner;

public class User implements Player {

    public User(){}



    public String pickColor(){
        Scanner whichColor = new Scanner(System.in);
        System.out.println("User: Which color would you like to  remove? ");
        System.out.println("green: g,  yellow: y,  orange: o");
        String colorSelected = whichColor.nextLine();
        System.out.println("you selected" + ":    " + colorSelected);
        return colorSelected;
    }

    public int pickAmount(){
        Scanner howManyMarkers= new Scanner(System.in);
        System.out.println("select how many markers you want to get rid of");
        Integer numTakeout = howManyMarkers.nextInt();
        System.out.println("you picked:" + numTakeout);
        return numTakeout;
    }

    // remove elements from the list









}
