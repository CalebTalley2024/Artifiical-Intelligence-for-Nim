import java.util.ArrayList;
import java.util.Scanner;

public class User implements Player {

    public User(){}



    public String pickColor(){
        Scanner whichColor = new Scanner(System.in);
        System.out.println("User: Which color would you like to remove? ");
        System.out.println("green: g,  yellow: y,  orange: o");
        System.out.println("----------------------");
        String colorSelected = whichColor.nextLine();
        System.out.println("You have selected the color" + ": " + colorSelected);
        return colorSelected;
    }

    public int pickAmount(){
        Scanner howManyMarkers= new Scanner(System.in);
        System.out.println("User: Select how many markers you want to get rid of");
        System.out.println("----------------------");
        Integer numTakeout = howManyMarkers.nextInt();
        System.out.println("you have decided to remove:" + numTakeout);
        return numTakeout;
    }

    // remove elements from the list









}
