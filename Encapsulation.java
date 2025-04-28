
// A simple example of encapsulation in Java

class User{
    private  String name; //Encapsulating the name and other information of an user
    private String email;
    private  String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { // This is only a read only method so any can't change the name
        return name;
    }
    public void setName(String name) { // A person must call the function to change the name
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

}


public class Encapsulation {
    public static void main(String[] args) {
        User amir = new User("Amir Hamza", "it22046@mbstu.ac.bd", "password123");
//      amir.name = "Fahim"; // This will give an error because name is private or we can say encapsulated
        System.out.println("Name: " + amir.getName()); //we must call the getter method to get the name
    }
}
