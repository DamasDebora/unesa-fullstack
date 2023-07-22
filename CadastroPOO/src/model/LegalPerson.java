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
public class LegalPerson extends Person implements Serializable{
    private String cnpj;
    
    public LegalPerson(String cnpj, int id, String name){
        super(id, name);
        this.cnpj = cnpj;
    }
    
    public String getCnpj(){
        return cnpj;
    }
    
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    
    @Override 
    public void show(){
        System.out.print(cnpj);
    }
}
