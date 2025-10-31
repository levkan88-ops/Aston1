
class Product {
    private String name, productionDate, manufacturer, countryOfOrigin;
    private double price;
    private boolean isReserved;

    public Product(String name, String productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void displayInfo() {
        System.out.println("Название: " + name + ", Дата: " + productionDate +
                ", Производитель: " + manufacturer + ", Цена: " + price +
                ", Забронирован: " + (isReserved ? "Да" : "Нет"));
    }
}

class Park {
    private String parkName, location;

    public class Attraction {
        private String attractionName, workingHours;
        private double price;

        public Attraction(String attractionName, String workingHours, double price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void displayInfo() {
            System.out.println("Аттракцион: " + attractionName + ", Время: " +
                    workingHours + ", Цена: " + price);
        }
    }

    public Park(String parkName, String location) {
        this.parkName = parkName;
        this.location = location;
    }
}

public class Main {
    public static void main(String[] args) {
        // 1-2. Товары
        Product[] products = new Product[5];
        products[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung", "Korea", 5599, true);
        products[1] = new Product("iPhone 10 Pro", "11.05.2023", "Apple", "USA", 7599, false);
        products[2] = new Product("Xiaomi Mi 7", "10.12.2024", "Xiaomi", "China", 3299, true);
        products[3] = new Product("MacBook Pro M1", "20.04.2022", "Apple", "USA", 5999, false);
        products[4] = new Product("Sony PlayStation 5", "31.10.2025", "Sony", "Japan", 3999, true);

        System.out.println("=== ТОВАРЫ ===");
        for (Product product : products) {
            product.displayInfo();
        }

        // 3. Парк
        System.out.println("\n=== ПАРК ===");
        Park park = new Park("Солнечный остров", "Краснодар");
        Park.Attraction att1 = park.new Attraction("Автодром", "10:00-22:30", 300);
        Park.Attraction att2 = park.new Attraction("Колесо обозрения", "10:00-22:30", 300);

        att1.displayInfo();
        att2.displayInfo();
    }
}