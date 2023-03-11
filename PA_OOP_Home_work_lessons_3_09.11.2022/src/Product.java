import java.util.Objects;

public abstract class Product {
    private String productRange;
    private int countOfProducts;
    private double priceOfProduct;

    public Product(String productRange, int countOfProducts, double priceOfProduct) {
        this.productRange = productRange;
        this.countOfProducts = countOfProducts;
        this.priceOfProduct = priceOfProduct;
    }

    public String getProductRange() {
        return productRange;
    }

    public void setProductRange(String productRange) {
        this.productRange = productRange;
    }

    public int getCountOfProducts() {
        return countOfProducts;
    }

    public void setCountOfProducts(int countOfProducts) {
        this.countOfProducts = countOfProducts;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public abstract void addItemFromStock(int countOfProducts);
    public abstract void putItemInStock(int countOfProducts);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        if (countOfProducts != that.countOfProducts) return false;
        if (priceOfProduct != that.priceOfProduct) return false;
        return productRange.equals(that.productRange);
    }

    @Override
    public int hashCode() {
        int result = productRange == null ? 0 : productRange.hashCode();
        result = result * 31 + countOfProducts;
        result = (int) (result * 31 + priceOfProduct);
        return result;
    }

    @Override
    public String toString() {
        return getProductRange() + " - " +
                getCountOfProducts() + " pieces for " +
                getPriceOfProduct() + " UAH.";
    }
}

//Домашнее задание:
//Спроектировать систему классов для интернет-магазина.
// Покупатель может иметь n денежных средств, n купленных товаров, корзину с зарезервированными товарами.
// Товары бывают разных категорий(продовольствие, одежда, мебель, сувениры), каждый товар представлен в  магазине в фиксированном кол-ве.
//Система должна позволять:
//1. Обращаться человеку в магазин с запросом на получение ассортимента/покупку n-го количества товаров.
//2. Позволять заведующему магазина добавлять/убирать товары со склада.
//3. При оформлении заказа пользователем перенаправлять на систему оплаты - она показывает список заказанных товаров из корзины и при
// подтверждении пользователем совершает покупку(при условии достаточности средств на счету пользователя)