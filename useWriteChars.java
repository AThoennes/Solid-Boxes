import java.util.Scanner;
public class useWriteChars {
   final static char SEEN = '*';
   public static void main(String[] args) {    
      Scanner keyboard = new Scanner(System.in);
      int grisGrop;
      System.out.print("Enter size:");
      grisGrop = keyboard.nextInt();
      
      drawBoundary(grisGrop);
   }
   
   public static void writeChars(char ch, int number) {
      for(int i=0; i<number; i++) {
         System.out.print(ch);
      }
   }
   
   public static void writeSpaces(int number) {
      writeChars(' ',number);
   }
   
   public static void drawBoundary(int size) {
      writeChars(SEEN,size);  System.out.println();
      for(int i=0; i<(size-2); i++) {
         System.out.print(SEEN);
         writeSpaces(size-2);
         System.out.print(SEEN);
         System.out.println();
      }
      writeChars(SEEN,size);  System.out.println();
   }
}
