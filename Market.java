import java.util.ArrayList;
import java.util.List;



public class Market implements MarketBehaviour, QueueBehaviour {

    private List<Human> actors = new ArrayList<Human>();

    private List<Human> actorsAtOffice = new ArrayList<Human>();

    public void acceptToMarket(Human actor) {// входит в магазин
        if (!actors.contains(actor)) {
            actors.add(actor);
            System.out.printf("%s вошёл в магазин \n", actor.getName());
        }
    }



    @Override
    public void releaseFromMarket(Human actor) {// выходит из магазина
        int namActor = actors.indexOf(actor);
        actors.remove(namActor);
        System.out.printf("%s вышел из магазина, , забрав заказ. \n", actor.getName());
    }

    public void releaseFromMarket() {
        List<Human> temp = new ArrayList<>();
        for (Human human : actors) {
            if (human.isTakeOrder()) {
                System.out.printf("%s вышёл из магазина.\n", human.getName());
                temp.add(human);
            }
        }
        actors.removeAll(temp);
    }

    @Override
    public void update() {
        int i = 0;
        for (Human human : actors) {
            if (!human.isTakeOrder()) {
                takeInQueue(human);
            }
        }
        while (actorsAtOffice.size() > 0) {
            while (actorsAtOffice.size() > 0) {
                takeOrders();
                i++;
            }
        }

    }

    @Override
    public void giveOrders(Human actor, List<EProduct> products) {

            System.out.printf("%s сделал заказ \n", actor.getName());
        int namActor = actors.indexOf(actor);
        Human tempActor = actors.remove(namActor);
        tempActor.saveOrder(products);
        actors.add(tempActor);
    }

    public void giveOrder(Human actor, EProduct product) { // сделать заказ

        System.out.printf("%s сделал заказ \n", actor.getName());
        int namActor = actors.indexOf(actor);
        Human tempActor = actors.remove(namActor);
        tempActor.saveOrder(product);
        actors.add(tempActor);
    }

    @Override
    public void releaseFromQueue(Human actor) {// выход из очереди
        System.out.printf("%s вышел из очереди \n", actor.getName());
        int namActor = actors.indexOf(actor);
        actorsAtOffice.remove(namActor);
    }

    public void releaseFromQueue() {// выход из очереди
        System.out.printf("%s вышел из очереди \n", actors.get(0).getName());
        actorsAtOffice.remove(0);
        
    }

    @Override
    public void takeInQueue(Human actor) {// вход в очередь
        System.out.printf("%s встал в очередь \n", actor.getName());
        if (actor.isMakeOrder()) {
            actorsAtOffice.add(actor);
        }

    }

    @Override
    public void takeOrders() {// удалить первый заказ из списка
        Human actorWithOrder = actorsAtOffice.remove(0);
        System.out.printf("%s получил заказ и вышел из очереди. \n", actorWithOrder.getName());
        actorWithOrder.setTakeOrder(true);
    }

    public int countActors(){ // кол-во покупателей

        return actors.size();
    }
}