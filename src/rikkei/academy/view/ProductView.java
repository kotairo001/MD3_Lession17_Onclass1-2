package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.ProductController;
import rikkei.academy.model.Product;

import java.util.List;

public class ProductView {

    ProductController productController = new ProductController();
    List<Product> listProduct = productController.getListProduct();

    public void showListProduct() {
        System.out.println(listProduct);
        System.out.println("Input any key to continue or BACK to return");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new NavBar();
        }
    }

    public void addProduct() {
        while (true) {
            int id = 0;
            if (listProduct.size() == 0) {
                id = 1;
            } else {
                id = listProduct.get(listProduct.size() - 1).getProductId() + 1;

            }
            System.out.println("Input the product's name");
            String name = Config.scanner().nextLine();
            System.out.println("Input the product's brand");
            String brand = Config.scanner().nextLine();
            System.out.println("Input the product's price");
            int price = Config.scanner().nextInt();
            System.out.println("Input the product's description");
            String description = Config.scanner().nextLine();
            productController.addProduct(new Product(id, name, brand, price, description));
            System.out.println("Add successfully");
            System.out.println("Input any key to quit or BACK to return");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new NavBar();
                break;
            }
        }
    }

    public void searchProduct() {
        try {
            System.out.println("Input product's id you want to find");
            int id = Config.scanner().nextInt();
            System.out.println(productController.searchProduct(id));
            System.out.println("Input any key to continue or BACK to return");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new NavBar();
            }
        } catch (Exception e) {
            System.err.println("Invalid input");
        }

    }

    public void updateProduct() {
        System.out.println("Input the product's ID you want to update");
        int id = Config.scanner().nextInt();
        if (productController.detailProduct(id) == null) {
            System.out.println("Invalid ID");
        } else {
            System.out.println("Input the product's name");
            String name = Config.scanner().nextLine();
            System.out.println("Input the product's brand");
            String brand = Config.scanner().nextLine();
            System.out.println("Input the product's price");
            int price = Config.scanner().nextInt();
            System.out.println("Input the product's description");
            String description = Config.scanner().nextLine();
            Product product = new Product(id, name, brand, price, description);
            productController.updateProduct(product);
            System.out.println("Update successfully");
            System.out.println("Input any key to continue or BACK to return");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new NavBar();
            }
        }
        ;
    }

    public void deleteProduct() {
        System.out.println("Input the product's ID you want to delete");
        int id = Config.scanner().nextInt();
        if (productController.detailProduct(id) == null) {
            System.out.println("Invalid ID");
        } else {
            productController.delete(id);
        }
        System.out.println("Input any key to continue or BACK to return");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new NavBar();
        }
    }
   //! BAI TAP 2
    public void copyFile() {
        List<Product> copyListProduct = new Config<Product>().readFromFile("D:\\Code\\Java\\Lession18\\FileBI_CRUD\\src\\rikkei\\academy\\database\\product.txt");
        System.out.println(copyListProduct);
        new Config<Product>().writeToFile("D:\\Code\\Java\\Lession18\\FileBI_CRUD\\src\\rikkei\\academy\\database\\copy.txt", copyListProduct);
    }

    public void readCopyFile() {
        List<Product> productFromFileCopy = new Config<Product>().readFromFile("D:\\Code\\Java\\Lession18\\FileBI_CRUD\\src\\rikkei\\academy\\database\\copy.txt");
        System.out.println(productFromFileCopy);
    }
}
