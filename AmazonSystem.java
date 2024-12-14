import java.util.*;

// Customer Class
class Customer {
    private int customerId;
    private String customerName;
    private int loyaltyPoints;

    public Customer(int customerId, String customerName, int loyaltyPoints) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + customerName + ", Loyalty Points: " + loyaltyPoints;
    }
}

// Product Class
class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private Date deliveryDate;

    public Product(int productId, String productName, double productPrice, Date deliveryDate) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.deliveryDate = deliveryDate;
    }

    public int getProductId() {
        return productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName +
                ", Price: " + productPrice + ", Delivery Date: " + deliveryDate;
    }
}

// Order Class
class Order {
    private int orderId;
    private Customer customer;
    private Product product;
    private Date orderDate;

    public Order(int orderId, Customer customer, Product product, Date orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.product = product;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customer + ", Product: " + product + ", Date: " + orderDate;
    }
}

// Comparator for Sorting Products by Price
class ProductPriceComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getProductPrice(), p2.getProductPrice());
    }
}

// Comparator for Sorting Customers by Loyalty Points
class CustomerLoyaltyComparator implements Comparator<Customer> {
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c2.getLoyaltyPoints(), c1.getLoyaltyPoints()); // Descending
    }
}

// Comparator for Sorting Products by Delivery Date
class ProductDeliveryDateComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getDeliveryDate().compareTo(p2.getDeliveryDate());
    }
}

// Main Class
public class AmazonSystem {
    public static void main(String[] args) {
        // Data Structures
        ArrayList<Customer> customerList = new ArrayList<>();
        HashMap<Integer, Product> productMap = new HashMap<>();
        TreeSet<Product> priceSortedProducts = new TreeSet<>(new ProductPriceComparator());
        TreeSet<Customer> loyaltySortedCustomers = new TreeSet<>(new CustomerLoyaltyComparator());
        ArrayList<Order> orderList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // Input for Customers
        System.out.println("Enter the number of customers:");
        int totalCustomers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < totalCustomers; i++) {
            System.out.println("Enter Customer ID:");
            int customerId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Customer Name:");
            String customerName = scanner.nextLine();
            System.out.println("Enter Loyalty Points:");
            int loyaltyPoints = scanner.nextInt();
            scanner.nextLine();

            Customer customer = new Customer(customerId, customerName, loyaltyPoints);
            customerList.add(customer);
            loyaltySortedCustomers.add(customer);
        }

        // Input for Products
        System.out.println("Enter the number of products:");
        int totalProducts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < totalProducts; i++) {
            System.out.println("Enter Product ID:");
            int productId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Product Name:");
            String productName = scanner.nextLine();
            System.out.println("Enter Product Price:");
            double productPrice = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter Delivery Date (yyyy-mm-dd):");
            String deliveryDateString = scanner.nextLine();
            Date deliveryDate = java.sql.Date.valueOf(deliveryDateString);
            Product product = new Product(productId, productName, productPrice, deliveryDate);
            productMap.put(productId, product);
            priceSortedProducts.add(product);
        }

        // Generate Orders
        for (int i = 0; i < Math.min(customerList.size(), productMap.size()); i++) {
            Product product = new ArrayList<>(productMap.values()).get(i);
            Order order = new Order(80 + i, customerList.get(i), product, new Date());
            orderList.add(order);
        }

        // Display Products Sorted by Price
        System.out.println("\nProducts Sorted by Price:");
        for (Product product : priceSortedProducts) {
            System.out.println(product);
        }

        // Display Products Sorted by Delivery Date
        System.out.println("\nProducts Sorted by Delivery Date:");
        for (Product product : priceSortedProducts) {
            System.out.println(product);
        }

        // Display Customers Sorted by Loyalty Points
        System.out.println("\nCustomers Sorted by Loyalty Points:");
        for (Customer customer : loyaltySortedCustomers) {
            System.out.println(customer);
        }

        // Display Orders
        System.out.println("\nOrder List:");
        for (Order order : orderList) {
            System.out.println(order);
        }

        scanner.close();
    }
}
