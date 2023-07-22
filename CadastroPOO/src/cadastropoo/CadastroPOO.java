/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import model.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author debora
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       
        IndividualPersonRepo repo1 = new IndividualPersonRepo();
        IndividualPersonRepo repo2 = new IndividualPersonRepo();
        
        LegalPersonRepo repo3 = new LegalPersonRepo();
        LegalPersonRepo repo4 = new LegalPersonRepo();
        
        int option = -1; 
        
        while(option != 0){
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Insert");
            System.out.println("2 - Update");
            System.out.println("3 - Delete");
            System.out.println("4 - Display by ID");
            System.out.println("5 - Display All");
            System.out.println("6 - Save Data");
            System.out.println("7 - Retrieve Data");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");
            
            option = sc.nextInt();
            sc.nextLine();
            
            switch(option){
                case 1:
                    insert(sc, repo1, repo3);
                    break;
                case 2:
                    update(sc, repo1, repo3);
                    break;
                case 3:
                    delete(sc, repo1, repo3);
                    break;
                case 4:
                    displayById(sc, repo1, repo3);
                    break;
                case 5:
                    displayAll(sc, repo1, repo3);
                    break;
                case 6:
                    saveData(sc, repo1, repo3);
                    break;
                case 7:
                    retrieveData(sc, repo2, repo4);
                    break;
                case 0:
                    System.out.println("exting..");
                    break;
                default:
                    System.out.println("Try another option");
            }
        }
        
        sc.close();
        
    }
    
    private static void insert(Scanner sc, IndividualPersonRepo repo1, LegalPersonRepo repo3) {
        System.out.println("\nChoose the type of person:");
        System.out.println("1 - Individual");
        System.out.println("2 - Legal");

        int personType = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter the name:");
        String name = sc.nextLine();

        if (personType == 1) {
            System.out.println("Enter the CPF:");
            String cpf = sc.nextLine();

            System.out.println("Enter the age:");
            int age = sc.nextInt();

            IndividualPerson individual = new IndividualPerson(repo1.getAll().size() + 1, name, cpf, age);
            repo1.insert(individual);
            System.out.println("Individual added successfully!");

        } else if (personType == 2) {
            System.out.println("Enter the CNPJ:");
            String cnpj = sc.nextLine();

            LegalPerson legalPerson = new LegalPerson(repo3.getAll().size() + 1, name, cnpj);
            repo3.insert(legalPerson);
            System.out.println("Legaladded successfully!");
        } else {
            System.out.println("Invalid option!");
        }
    
}

    private static void update(Scanner sc, IndividualPersonRepo repo1, LegalPersonRepo repo3) {
        System.out.println("\nChoose the type of person to update:");
        System.out.println("1 - Individual");
        System.out.println("2 - Legal Entity");
        int personType = sc.nextInt();
        sc.nextLine(); // Clear the buffer

        System.out.println("Enter the ID of the person you want to update:");
        int id = sc.nextInt();

        if (personType == 1) {
            IndividualPerson individual = repo1.getById(id);
            if (individual != null) {
                System.out.println("Current data:");
                individual.display();

                System.out.println("Enter the new name:");
                String name = sc.nextLine();

                System.out.println("Enter the new CPF:");
                String cpf = sc.nextLine();

                System.out.println("Enter the new age:");
                int age = sc.nextInt();

                individual.setName(name);
                individual.setCpf(cpf);
                individual.setAge(age);
                repo1.update(individual);

                System.out.println("Individual updated successfully!");
            } else {
                System.out.println("Individual not found!");
            }
        } else if (personType == 2) {
            LegalPerson legalPerson = repo3.getById(id);
            if (legalPerson != null) {
                System.out.println("Current data:");
                legalPerson.display();

                System.out.println("Enter the new name:");
                String name = sc.nextLine();

                System.out.println("Enter the new CNPJ:");
                String cnpj = sc.nextLine();

                legalPerson.setName(name);
                legalPerson.setCnpj(cnpj);
                repo3.update(legalPerson);

                System.out.println("Legal Entity updated successfully!");
            } else {
                System.out.println("Legal Entity not found!");
            }
        } else {
            System.out.println("Invalid option!");
        }
    }

    private static void delete(Scanner sc, IndividualPersonRepo repo1, LegalPersonRepo repo3) {
        System.out.println("\nChoose the type of person to delete:");
        System.out.println("1 - Individual");
        System.out.println("2 - Legal");
        int personType = sc.nextInt();
        sc.nextLine(); // Clear the buffer

        System.out.println("Enter the ID of the person you want to delete:");
        int id = sc.nextInt();

        if (personType == 1) {
            Individual individual = repo1.getById(id);
            if (individual != null) {
                repo1.delete(id);
                System.out.println("Individual deleted successfully!");
            } else {
                System.out.println("Individual not found!");
            }
        } else if (personType == 2) {
            LegalPerson legalPerson = repo3.getById(id);
            if (legalPerson != null) {
                repo3.delete(id);
                System.out.println("Legal Entity deleted successfully!");
            } else {
                System.out.println("Legal Entity not found!");
            }
        } else {
            System.out.println("Invalid option!");
        }
    }
    
    private static void displayById(Scanner sc, IndividualPersonRepo repo1, LegalPersonRepo repo3) {
        System.out.println("\nChoose the type of person to display by ID:");
        System.out.println("1 - Individual");
        System.out.println("2 - Legal Entity");
        int personType = sc.nextInt();
        sc.nextLine(); // Clear the buffer

        System.out.println("Enter the ID of the person you want to display:");
        int id = sc.nextInt();

        if (personType == 1) {
            IndividualPerson individual = repo1.getById(id);
            if (individual != null) {
                individual.display();
            } else {
                System.out.println("Individual not found!");
            }
        } else if (personType == 2) {
            LegalPerson legalPerson = repo3.getById(id);
            if (legalPerson != null) {
                legalPerson.display();
            } else {
                System.out.println("Legal Entity not found!");
            }
        } else {
            System.out.println("Invalid option!");
        }
    }

    private static void displayAll(Scanner sc, IndividualPersonRepo repo1, LegalPersonRepo repo3) {
        System.out.println("\nChoose the type of person to display all:");
        System.out.println("1 - Individual");
        System.out.println("2 - Legal Entity");
        int personType = sc.nextInt();

        if (personType == 1) {
            System.out.println("\n--- Individuals ---");
            for (IndividualPerson individual : repo1.getAll()) {
                individual.display();
            }
        } else if (personType == 2) {
            System.out.println("\n--- Legal Entities ---");
            for (LegalPerson legalPerson : repo3.getAll()) {
                legalPerson.display();
            }
        } else {
            System.out.println("Invalid option!");
        }
    }

    private static void saveData(Scanner sc, IndividualPersonRepo repo1, LegalPersonRepo repo3) {
        System.out.println("\nEnter the prefix for the files:");
        String prefix = sc.next();

        try {
            repo1.persist(prefix + ".individual.bin");
            repo3.persist(prefix + ".legalEntity.bin");
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error while saving the data: " + e.getMessage());
        }
    }

    private static void retrieveData(Scanner sc, IndividualPersonRepo repo2, LegalPersonRepo repo4) {
        System.out.println("\nEnter the prefix of the files to retrieve data:");
        String prefix = sc.next();

        try {
            repo2.retrieve(prefix + ".individual.bin");
            repo4.retrieve(prefix + ".legalEntity.bin");
            System.out.println("Data retrieved successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while retrieving the data: " + e.getMessage());
        }
    }

}