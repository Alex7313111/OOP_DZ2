import java.util.List;

public interface QueueBehaviour {

    void takeInQueue(Human actor);//войти в очередь

    void takeOrders();// сделать заказ

    void giveOrders(Human actor, List<EProduct> products);// забрать заказ

    void releaseFromQueue(Human actor);// выйти из очереди
    

    
}