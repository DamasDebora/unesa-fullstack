/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

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
    public static void main(String[] args) {
       IndividualPersonRepo individualRepo = new IndividualPersonRepo();
       individualRepo.insert(new IndividualPerson("23123", 76, 222, "Julia"));
       individualRepo.insert(new IndividualPerson("0000", 7, 2, "wwrwefsdf"));

        for (int i = 0; i < individualRepo.getAll().size(); i++) {
            System.out.println("name - " + individualRepo.getAll().get(i).getName());
            System.out.println("cpf - " + individualRepo.getAll().get(i).getCpf());
            System.out.println("id - " + individualRepo.getAll().get(i).getId());
            System.out.println("");

        }
    }
    
}
