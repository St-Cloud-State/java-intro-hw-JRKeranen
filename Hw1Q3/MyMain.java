import java.util.LinkedList;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import javax.annotation.processing.Filer;

public class MyMain {

  public static void main(String[] args) {
    try {
        PersonList Obj1 = new PersonList("/workspaces/java-intro-hw-JRKeranen/People.txt","/workspaces/java-intro-hw-JRKeranen/Output.txt");
        Obj1.store();
        Obj1.display();
        Scanner keyScanner = new Scanner(System.in);
        for (int x = 0; x < 3; x++){
            System.out.println("Please enter the id of person you are searching for: ");
            String id = keyScanner.nextLine();
            int temp = Obj1.find(id);
            if (temp != -1){
              System.out.println("Person found, index is " + temp);
            } else {
              System.out.println("No Person was Found");
            }
          }
        keyScanner.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    finally{
      
    }
    
  }
  // Reads values from input file and adds person into linkedlist, returns linked list.
}