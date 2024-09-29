/*
@file: parser.java
@description: This class has the methods used to parse data from my data set, as well as add it into
my BST, it also has the filewriter method that outputs the data to our results file.
@author: Michael Iaccarino
@date: September 26, 2024
 */



import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Parser {

    //Create a BST tree of Integer type
    private BST<Integer> mybst = new BST<>();
    private BST.BSTIterator iterator;
    //construct player
    String[] stats;
    BST playerBst = new BST<>();



    //this runs our process
    public Parser(String filename) throws IOException {
        process(new File(filename));
    }

    // The process scans each line, creating an array of all the data on that line
    // With that array we check to see if it has the proper length and if it does
    // we input it to the operate method having it inserted into the tree
    public void process(File input) throws IOException {
        Scanner scanner = new Scanner(input);
        String[] playerStats;

        while (scanner.hasNextLine()){
            String newLine = scanner.nextLine();

            if (newLine.isEmpty()){
                continue;
            }

            playerStats = newLine.split(",");

            //remove players that do not have all the stats filled out
            if (playerStats.length != 14){
                //System.out.println(playerStats.length);
            }
            //removes the first line
            else if (playerStats[0].equals("overall_pick")){

            }
            else{

                //calling the method
                //this will fill the tree
                operate_BST(playerStats);

            }

        /* Printing for a sanity check on what is in playerstat list

        for (int i = 0; i < playerStats.length - 1; i++){
            System.out.println(playerStats[i]);
        }
            System.out.println("--------");

        */

        }
        //prints to file once BST is done filling with operate command
        writeToFile(playerBst.print(), "./result.txt");


    }

    // operate_BST is going to create a player, and using the data sent into the function through our array
    //operate is going to fill the player properly, once the player class is set we then insert it to the tree
    public void operate_BST(String[] stats) throws IOException {
        //in operate BST I am filling the BST with my players
        //skip 5 because in data that is a blank space
        player wnba = new player(Integer.parseInt(stats[0]),Integer.parseInt(stats[1]),stats[2],stats[3],stats[4],Integer.parseInt(stats[6]),Integer.parseInt(stats[7]),Double.parseDouble(stats[8]),Double.parseDouble(stats[9]),Double.parseDouble(stats[10]),Double.parseDouble(stats[11]),Double.parseDouble(stats[12]),Double.parseDouble(stats[13]));
        //System.out.println(wnba);
        playerBst.insert(wnba);

    }

    // Implement the writeToFile method
    // Generate the result file
    public void writeToFile(String content, String filePath) throws IOException {
        FileWriter file  = new FileWriter(filePath, true);
        file.write(content + System.lineSeparator());
        file.close();
    }
}

