/* Java class that has methods for "drawing" three different kinds of solid
** boxes: rectangular, convex, and concave.  Each method receives parameters 
** specifying the half-height and narrowest-width of the box to be drawn,
** plus a parameter indicating which character to use when drawing.
**
** For each of the three varieties of boxes, there is also a "functional"
** method that returns the area occupied by a box of that variety, given
** its half-height and narrowest-width via parameters.
**
** To illustrate, here are examples (each using a dollar sign ($)) of 
** boxes of half-height 4 and narrowest-width 3:
**
**     $$$            $$$           $$$$$$$$$
**     $$$           $$$$$           $$$$$$$
**     $$$          $$$$$$$           $$$$$
**     $$$         $$$$$$$$$           $$$
**     $$$         $$$$$$$$$           $$$
**     $$$          $$$$$$$           $$$$$
**     $$$           $$$$$           $$$$$$$
**     $$$            $$$           $$$$$$$$$
**
** Notice that each kind of box is such that you get its bottom half by
** flipping its top half upside down (and vice versa, of course).
** The "half-height" of a box is the number of rows used in drawing 
** one of its halves. 
** The "narrowest-width" of a box is the minimum number of non-space 
** characters appearing in any of its rows.
** The area of a box is the number of non-space characters used in
** drawing it.  The areas of the boxes above are 24, 48, and 48,
** respectively.
**
** Author: R. McCloskey
** By: Alex Thoennes
** October 6, 2015
*/
public class SolidBoxes 
{	
	private static final char SPACE = ' ';

   /* Draws a rectangular box of the specified half-height and 
   ** narrowest-width using the specified character.
   */
   public static void drawRectangularBox(int halfHeight, int narrowestWidth, char ch) 
   {
	   //first you get the full height
	   int fullHeight = halfHeight + halfHeight;
	   
	   /*Then you draw the value of ch for however big the narrowestWidth is 
	   **and then skip to the next line and continue until i is no longer less 
	   *than the full height of the figure
	   */
	   for (int i = 0; i < fullHeight; i++)
	   {
		   writeChars(ch, narrowestWidth);
		   System.out.println();
	   }
   }

   /** Returns the area of a rectangular box having the specified
   **  half-height and narrowest-width.
   */
   public static int areaOfRectangularBox(int halfHeight, int narrowestWidth) 
   {
	  int fullHeight = halfHeight + halfHeight;
	   
	  // area of any rectangle is length * width
	  int rectangleArea = fullHeight * narrowestWidth;
      return rectangleArea;
   }

   /* Draws a convex box of the specified half-height and narrowest-width
   ** using the specified character.
   */
   public static void drawConvexBox(int halfHeight, int narrowestWidth, char ch) 
   {
	   
	   drawUpwardsTriangle(halfHeight, narrowestWidth, ch);
	   drawDownwardsTriangle(halfHeight, narrowestWidth, ch);
   }

   /** Returns the area of a convex box having the specified
   **  half-height and narrowest-width.
   */
   public static int areaOfConvexBox(int halfHeight, int narrowestWidth) 
   {
	   return areaOfConvexOrConcave(halfHeight, narrowestWidth);
   }

   /* Draws a concave box of the specified half-height and narrowest-width
   ** using the specified character.
   */
   public static void drawConcaveBox(int halfHeight, int narrowestWidth, char ch) 
   {
	   drawDownwardsTriangle(halfHeight, narrowestWidth, ch);
	   drawUpwardsTriangle(halfHeight, narrowestWidth, ch);
   }

   /** Returns the area of a concave box having the specified
   **  half-height and narrowest-width.
   */
   public static int areaOfConcaveBox(int halfHeight, int narrowestWidth) 
   {
	   return areaOfConvexOrConcave(halfHeight, narrowestWidth);
   }
   
   /*
    * This method prints out whatever value ch holds
    */
   private static void writeChars(char ch, int number) {
	      for(int i=0; i<number; i++) {
	         System.out.print(ch);
	      }
	   }
   
   /*
    * This method prints spaces to format the boxes
    */
   private static void writeSpaces(int number) {
	      for(int i=0; i<number; i++) {
	         System.out.print(SPACE);
	      }
   }
   
   /*
    * This methods prints a triangle 
    * that has its point pointing north
    */
   private static void drawUpwardsTriangle(int halfHeight, int narrowestWidth, char ch)
   {
	   int numberOfSpaces = halfHeight;
	   
	   for (int i = 0; i < halfHeight; i++)
	   {
		   writeSpaces(numberOfSpaces);
		   numberOfSpaces--;
		   
		
		writeChars(ch, narrowestWidth + (i * 2));
		   
		   System.out.println();
	   }
   }
   
   /*
    * The following method prints a triangle that
    * has its point facing south
    */
   private static void drawDownwardsTriangle(int halfHeight, int narrowestWidth, char ch)
   {
	   int numberOfSpaces = 1;
	   
	   for (int j = halfHeight-1; j >= 0; j--)
	   {
		   //no spaces when you reach longest line
		   writeSpaces(numberOfSpaces);
		   numberOfSpaces++;
		   
		writeChars(ch, narrowestWidth + (j * 2));
		   System.out.println();
	   }
   }
   
   /*
    * The area of the convex and concave are the same
    * so this can be donw in one method
    */
   private static int areaOfConvexOrConcave(int halfHeight, int narrowestWidth)
   {
	   int area = 0;

		for (int i = 0; i < halfHeight; i++)
		{
			area += narrowestWidth + (i * 2);
		}
		return area*2;
   }

}
