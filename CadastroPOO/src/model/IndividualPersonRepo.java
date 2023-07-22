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
public class IndividualPersonRepo {
    private ArrayList<IndividualPerson> individualList = new ArrayList<>();
    
    public void insert(IndividualPerson individual){
        individualList.add(individual);
    }
    
    public void change(IndividualPerson individual){  
        for(IndividualPerson i : individualList){
            if(individual.getId() == i.getId()){
                i.setName(individual.getName());
                i.setCpf(individual.getCpf());
                i.setId(individual.getId());
            }
        }
    }
    
    public void delete(int id){
        individualList.remove((id));
    }
    
    public void get(int id){
        individualList.get(id);
    }
    
    public ArrayList<IndividualPerson> getAll(){
        return individualList;
    }
    
    public void persist(String file) throws IOException{
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(individualList);
        }
    }
    
    public void recover(String file) throws Exception{
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            individualList = (ArrayList<IndividualPerson>) in.readObject();
        }
    }
}
