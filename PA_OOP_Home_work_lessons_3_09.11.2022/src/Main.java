public class Main {
    public static void main(String[] args) {
        Client client = new Client(1500);
        client.customerRequest();
        client.fillingShoppingCart();
        client.returnTotalSumShoppingCart();
        client.payForProducts(client);

    }
}
