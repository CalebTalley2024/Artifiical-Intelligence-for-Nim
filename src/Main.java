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
        CPU Cpu = new CPU();
        System.out.println(GameBoard.isWinner(Cpu));


        GameBoard.run();



    }
}




