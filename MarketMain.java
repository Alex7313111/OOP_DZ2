import java.util.List;

public class MarketMain {

    public static void main(String[] args) {

        Human polina = new Human("Polina");
        Human anton = new Human("Anton");
        Human ivan = new Human("Ivan");


        Market berezka = new Market();
        berezka.acceptToMarket(polina);

        berezka.acceptToMarket(ivan);
        berezka.update();
        berezka.giveOrder(polina, EProduct.APPLE);
        //berezka.update();
        berezka.giveOrders(ivan, List.of(EProduct.PEAR, EProduct.PASTA, EProduct.MEAT));


        berezka.releaseFromMarket(polina);
        berezka.releaseFromMarket(ivan);
        berezka.acceptToMarket(anton);
        berezka.update();
        berezka.releaseFromMarket();

        
    }
}