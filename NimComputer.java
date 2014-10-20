public class NimComputer
{
  public int play(int pieces)
  {
    int returnnumber = 0; // States return number
    if(pieces > 4)
    {
      int returnstatus = (pieces-4)%3; // Creates a status number which the return number can calculate a value to return from
      
      if(returnstatus == 0) // If the remainder of the equation above is 0...
      {
        returnnumber = 2; // The computer will pick 2 pieces
      }
      else if(returnstatus == 1) // etc
      {
        returnnumber = 1;
      }
      else if(returnstatus == 2)
      {
        returnnumber = 2;
      }
    }
    else if(pieces == 4) // Just backup values, since these will always make the computer win.
    {
      returnnumber = 2;
    }
    else if(pieces == 3)
    {
      returnnumber = 2;
    }
    else if(pieces == 2)
    {
      returnnumber = 1;
    }
    return returnnumber; // Returns the pieces the computer will take
  }
}