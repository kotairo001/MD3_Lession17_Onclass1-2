package rikkei.academy.view;

import rikkei.academy.config.Config;

public class NavBar {
    public NavBar() {
        System.out.println("=========PRODUCT MANAGE==========");
        System.out.println("1. Show product");
        System.out.println("2. Create product");
        System.out.println("3. Update product");
        System.out.println("4. Delete product");
        System.out.println("5. Search product");
        System.out.println("6. Copy file");
        System.out.println("7. Read copy file");
        int choice = Config.scanner().nextInt();
        switch (choice){
            case 1:
                new ProductView().showListProduct();
                break;
            case 2:
                new ProductView().addProduct();
                break;
            case 4:
                new ProductView().deleteProduct();
                break;
            case 5:
                new ProductView().searchProduct();
                break;
            case 6:
                new ProductView().copyFile();
                break;
            case 7:
                new ProductView().readCopyFile();
                break;

        }
    }

    public static void main(String[] args) {
        new NavBar();
    }
}
