public class Clothes extends Product {
    public Clothes(String productRange, int countOfProducts, double priceOfProduct) {
        super(productRange, countOfProducts, priceOfProduct);
        addItemFromStock(countOfProducts);
        putItemInStock(countOfProducts);
    }
    @Override
    public void addItemFromStock(int countOfProducts) {
        if (countOfProducts < 10) {
            //System.out.println("Manager ordered - " + (this.countOfProducts - countOfProducts) + " product(s) from stock");
        }
    }
    @Override
    public void putItemInStock(int countOfProducts) {
        if (countOfProducts > 10) {
            //System.out.println("Manager return - " + (countOfProducts - this.countOfProducts) + " product(s) in stock");
        }
    }
}
