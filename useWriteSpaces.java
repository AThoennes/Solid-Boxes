import java.util.Scanner;
public class useWriteSpaces {
   final static char SEEN = '*';
   public static void main(String[] args) {    
      Scanner keyboard = new Scanner(System.in);
      int size;
      System.out.print("Enter size:");
      size = keyboard.nextInt();
      
      drawBoundary(size);
   }
   
   public static void writeSpaces(int number) {
      for(int i=0; i<number; i++) {
         System.out.print(" ");
      }
   }
   
   public static void drawBoundary(int size) {
      for(int i=0; i<size; i++) {
         System.out.print(SEEN);
         writeSpaces(size-2);
         System.out.print(SEEN);
         System.out.println();
      }
   }
}
