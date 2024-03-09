package player;

import java.util.Scanner;

public class Player {
    private String name;
    private String phno;
    private int age;
    private String city;
    private String mailID;
    private char symbol;
        
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
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

    private void filldetails() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = scn.nextLine();
        System.out.print("Enter mobile number: ");
        this.phno = scn.nextLine();
        System.out.print("Enter your age: ");
        this.age = scn.nextInt();
        while(this.age<1){
            System.out.print("Enter appropriate age: ");
            this.age = scn.nextInt();
        }
        scn.nextLine();
        System.out.print("Enter your city: ");
        this.city = scn.nextLine();
        System.out.print("Enter your mail ID: ");
        this.mailID = scn.nextLine();
        System.out.print("Choose a character: ");
        this.symbol = scn.nextLine().charAt(0);
    }

    public Player(String n,String p,int a,String c,String m,char ch){
        this.name = n;
        this.phno = p;
        this.age = a;
        this.city = c;
        this.mailID = m;
        this.symbol = ch;

    }

    public Player(){
        filldetails();
    }
    
}