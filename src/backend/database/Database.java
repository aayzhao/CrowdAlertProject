package backend.database;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Database {
    ConcurrentHashMap<String, String> emails;
    ConcurrentLinkedDeque<Report> reports;
    public Database() {
        emails = new ConcurrentHashMap<>();
        reports = new ConcurrentLinkedDeque<>();
    }

    public Report getMostRecentReport() {
        return reports.getLast();
    }
}
