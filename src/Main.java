import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 1. FIND OUT ???????????????????????????
public class Main {
    // make array of all the different colors
    public static String getRandomColor(){
        String [] colorSelectorRandom = {"g","y","o"}; ////////////// make function for error messages when typing invalid letter
        //select a random color

        Random random = new Random();

        int randomColorIndex = random.nextInt(colorSelectorRandom.length);
        String randomColor = colorSelectorRandom[randomColorIndex];

        return randomColor; ///////////check if color is valid later
    }

    public static int randNumRemove(){
        return 1;
    }

    public static void removeRandomMarker(ArrayList<String> markers, String markerColor){
        // if the number of markers you want to take out is valid, take out as many as you want
        //  all possible min and max you can take out of any array
        int[] bounds = {1,2,3,4,5,6,7};

        boolean isValid = false;
        // randomly get number from this array that fits our requirement
        int takeout = 0;
        while(isValid = false){ // write function that gets the random value?
            Random random = new Random();
            int randomTakeoutIndex = random.nextInt(bounds.length);
            takeout = bounds[randomTakeoutIndex];
            if(takeout <= markers.size() && takeout != 0){
                isValid = true;
            }
        }
        System.out.println("The CPU has decided to take out " + takeout);



//        if(takeout <= markers.size()){

            while(takeout > 0) {
                markers.remove(markerColor);
                takeout--;


            }
        //        else{
//            System.out.println("not a valid number");
//        }
        // print your new marker list
        System.out.println(markers);
    }






    //// Make function that checks for CPU easy win


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
        //////////// CPU basic logic
        String randomColor = getRandomColor(); // g, y, or o
        System.out.println("The CPU has decided to remove a" + randomColor);

        switch(randomColor){
            case "g":
                removeRandomMarker(greens,randomColor);
                break;
            case "y":
                removeRandomMarker(yellows,randomColor);
                break;
            case "o":
                removeRandomMarker(oranges,randomColor);
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



