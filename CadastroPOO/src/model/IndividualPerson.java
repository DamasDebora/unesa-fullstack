/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;
/**
 *
 * @author debora
 */
public class IndividualPerson extends Person implements Serializable{
    private String cpf;
    private int age;

    public IndividualPerson(int id,String name ,String cpf,int age ) {
        super(id, name);
        this.cpf = cpf;
        this.age = age;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.print("cpf- " + cpf + " age- " + age);
    }
}