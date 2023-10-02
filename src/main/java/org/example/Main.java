package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Start combine file in root folder");
        CombineService combineService = new CombineService();
        try{
            combineService.combineExcelFile();
            System.out.println("finish to combine ...");
        } catch(Exception e) {
            System.out.println("fail to combine excel folder !");
            throw e;
        }
//        System.out.println("Enter to exit ...");
//        String input = scanner.nextLine();
//        System.out.println("--> " + input);
    }
}