package com.laner.LibrarySystemExer;

import java.util.Scanner;
/**
 *
 */
public class Book {
    //属性
    private int bookId;
    private String boodkName;
    private double price;

    //无参构造器
    public Book() {
    }

    //有参构造器
    public Book(int bookId, double price) {
        this.bookId = bookId;
        this.price = price;
    }
    public Book(int bookId, String boodkName, double price) {
        this.bookId = bookId;
        this.boodkName = boodkName;
        this.price = price;
    }


    //get & set
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBoodkName() {
        return boodkName;
    }

    public void setBoodkName(String boodkName) {
        this.boodkName = boodkName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //toString
    @Override
    public String toString() {
        return bookId +"\t\t"+ boodkName + "\t\t" + price;
    }


    //setall
    public static Book setAll(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入图书编号：");
        int bookId =scanner.nextInt();
        System.out.print("请输入书名：");
        String boodkName=scanner.next();
        System.out.print("请输入图书价格：");
        double price=scanner.nextDouble();
        Book book =new Book(bookId, boodkName, price);
        return book;
    }


}


