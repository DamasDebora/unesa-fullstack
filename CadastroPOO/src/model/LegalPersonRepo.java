/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author debora
 */
public class LegalPersonRepo {
   private final ArrayList<LegalPerson> legalList = new ArrayList<LegalPerson>();
       
    public void insert(LegalPerson legal){
        legalList.add(legal);
    }
    
    public void change(LegalPerson legal){ 
        for(LegalPerson l : legalList){
            if(legal.getId() == l.getId()){
                l.setName(legal.getName());
                l.setCnpj(legal.getCnpj());
                l.setId(legal.getId());
            }
        }
    }
    
    public void delete(int id){
        legalList.remove((id));
    }
    
    public void get(int id){
        legalList.get(id);
    }
    
    public ArrayList<LegalPerson> getAll(){
        return legalList;
    }
    
    public void persist(String file) throws Exception{
        try{

        }
        catch(Exception err){
            throw new Exception("asas");
        }
    }
    
    public void recover(String file) throws Exception{
        try{

        }
        catch(Exception err){
            throw new Exception("asas");
        }
    }
}
