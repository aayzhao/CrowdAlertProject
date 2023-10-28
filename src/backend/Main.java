package backend;

import backend.database.Database;

public class Main {
    public static Database db;
    public static void main(String[] args) {
        // ServerEngine.connectToServer();
        db = new Database();
        ServerEngine.connectToServerMultiple();
    }
}
