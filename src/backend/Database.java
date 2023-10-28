package backend;

import java.util.concurrent.ConcurrentHashMap;

public class Database {
    ConcurrentHashMap<String, Boolean> emails = new ConcurrentHashMap<String, Boolean>();
    public Database() {

    }
}
