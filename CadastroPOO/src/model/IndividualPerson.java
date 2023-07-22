/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author debora
 */
public class IndividualPerson extends Person{
    private String nin;
    private int age;

    public IndividualPerson(String nin, int age,int id, String name) {
        super(id, name);
        this.nin = nin;
        this.age = age;
    }
    
    public String getNin(){
        return nin;
    }
    
    public void setNin(String nin) {
        this.nin = nin;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    @Override
    public void show() {
        System.out.print("as");
    }
}