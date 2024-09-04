public class Person {
    String firstName, lastName ,id;

  public Person(String first_name, String last_name, String ID) {
    this.firstName = first_name;
    this.lastName = last_name;
    this.id = ID;
  }

  public String toString(){//overriding the toString() method  
    return id+" "+firstName+" "+lastName;  
   }  

  public String GetFirstName() {
    return firstName;
  }
  public String GetLastName() {
    return lastName;
  }
  public String GetID() {
    return id;
  }
  public void SetFirstName(String first_name) {
    firstName = first_name;
  }
  public void SetLastName(String last_name) {
    lastName = last_name;
  }
  public void SetID(String ID) {
    id = ID;
  }
}