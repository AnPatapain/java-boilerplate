package cms.cm7.boutonInc;

import javax.swing.*; // Pas besoin de tout ça ici ...
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Model
class CounterModel {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        counter++;
    }
}