import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 1. FIND OUT ???????????????????????????
public class Main {
    public static void printMarker(ArrayList<String> greens, ArrayList<String> yellows, ArrayList<String> oranges){
        System.out.print(greens);
        System.out.print(yellows);
        System.out.println(oranges);
    }
    public static void Setup(ArrayList<String> greens, ArrayList<String> yellows, ArrayList<String> oranges){
        // 3 green markers, 7 yellow markers, and 5orange markers
        greens = new ArrayList<>(Arrays.asList("g","g","g"));
        yellows = new ArrayList<>(Arrays.asList("y","y","y","y","y","y","y"));
        oranges = new ArrayList<>(Arrays.asList("o","o","o","o","o"));
    }
    // removes markers from a list
    public static void removeMarker(ArrayList<String> markers, Integer takeout, String markerColor){
        // if the number of markers you want to take out is valid, take out as many as you want
        if(takeout <= markers.size()){

            while(takeout > 0) {
                markers.remove(markerColor);
                takeout--;


            }}
        else{
            System.out.println("not a valid number");
        }
        // print your new marker list
        System.out.println(markers);


    }
    public static void main(String[] args) {
        //initialize your markers
//        ArrayList<String> greens = new ArrayList<>();
//        ArrayList<String> yellows = new ArrayList<>();
//        ArrayList<String> oranges = new ArrayList<>();
        ArrayList<String> greens = new ArrayList<>(Arrays.asList("g","g","g"));
        ArrayList<String> yellows = new ArrayList<>(Arrays.asList("y","y","y","y","y","y","y"));
        ArrayList<String> oranges = new ArrayList<>(Arrays.asList("o","o","o","o","o"));

//         Setup( greens, yellows, oranges);
         printMarker( greens, yellows, oranges);

        ///////////// USER LOGIC
        // pick a color and a number to remove
        Scanner whichColor = new Scanner(System.in);
        System.out.println("User: Which color to remove? ");
        System.out.println("green: g, yellow: y, orange: o");
        String colorSelected = whichColor.nextLine();
        System.out.println( "you selected" + " " +colorSelected);
        System.out.println("select how many markers you want to get rid of");

        Integer numTakeout = whichColor.nextInt();
        System.out.println("you picked:"+ numTakeout);
        switch(colorSelected){
            case "g":
                removeMarker(greens,numTakeout,colorSelected);
                break;
            case "y":
                removeMarker(yellows,numTakeout,colorSelected);
                break;
            case "o":
                removeMarker(oranges,numTakeout,colorSelected);
                break;
        }






/* 2 and 3
- subtasks

		-
	- CPU
		- randomly pick color
		- randomly pick num of markers to take out
	- after each turn
		- check to see if there is only one color remaining ( if 2 arrays are empty)

4
subtasks
* */


    }
}
// Author: Caleb Talley

/* CreateMarkers
* returns 3 arrays of markers
*
* */


//



