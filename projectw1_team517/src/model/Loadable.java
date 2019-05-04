package model;

import java.io.IOException;
import java.util.ArrayList;

public interface Loadable {

    void load(String fileName) throws IOException;

    ArrayList<Item> getItems();
}
