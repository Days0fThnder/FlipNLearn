package util;

import java.util.HashMap;

/**
 * Created by Jean-Leman on 2/20/2016.
 */
public class DataStorage {

    private static DataStorage ourInstance = new DataStorage();
    public static DataStorage getInstance() {
        return ourInstance;
    }
    private DataStorage() {
    }
    public HashMap<String,Object> storage = new HashMap<String, Object>();
}
