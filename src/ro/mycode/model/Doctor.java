package ro.mycode.model;

public class Doctor extends Person{
    private String specialization;
    private String mail;
    private String passwors;

    public Doctor( String specialization, String mail, String passwors) {

        this.specialization = specialization;
        this.mail = mail;
        this.passwors = passwors;
    }

    public Doctor(String type,int id, String lastName, String firstName, int age,  String specialization, String mail, String passwors) {
        super(type,id, lastName, firstName, age);
        this.specialization = specialization;
        this.mail = mail;
        this.passwors = passwors;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswors() {
        return passwors;
    }

    public void setPasswors(String passwors) {
        this.passwors = passwors;
    }

    @Override
    public String toString(){
        String text="";
        text+="Doctorul are urmatoarele caracteristici:"+"\n";
        text+="id: "+super.getId()+"\n";
        text+="firstName and lastName: "+super.getFirstName()+" "+super.getLastName()+"\n";
        text+="age: "+super.getAge()+"\n";
        text+="specializare: "+this.specialization+"\n";
        text+="mail: "+this.mail;

        return text;
    }

    public Doctor(String prop){
        String [] split=prop.split(",");
        this.specialization=split[5];
        this.mail=split[6];
        this.passwors=split[7];

    }

    @Override

    public String toSave(){
        return super.toSave()+","+specialization+","+mail+","+passwors;
    }
}
