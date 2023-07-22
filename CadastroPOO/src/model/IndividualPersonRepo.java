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
    
    public void update(IndividualPerson individual){  
        for(IndividualPerson i : individualList){
            if(individual.getId() == i.getId()){
                i.setName(individual.getName());
                i.setCpf(individual.getCpf());
                i.setAge(individual.getAge());
                break;
            }
        }
    }
    
    public void delete(int id){
        for(int i = 0; i < individualList.size(); i += 1){
            if(individualList.get(i).getId() == id){
                individualList.remove(i);
                break;
            }
        }
    }
    
    public IndividualPerson getId(int id){
        for(IndividualPerson i : individualList){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }
    
    public ArrayList<IndividualPerson> getAll(){
        return individualList;
    }
    
    public void persist(String file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(individualList);
        out.close();
    }
    
     public void retrieve(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        individualList = (ArrayList<IndividualPerson>) in.readObject();
        in.close();
    }
}
