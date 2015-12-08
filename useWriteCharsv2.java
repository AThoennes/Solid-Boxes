import java.util.Scanner;
public class useWriteCharsV2 {
   final static char SEEN = '*';
   public static void main(String[] args) {    
      Scanner keyboard = new Scanner(System.in);
      int size;
      System.out.print("Enter size:");
      size = keyboard.nextInt();
      
      drawBoundary(size);
   }
   
   public static void writeChars(char ch, int number) {
      for(int i=0; i<number; i++) {
         System.out.print(ch);
      }
   }
   
   public static void writeSpaces(int number) {
      writeChars(' ',number);
   }
   
   public static int interiorSize(int size) {
    return (size-2);
   }
   
   public static void drawBoundary(int size) {
      writeChars(SEEN,size);  
      System.out.println();
      for(int i=0; i<interiorSize(size); i++) {
         System.out.print(SEEN);
         writeSpaces(size-2);
         System.out.print(SEEN);
         System.out.println();
      }
      writeChars(SEEN,size);  System.out.println();
   }
}
