package Utils;

import Models.Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactManager {
    public void executeActivity() {
        Scanner takeInput = new Scanner(System.in);

        boolean exit = false;
        while (!exit){
            System.out.println("Contact App");
            System.out.println("Please select the options below");
            System.out.println("1. Add Contact\n2. Delete Contact\n3. Search Contact\n4. Exit");
            int userChoice = takeInput.nextInt();
            takeInput.nextLine();
            switch (userChoice){
                case 1:
                    System.out.println("Enter name: ");
                    String userName = takeInput.nextLine();
                    System.out.println("Enter phone number: ");
                    String userPhoneNumber = takeInput.nextLine();

                    Contact newContact = new Contact(userName, userPhoneNumber);
                    addContact(newContact);
                    System.out.println("Contact added successfully");

                    break;

                case 2:
                    System.out.println("Enter phone number: ");
                    userPhoneNumber = takeInput.nextLine();
                    deletePhoneNumber(userPhoneNumber);

                    break;
                case 3:
                    System.out.println("Search by name(N) or phone number(P): ");
                    String searchCondition = takeInput.nextLine();
                    if (searchCondition.equalsIgnoreCase("n")){
                        System.out.println("Input name: ");
                        String searchName = takeInput.nextLine();
                        if (contactMap.containsValue(searchName)){
                            System.out.println("Found contact: "+searchName);
                        }else{
                            System.out.println("Contact not found");
                        }
                    }else{
                        String searchPhoneNumber=takeInput.nextLine();
                       System.out.println("Input phone number: ");
                       if (contactMap.containsValue(searchPhoneNumber)){
                           System.out.println("Contact found: "+searchPhoneNumber);

                       }
                    }
            }
        }
        takeInput.close();
    }
    Map<String, Contact> contactMap;
    public void contactManager(){
        contactMap= new HashMap<>();
    }
    public void addContact(Contact contact){
        try {
            contactMap.put(contact.getPhoneNumber(), contact);
        }catch (NullPointerException e){
            System.out.println("The exception is: "+ e);
        }
    }
    public void deletePhoneNumber(String phoneNumber){
        contactMap.remove(phoneNumber);
    }
    public Map<String, Contact> searchContact(Contact contact){
        HashMap<String, Contact> searchContact = new HashMap<>();
        for (Map.Entry<String, Contact>entry : contactMap.entrySet()){
            if (contact.getName().equalsIgnoreCase(String.valueOf(contact))||
            contact.getPhoneNumber().equalsIgnoreCase(String.valueOf(contact))){
                searchContact.put(contact.getName(), contact);
            }
        }
        return searchContact;
    }
}
