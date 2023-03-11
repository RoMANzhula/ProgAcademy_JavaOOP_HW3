import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    private double money;
    int purchasedItemCounter = 0; // счетчик купленных товаров
    ArrayList<String> shoppingCart = new ArrayList<>(); //корзина с товаром

     static double totalSum = 0;

    public Client(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public void customerRequest() { // запрос для клиента
        System.out.println("Welcome to our online store!" + "\n" + "Would you like to see a list of our products? Please enter Y/N:");
        Scanner scanner = new Scanner(System.in);
        String customerRequest = scanner.nextLine().toLowerCase();
        if (customerRequest.equals("y")) {
            System.out.println("List of products of our online store:");
            Shop.returnAllProducts();
        } else {
            System.out.println("We are very sorry. We will wait for you next time. Good luck!");
            customerRequest();
        }
    }

    public void fillingShoppingCart() {//заполняем корзину покупателя
        System.out.println("Please select the products you want to buy (enter products separated by a new line):");
        Scanner scanner = new Scanner(System.in);
        String clientList = "s";
        while (!clientList.equals("")) {
            clientList = scanner.nextLine().toLowerCase();
            shoppingCart.add(clientList);
        }

        System.out.println("Contents of your shopping cart:");
        for (int i = 0; i < shoppingCart.size() - 1; i++) {
            purchasedItemCounter++;
            System.out.println(shoppingCart.get(i)  + " - " + purchasedItemCounter + " position.");
        }
    }

    public void returnTotalSumShoppingCart() { // вернуть общую сумму стоимости продуктов в корзине
        for (String elementOfShoppingCart : shoppingCart) {
            if (elementOfShoppingCart.equals("bread")) {
                totalSum += 25;
            } if (elementOfShoppingCart.equals("milk")) {
                totalSum += 40;
            } if (elementOfShoppingCart.equals("coffee")) {
                totalSum += 150;
            } if (elementOfShoppingCart.equals("jacket")) {
                totalSum += 5000;
            } if (elementOfShoppingCart.equals("dress")) {
                totalSum += 2500;
            } if (elementOfShoppingCart.equals("pants")) {
                totalSum += 800;
            } if (elementOfShoppingCart.equals("table")) {
                totalSum += 7000;
            } if (elementOfShoppingCart.equals("chair")) {
                totalSum += 800;
            } if (elementOfShoppingCart.equals("bed")) {
                totalSum += 15000;
            } if (elementOfShoppingCart.equals("angel")) {
                totalSum += 300;
            } if (elementOfShoppingCart.equals("mace")) {
                totalSum += 1500;
            } if (elementOfShoppingCart.equals("pyramid")) {
                totalSum += 150;
            }
        }
        System.out.println("Total amount due: " + totalSum);
    }

    public void payForProducts(Client client) { // оплата за продукты(товары)
        System.out.println("Are you ready to pay for the item you have chosen? Please enter Y/N:");
        Scanner scanner = new Scanner(System.in);
        String strToPay = scanner.nextLine().toLowerCase();

        if (strToPay.equals("y")) {
            if (client.getMoney() >= totalSum) {
                System.out.println("Everything is fine, you have paid for the item you have chosen.");
                double balance = client.getMoney() - totalSum;
                System.out.println("Your balance after purchase: " + balance + " UAH.");
            } else {
                double shortage = totalSum - client.getMoney();
                System.out.println("You don't have enough money. You are missing: " + shortage + "UAH. We are waiting for you next time.");
            }
        } else {
            customerRequest();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Double.compare(client.money, money) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return "Client{" +
                "money=" + money +
                '}';
    }
}

////Домашнее задание:
////Спроектировать систему классов для интернет-магазина.
//// Покупатель может иметь n денежных средств, n купленных товаров, корзину с зарезервированными товарами.
//// Товары бывают разных категорий(продовольствие, одежда, мебель, сувениры), каждый товар представлен в  магазине в фиксированном кол-ве.
////Система должна позволять:
////1. Обращаться человеку в магазин с запросом на получение ассортимента/покупку n-го количества товаров.
////2. Позволять заведующему магазина добавлять/убирать товары со склада.
////3. При оформлении заказа пользователем перенаправлять на систему оплаты - она показывает список заказанных товаров из корзины и при
//// подтверждении пользователем совершает покупку(при условии достаточности средств на счету пользователя)