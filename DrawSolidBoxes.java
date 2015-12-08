import java.util.Scanner;

/* Java application having as its purpose to exercise the methods of the
** SolidBoxes class.  
**
** This program repeatedly prompts the user to enter the half-height, 
** narrowest-with and rendering character until the user enters a 
** non-positive value for either the half-height or narrowest-width.
**
** Authosr: R. McCloskey and P.M.J.
*/

public class DrawSolidBoxes {

   private static Scanner keyboard = new Scanner(System.in);

   public static void main(String[] args) {
   
      int hh = getIntFromUser("Enter half-height (0 or less to terminate):");
      int nw = getIntFromUser("Enter narrowest-width (0 or less to terminate):");
      char c = getCharFromUser("Enter rendering char:");
   
      // Keep iterating as long as user enters positive values.
      while (hh > 0  &&  nw > 0) {
      
         SolidBoxes.drawRectangularBox(hh, nw, c);
         System.out.println("Area = " + SolidBoxes.areaOfRectangularBox(hh, nw));
      
         System.out.print("\n\n");  // skip down two lines
      
         SolidBoxes.drawConvexBox(hh, nw, c);
         System.out.println("Area = " + SolidBoxes.areaOfConvexBox(hh, nw));
      
         System.out.print("\n\n");  // skip down two lines
      
         SolidBoxes.drawConcaveBox(hh, nw, c);
         System.out.println("Area = " + SolidBoxes.areaOfConcaveBox(hh, nw));
      
         System.out.print("\n\n");  // skip down two lines
      
         hh = getIntFromUser("Enter half-height (0 or less to terminate):");
         nw = getIntFromUser("Enter narrowest-width (0 or less to terminate):");
         c = getCharFromUser("Enter rendering char:");
      }
   }
   

   /* Prints the specified prompt and returns the user's response,
   ** as a value of type int.  (If the user's response cannot be
   ** interpreted as an integer value, an exception is thrown.)
   */
   private static int getIntFromUser(String prompt) {
      System.out.print(prompt);
      return keyboard.nextInt(); 
   }
   
   /* Prints the specified prompt and returns the user's response,
   ** as a value of type char.  (Note that spaces can not be recognized
   ** using this method, and that if the user provides a null response
   ** then '?' is returned.)
   */
   private static char getCharFromUser(String prompt) {
      System.out.print(prompt);
      return (keyboard.next().trim()+"?").charAt(0); 
   }

}
