package ro.mycode.model;

public class Patient extends Person{

    private String medicalProblem;
    private String mail;
    private String password;

    public Patient( String medicalProblem, String mail, String password) {
        this.medicalProblem = medicalProblem;
        this.mail = mail;
        this.password = password;
    }

    public Patient(String type,int id, String lastName, String firstName, int age,String medicalProblem, String mail, String password) {
        super(type,id, lastName, firstName, age);

        this.medicalProblem = medicalProblem;
        this.mail = mail;
        this.password = password;
    }


    public String getMedicalProblem() {
        return medicalProblem;
    }

    public void setMedicalProblem(String medicalProblem) {
        this.medicalProblem = medicalProblem;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        String text="";
        text+="Pacientul are urmatoarele caracteristici:"+"\n";
        text+="id: "+super.getId()+"\n";
        text+="firstName and lastName: "+super.getFirstName()+" "+super.getLastName()+"\n";
        text+="age: "+super.getAge()+"\n";
        text+="medical problem: "+this.medicalProblem+"\n";
        text+="mail: "+this.mail;

        return text;
    }

    public Patient(String prop){
        String [] split=prop.split(",");

        this.medicalProblem=split[5];
        this.mail=split[6];
        this.password=split[7];
    }

    @Override

    public String toSave(){
        return super.toSave()+","+medicalProblem+","+mail+","+password;
    }
}
