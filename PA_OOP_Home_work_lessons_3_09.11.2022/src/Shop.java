public class Shop {
    public static void returnAllProducts() {
        Product bread = new Food("Bread", 7, 25);
        Product milk = new Food("Milk", 14, 40);
        Product coffee = new Food("Coffee", 6, 150);

        Product jacket = new Clothes("Jacket", 11, 5000);
        Product dress = new Clothes("Dress", 8, 2500);
        Product pants = new Clothes("Pants", 7, 800);

        Product table = new Furniture("Table", 10, 7000);
        Product chair = new Furniture("Chair", 10, 800);
        Product bed = new Furniture("Bed", 10, 15000);

        Product angel = new Souvenirs("Angel", 10, 300);
        Product mace = new Souvenirs("Mace", 10, 1500);
        Product pyramid = new Souvenirs("Pyramid", 10, 150);

        Product[] allProducts = new Product[12];

        allProducts[0] = bread;
        allProducts[1] = milk;
        allProducts[2] = coffee;
        allProducts[3] = jacket;
        allProducts[4] = dress;
        allProducts[5] = pants;
        allProducts[6] = table;
        allProducts[7] = chair;
        allProducts[8] = bed;
        allProducts[9] = angel;
        allProducts[10] = mace;
        allProducts[11] = pyramid;

        for (Product elementOfAllProducts : allProducts) {
            System.out.println(elementOfAllProducts);
        }
    }
}
