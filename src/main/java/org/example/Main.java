package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start combine file in root folder");
        CombineService combineService = new CombineService();
        try{
            combineService.combineExcelFile();
            System.out.println("finish to combine ...");
        } catch(Exception e) {
            System.out.println("fail to combine excel folder !");
            throw e;
        }
    }
}