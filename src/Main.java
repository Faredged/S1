import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;
    private String description;

    public Product(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void displayOrder() {
        List<Product> products = cart.getProducts();
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
        System.out.println("Total: $" + cart.getTotalPrice());
    }
}

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product(1, "Laptop", 999.99, "A high-performance laptop.");
        Product phone = new Product(2, "Phone", 499.99, "A smartphone with great features.");
        Product headphones = new Product(3, "Headphones", 198.99, "High-quality headphones.");
        Product keyboard = new Product(4, "Keyboard", 95.99, "A mechanical keyboard.");

        Category electronics = new Category("Electronics");

        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View catalog");
            System.out.println("2. Add product to cart");
            System.out.println("3. View cart");
            System.out.println("4. Place order");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Catalog:");
                System.out.println("1. " + laptop.getName() + " - $" + laptop.getPrice());
                System.out.println("2. " + phone.getName() + " - $" + phone.getPrice());
                System.out.println("3. " + headphones.getName() + " - $" + headphones.getPrice());
                System.out.println("4. " + keyboard.getName() + " - $" + keyboard.getPrice());
            } else if (choice == 2) {
                System.out.print("Enter product ID to add to cart: ");
                int productId = scanner.nextInt();
                if (productId == laptop.getId()) {
                    cart.addProduct(laptop);
                } else if (productId == phone.getId()) {
                    cart.addProduct(phone);
                } else if (productId == headphones.getId()) {
                    cart.addProduct(headphones);
                } else if (productId == keyboard.getId()) {
                    cart.addProduct(keyboard);
                } else {
                    System.out.println("Invalid product ID.");
                }
            } else if (choice == 3) {
                System.out.println("Cart:");
                List<Product> products = cart.getProducts();
                for (Product product : products) {
                    System.out.println(product.getName() + " - $" + product.getPrice());
                }
                System.out.println("Total: $" + cart.getTotalPrice());
            } else if (choice == 4) {
                Order order = new Order(cart);
                System.out.println("Order:");
                order.displayOrder();
                break;
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
