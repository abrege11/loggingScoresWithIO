/*
Abe Brege
Lab D
3/21/23
*/
package leagueScores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GetScoring {

    public static void main(String[] args) {
                int scores[][] = new int[10][3]; //initializing the main array
        int teamNum = 0;
        int matchNum = 0;
        int teamScoreNum = 0;
        boolean validNum = false;
        boolean validMatch = false;
        boolean validScore = false;
        String nextEntry = "y";
        int maxTotal = 0;
        int maxTeam = 0;
        
        System.out.println("Welcome to the robotics league scoring table!"); //welcome message

        //below i am initializing the reader to read the TeamScores.txt file
        try(BufferedReader read = new BufferedReader(new FileReader("TeamScores.txt"))){
            String line; //variable to split each line
            int row = 0; //row counter for the loop
            
            while((line = read.readLine()) != null && row < 10){
                String[] place = line.split(","); //split when it sees a ,
                scores[row][0] = Integer.parseInt(place[0]); //uses row and a manually entered value to represent the column to add the number at that split
                scores[row][1] = Integer.parseInt(place[1]); //adds the second number into the correct row
                scores[row][2] = Integer.parseInt(place[2]); //adds the third number into the correct row
                row++; //increase the row # for the next loop
            }    
        }catch(IOException e){
            e.printStackTrace();        
        }
        
                           
        
while(!nextEntry.equalsIgnoreCase("n")){

            Scanner sc; //setting up scanner
            sc = new Scanner(System.in);
            String input;

    System.out.println();        
        
        
            
  
            //GETTING TEAM
            
            do{ 
                System.out.print("Enter the team # (1-10): "); //getting team
                try{
                    input = sc.nextLine();
                    teamNum = Integer.parseInt(input);
                    if(teamNum >=1 && teamNum <= 10){ //checking range
                        validNum = true; //stopping loop
                    }else{
                        System.out.println("The team # you entered was incorrect\tPlease enter a number between 1 & 10.");
                        validNum = false; //continuing loop
                    }
                }
                catch(NumberFormatException e){
                    System.out.println("Error! Not a valid number. Please try again. \n");
                }
            }   while(!validNum);
            //teamNum holds data needed
            
            
            
            //GETTING MATCH
            
            do{ 
                System.out.print("Enter the match # (1-3): "); //getting match
                try{
                    input = sc.nextLine();
                    matchNum = Integer.parseInt(input);
                    if(matchNum >=1 && matchNum <= 3){ //checking range
                        validMatch = true; //stopping loop
                    }else{
                        System.out.println("The match # you entered was incorrect\tPlease enter a number between 1 & 3.");
                        validMatch = false; //continuing loop
                    }
                }
                catch(NumberFormatException e){
                    System.out.println("Error! Not a valid number. Please try again. \n");
                }
            }   while(!validMatch);
            //matchNum holds data needed
            
            
            //GETTING SCORE
            
            do{ 
                System.out.print("Enter the score of the match (1-100): "); //getting score
                try{
                    input = sc.nextLine();
                    teamScoreNum = Integer.parseInt(input);
                    if(teamScoreNum >=1 && teamScoreNum <= 100){ //checking range
                        validScore = true; //stopping loop
                    }else{
                        System.out.println("The match score you entered was incorrect\tPlease enter a number between 1 & 100.");
                        validScore = false; //continuing loop
                    }
                }
                catch(NumberFormatException e){
                    System.out.println("Error! Not a valid number. Please try again. \n");
                }
            }   while(!validScore);
            //teamScoreNum holds data needed
            
            scores[teamNum -1][matchNum -1] = teamScoreNum;
        
            System.out.print("Would you like to make another entry? (y/n): ");//seeing if they want to make another entry
            input = sc.nextLine();
            nextEntry = input;//if they say y, they will restart, if they say n, the code end
    }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("TeamScores.txt"))) {
            for (int i = 0; i < scores.length; i++) {
                for (int j = 0; j < scores[i].length; j++) {
                    writer.write(scores[i][j] + ",");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        System.out.println("LEAGUE SCORES \n"); //printing out title
        System.out.printf("%-5s%-8s%-8s%-8s%-8s\n", "Team", "Match 1", "Match 2", "Match 3", "Total"); //using print f to format the strings and ints of the statement that are listed to the right of the format rules
            for (int i = 0; i < scores.length; i++) {//iterating over rows to print to console
                int total = 0; //initializing the total variable to add to the end
                System.out.printf("%-5d", i + 1); //printing out each team number
                    for (int j = 0; j < scores[i].length; j++) {//iterating over each column to print to console
                        total += scores[i][j]; //getting the final total for the last row
                        System.out.printf("%-8d", scores[i][j]);
                    }
                System.out.printf("%-8d\n", total); //printing out total for the row
                }

        //the code below finds the team with the highest total
            for (int i = 0; i < scores.length; i++) { //iterates through list
                int total = 0;
                    for (int j = 0; j < scores[i].length; j++) {//iterates through list and adds up each teams max total to see which one is the highest
                        total += scores[i][j]; 
                    }
                        if (total > maxTotal) { //checks if the current team is higher than the current highest total, if so, variables are replaced with respective teams and amounts
                            maxTotal = total;
                            maxTeam = i + 1;
                        }
            }
System.out.printf("\nThe leader so far is Team %d with a total score of %d.\n", maxTeam, maxTotal);

            }        
        
 
    }
    
    

