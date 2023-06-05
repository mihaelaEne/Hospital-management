package ro.mycode.model;

public class Person {

    private String type;
    private int id;
    private String lastName;
    private String firstName;
    private int age;

public Person (){}
    public Person(String type,int id, String lastName, String firstName, int age) {
    this.type=type;
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

@Override
    public String toString() {
        String text="";
        text+="The characteristics of the selected person:"+"\n";
        text+="id: "+this.id+"\n";
        text+="firstName and lastName: "+this.firstName+" "+this.lastName+"\n";
        text+="age: "+this.age;
        return text;
    }

    public Person (String prop){
    String [] split=prop.split(",");
    this.type=split[0];
    this.id=Integer.parseInt(split[1]);
    this.lastName=split[2];
    this.firstName=split[3];
    this.age=Integer.parseInt(split[4]);
    }

    public String toSave(){
    return type+","+id+","+lastName+","+firstName+","+age;
    }
}
