package observer;

import java.util.Observable;
import java.util.Observer;

public class BookObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Adding book: " +arg);
    }
}
