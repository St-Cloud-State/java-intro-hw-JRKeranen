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
        LinkedList<Person> list = new LinkedList();
        File inputFile = new File("/workspaces/java-intro-hw-JRKeranen/People.txt");
        File outputFile = new File("/workspaces/java-intro-hw-JRKeranen/Output.txt");
        Scanner Reader = new Scanner(inputFile);
        FileWriter writeFile = new FileWriter(outputFile);
        list = store(Reader, list);
        display(System.out, list);
        display(writeFile, list);
        Scanner keyScanner = new Scanner(System.in);
        for (int x = 0; x < 3; x++){
            System.out.println("Please enter the id of person you are searching for: ");
            String id = keyScanner.nextLine();
            int temp = find(id,list);
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
  static LinkedList store(Scanner inStream, LinkedList<Person> list) {
    try {
      while (inStream.hasNextLine()) {
        String tempLine = inStream.nextLine();
        String[] dataArr = tempLine.split(" ");
        Person tempPerson = new Person(dataArr[1], dataArr[2], dataArr[0]);
        list.add(tempPerson);
      }
      inStream.close();
    
    return list;
  } finally {}
}

  // loops through linked list and outputs each value to the Print Stream
  static void display(PrintStream outStream, LinkedList<Person> list){
    try {
      for (Person x : list) {
        outStream.println(x.toString());
      }
  }
  catch (Exception e) {
    System.out.println(e);
  }
  } 

  // interates through linked list and writes each value to a txt file.
  static void display(FileWriter outStream, LinkedList<Person> list){
    try {
      for (Person x : list) {
        outStream.write(x.toString()+"\n");
      }
      outStream.close();

  }
  catch (Exception e) {
    System.out.println(e);
  }
  } 
  static int find(String sid, LinkedList<Person> list) {
    int index = 0;
    for (Person x : list) {
      if (x.GetID().equals(sid)) {
        return index;
      }
    index = index + 1;
    } 
    return -1;
  }
  
}