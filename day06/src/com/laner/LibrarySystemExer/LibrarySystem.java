package com.laner.LibrarySystemExer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 */
public class LibrarySystem {
    Book [] books =new Book[10];
    ArrayList list = new ArrayList();

    double buyprice=0;

    //主界面
    public void zhujiemian(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("======欢迎来到图书管理系统======");
        System.out.println("===根据选项编号进入相应的操作界面===");
        System.out.println("=========1.添加图书==========");
        System.out.println("=========2.删除图书==========");
        System.out.println("=========3.修改图书==========");
        System.out.println("=========4.查看所有图书========");
        System.out.println("=========5.查看图书==========");
        System.out.println("=========6.购买图书==========");
        System.out.println("=========7.退出系统==========");
        int id =scanner.nextInt();

        switch (id) {
            case 1://添加界面：添加图书到管理系统
                Book book = Book.setAll();
                addBook(book);
                break;
            case 2://删除界面：先展示所有的图书信息（注意展示格式要求），然后根据编号选择要删除的图书信息
                selectBooks();
                System.out.print("请输入要删除的图书编号：");
                int bookId = scanner.nextInt();
                deleteBook(bookId);
                break;
            case 3://修改界面：先展示所有的图书信息（注意展示格式要求），然后根据编号选择要修改的图书信息
                selectBooks();
                System.out.print("请输入要修改的图书编号:");
                bookId = scanner.nextInt();
                updateBook(bookId);
                break;
            case 4://查看图书界面：展示所有的图书信息（注意展示格式要求）
                selectBooks();
                break;
            case 5://查看图书（根据书名查看）：重名的图书需要全部展示出来（注意展示格式要求）
                System.out.println("请输入要查看的书名:");
                String boodkName = scanner.next();
                selectBook(boodkName);
                break;
            case 6://购买图书
                selectBooks();
                System.out.println("请输入要购买的图书编号：");
                bookId=scanner.nextInt();
                System.out.println("请输入要购买的图书数量：");
                int number=scanner.nextInt();
                System.out.println("总金额："+number*buyBook(bookId));
                break;
            case 7://退出
                System.exit(0);
                break;
            default:
                System.out.println("请正确选择操作事项");
                break;
        }
        zhujiemian();
    }

    //1.添加界面：添加图书到管理系统
    public void addBook(Book book) {
        list.add(book);
    }


        //2.删除界面：先展示所有的图书信息（注意展示格式要求），然后根据编号选择要删除的图书信息
        public void deleteBook ( int bookId) {
            //然后根据编号选择要删除的图书信息
            for (int i = 0; i < list.size(); i++) {
                if (((Book) list.get(i)).getBookId() == bookId) {
                    list.remove(i);
                }

            }

        }


            //3.修改界面：先展示所有的图书信息（注意展示格式要求），然后根据编号选择要修改的图书信息
            public void updateBook ( int bookID){
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入新的图书编号：");
                int index = scanner.nextInt();
                System.out.print("请输入新的图书价格：");
                double price = scanner.nextDouble();


                for (int i = 0; i < list.size(); i++) {
                    if (((Book) list.get(i)).getBookId() == bookID) {
                        ((Book) list.get(i)).setBookId(index);
                        ((Book) list.get(i)).setPrice(price);
                    }

                }
            }


            //4.查看图书界面：展示所有的图书信息（注意展示格式要求）
            public void selectBooks () {
                System.out.println("图书编号" + "\t图书名字" + "\t图书价格");
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }

            //5.查看图书（根据书名查看）：重名的图书需要全部展示出来（注意展示格式要求）
            public void selectBook (String boodkName){
                System.out.println("图书编号" + "\t\t图书名字" + "\t\t图书价格");

                for (int i = 0; i < list.size(); i++) {
                    if (((Book) list.get(i)).getBoodkName().equals(boodkName)) {
                        System.out.println(list.get(i));
                    }
                }
            }

            //购买图书
            public double buyBook ( int bookId){

                for (int i = 0; i < list.size(); i++) {
                    if (((Book) list.get(i)).getBookId() == bookId) {
                        buyprice = ((Book) list.get(i)).getPrice();

                    }
                }
                return buyprice;
            }


        }
