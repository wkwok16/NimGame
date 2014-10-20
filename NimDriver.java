////////////////////////////////
//                            //
//           Nim Game         //
//       by William Kwok      //
//         Kiang 11:30        //
//                            //
////////////////////////////////
// I have no idea what the actual algorithm to create a perfect winning computer is, but I seem to have deduced
// a computer that will win by checking the remainder of values. My thought process is that 5 you need to take 1 to win. 
// 6, you need to take 2 to win, etc.
import java.util.Scanner;

public class NimDriver
{
  public static void main(String[] args)// 
  {
    Scanner in = new Scanner(System.in); // Creates new scanner
    boolean win = false; // Creates win boolean
    boolean playerturn = true; // Creates player turn boolean to check if it's the player's turn or the computer's
    int playerFirst = 0; // Creates integer to have it check which player will go first
    int playerWinner = 0; // Creates integer to check winner of game
    int pieces; // Create integer to check pieces
    int playermove = 0; // Integer to remember what the player's last move was
    int computerPlay = 0; // Integer to remember the computer's last move
    int totalTurn = 0; // Turn number
    System.out.println("How much pieces do you want to start with? Note, you, the player, will be going first. The computer will be going second!"); 
    int startnum = in.nextInt(); // Starting pieces amount
    System.out.println("Who do you want to go first? [1]. Computer/[2]. Human");
    playerFirst = in.nextInt(); // Which player goes first
    while((playerFirst < 1) || (playerFirst > 2)) 
    {
      playerFirst = in.nextInt();
    }
    NimComputer computer = new NimComputer(); // Create new computer player
    pieces = startnum; // sets pieces to the start number
    
    if(playerFirst == 1) // initializes game to check which player is first
    {
      playerturn = false;
    }
    else if(playerFirst == 2)
    {
      playerturn = true;
    }
    
    while(!win) // While game has not been won...
    {
      while(playerturn) // While the player's turn is true
      {
        if(totalTurn == 0) // If turns is = 0.
        {
          System.out.println("Welcome to the game!");
        }
        else if(totalTurn > 0) // If turns is greater than 0
        {
          if(computerPlay == 1) // Depending on what the computer plays, "pieces" will be plural or singular.
          {
            System.out.println("The computer took " + computerPlay + " piece. There are now " + pieces + " pieces remaining.");
          }
          else if(computerPlay == 2)
          {
            System.out.println("The computer took " + computerPlay + " pieces. There are now " + pieces + " pieces remaining.");
          }
        }
        System.out.println("Enter your move: ");
        playermove = in.nextInt(); // Player enter's move.
        while((playermove < 1) || (playermove > 2))
        {
          playermove = in.nextInt();
        }
        if(pieces == 2 && playermove == 2) // if the player has clearly won...
        {
          System.out.println("The player took " + computerPlay + " pieces, and there is now only 1 piece remaining!"); 
          win = true; //set win to true
          playerWinner = 2;
        }
        pieces -= playermove; // Total amount of pieces is subtracted from player's last move.
        if(!win && pieces <= 1)
        {
          win = true; // Backup win statement
          playerWinner = 1;
        }
        totalTurn++; // Set turn amount up
        playerturn = false; //Switches to false so computer can go
      }
      while(!playerturn) // Basically the same as the human player's code.
      {
        if(totalTurn == 0)
        {
          System.out.println("Welcome to the game!");
        }
        else if(totalTurn > 0)
        {
          if(playermove == 1)
          {
            System.out.println("The player took " + playermove + " piece. There are now " + pieces + " pieces remaining.");
          }
          if(playermove == 2)
          {
            System.out.println("The player took " + playermove + " pieces. There are now " + pieces + " pieces remaining.");
          }
        }
        computerPlay = computer.play(pieces);
        pieces -= computerPlay;
        if(!win && pieces <= 1)
        {
          if(computerPlay == 1)
          {
            System.out.println("The computer took " + computerPlay + " piece, and there is now only 1 piece remaining!");
          }
          else if(computerPlay == 2)
          {
            System.out.println("The computer took " + computerPlay + " pieces, and there is now only 1 piece remaining!");
          }
          win = true;
          playerWinner = 2;
        }
        totalTurn++;
        playerturn = true;
      }
    }
    while(win)
    {
      if(playerWinner == 2) // Checks who the winner was
      {
        System.out.println("Sorry, better luck next time! You lose.");
      }
      else if(playerWinner == 1)
      {
        System.out.println("The computer loses.");
      }
      win = false; // Ends loop
    }
    in.close();
  }
}