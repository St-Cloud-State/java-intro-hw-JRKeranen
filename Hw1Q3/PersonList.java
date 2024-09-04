import java.util.LinkedList;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.cert.TrustAnchor;
import java.util.Scanner;


public class PersonList {
    private LinkedList<Person> list = new LinkedList();
    private File inputFile = null;
    private File outputFile = null;
    private Scanner Reader = null;
    private FileWriter writeFile = null;

    public PersonList (String inPath, String outPath) {
        try {
            this.inputFile = new File(inPath);
            this.outputFile = new File(outPath);
            this.Reader = new Scanner(this.inputFile);
            this.writeFile = new FileWriter(this.outputFile);
        } catch (Exception e) {
           System.out.println(e);
        }
        
    }
    public Boolean store() {
        try {
          while (this.Reader.hasNextLine()) {
            String tempLine = this.Reader.nextLine();
            String[] dataArr = tempLine.split(" ");
            Person tempPerson = new Person(dataArr[1], dataArr[2], dataArr[0]);
            this.list.addLast(tempPerson);
          }
          this.Reader.close();
        
        return true;
      } catch (Exception e) {
        System.out.println(e);
        return false;
      }
    }
    
      // loops through linked list and outputs each value to the Print Stream
      public void display(){
        try {
          for (Person x : this.list) {
            this.writeFile.write(x.toString()+"\n");
            System.out.println(x.toString());
          }
          this.writeFile.close();
      }
      catch (Exception e) {
        System.out.println(e);
      }
      } 
    

      public int find(String sid) {
        int index = 0;
        for (Person x : this.list) {
          if (x.GetID().equals(sid)) {
            return index;
          }
        index = index + 1;
        } 
        return -1;
      }
}   