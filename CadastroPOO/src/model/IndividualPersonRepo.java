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
public class IndividualPersonRepo {
    private final ArrayList<IndividualPerson> individualList = new ArrayList<IndividualPerson>();
    
    public void insert(){
    }
    
    public void change(){   
    }
    
    public void delete(){
    }
    
    public void get(int id){
        individualList.get(id);
    }
    
    public void getAll(){
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
