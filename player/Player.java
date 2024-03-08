package player;

import java.util.Scanner;

public class Player {
    String name;
    String phno;
    int age;
    String city;
    String mailID;
        
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getMailID() {
        return mailID;
    }
    public void setMailID(String mailID) {
        this.mailID = mailID;
    }

    private void filldetails(){

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = scn.nextLine();
    }

    public Player(String n,String p,int a,String c,String m){
        this.name = n;
        this.phno = p;
        this.age = a;
        this.city = c;
        this.mailID = m;

    }

    public Player(){
        filldetails();
    }
    
}
