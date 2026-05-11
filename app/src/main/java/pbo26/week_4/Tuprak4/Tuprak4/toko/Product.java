package Tuprak4.toko;

public class Product {
    String brand;
    int serialNumber;
    double price;

    Product(String brand, int serialNumber, double price) {
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    
    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Price: " + price);
    }
}

class Smartphone extends Product {
    double screenSize;
    int storage;

    Smartphone(String brand, int serialNumber, double price, double screenSize, int storage) {
        super(brand, serialNumber, price);
        this.screenSize = screenSize;
        this.storage = storage;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size: " + screenSize);
        System.out.println("Storage: " + storage);
    }
}

class Laptop extends Product {
    int ram;
    String processor;

    Laptop(String brand, int serialNumber, double price, int ram, String processor) {
        super(brand, serialNumber, price);
        this.ram = ram;
        this.processor = processor;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("RAM: " + ram);
        System.out.println("Processor: " + processor);
    }
}

class Camera extends Product {
    int resolution;
    String lens;

    Camera(String brand, int serialNumber, double price, int resolution, String lens) {
        super(brand, serialNumber, price);
        this.resolution = resolution;
        this.lens = lens;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Resolution: " + resolution);
        System.out.println("Lens: " + lens);
    }
}