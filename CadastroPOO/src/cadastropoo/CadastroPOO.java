/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.*;
import model.IndividualPerson;
import model.IndividualPersonRepo;
import model.LegalPerson;
import model.LegalPersonRepo;
/**
 *
 * @author debora
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String individualListFile = "individualList.dat";
        String legalListFile = "legalList.dat";

       IndividualPersonRepo individualRepo1 = new IndividualPersonRepo();
       IndividualPerson person1 = new IndividualPerson("dsfs",1 , 2,"223423423" );
       IndividualPerson person2 = new IndividualPerson("fghfghhf",1, 2 ,"223423423" );

        individualRepo1.insert(person1);
        individualRepo1.insert(person2);
        
        try {
            individualRepo1.persist(individualListFile);
            
            IndividualPersonRepo individualRepo2 = new IndividualPersonRepo();
            individualRepo2.recover(individualListFile);
            
            System.out.println("Individual person: ");
            for(IndividualPerson p : individualRepo2.getAll()){
                p.show();
                System.out.println(" ");

            }
            
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }
    
}
