package Observer;
import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float price;

    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }

    public float getPrice() {
        return price;
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(price);
        }
    }
}
