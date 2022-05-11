package com.t2010a.t2010a.demo;

import com.t2010a.t2010a.entity.Customer;
import com.t2010a.t2010a.model.CustomerModel;
import com.t2010a.t2010a.model.InMemoryCustomerModel;
import com.t2010a.t2010a.model.MySqlCustomerModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private static CustomerModel customerModel;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Choose type of model: ");
            System.out.println("--------------------------");
            System.out.println("1. In memory model.");
            System.out.println("2. My SQL model.");
            System.out.println("--------------------------");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    customerModel = new InMemoryCustomerModel();
                    break;
                case 2:
                    customerModel = new MySqlCustomerModel();
                    break;
            }
            generateMenu();
        }
    }

    private static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------Customer Manager--------------");
            System.out.println("1. Create new customer");
            System.out.println("2. Show all customer");
            System.out.println("3. Update customer");
            System.out.println("4. Delete customer");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    createNewCustomer();
                    break;
                case 2:
                    showAllCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("Bye bye");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }

    private static void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer ID to delete: ");
        String cusID = scanner.nextLine();
        Customer existingCustomer = customerModel.findById(cusID);
        if (existingCustomer == null) {
            System.err.println("404, Student not found!");
        } else {
            if (customerModel.delete(cusID)) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer id to update");
        String cusID = scanner.nextLine();
        Customer existingCustomer = customerModel.findById(cusID);
        if (existingCustomer == null){
            System.err.println("404, Student not found!");
        }else {
            System.out.println("Enter name");
            String name = scanner.nextLine();
            existingCustomer.setName(name);
            System.out.println("Enter phone");
            String phone = scanner.nextLine();
            existingCustomer.setPhone(phone);
            if (customerModel.update(cusID, existingCustomer) != null) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void showAllCustomer() {
        List<Customer> list = customerModel.findAll();
        for (Customer cus:
                list){
            System.out.println(cus.toString());
        }
    }

    private static void createNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer id");
        String cusID = scanner.nextLine();
        System.out.println("Enter customer name");
        String name = scanner.nextLine();
        System.out.println("Enter customer phone");
        String phone = scanner.nextLine();
        Customer customer = new Customer(cusID, name, phone, "", LocalDateTime.of(2000,11,11,11,11));
        if (customerModel.save(customer) != null) {
            System.out.println("Create student success!");
        }else {
            System.err.println("Save student fails, please try again later!");
        }
    }
}
