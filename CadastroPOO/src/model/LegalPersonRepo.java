/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author debora
 */
public class LegalPersonRepo {
   private ArrayList<LegalPerson> legalList = new ArrayList<>();
       
    public void insert(LegalPerson legal){
        legalList.add(legal);
    }
    
    public void update(LegalPerson legal){ 
        for(LegalPerson l : legalList){
            if(legal.getId() == l.getId()){
                l.setName(legal.getName());
                l.setCnpj(legal.getCnpj());
                break;
            }
        }
    }
    
    public void delete(int id){
        for(int i =0; i < legalList.size(); i += 1){
            if(legalList.get(i).getId() == id){
                legalList.remove(i);
            }
        }
    }
    
    public LegalPerson getId(int id){
        for( LegalPerson legal : legalList) {
            if(legal.getId() == id){
                return legal;
            }
        }
        return null;
    }
    
    public ArrayList<LegalPerson> getAll(){
        return legalList;
    }
    
    public void persist(String file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(legalList);
        out.close();
    }

    public void retrieve(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        legalList = (ArrayList<LegalPerson>) in.readObject();
        in.close();
    }
}
