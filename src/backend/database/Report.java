package backend.database;

import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Report implements Comparable<Report>{
    private final AtomicInteger upvotes;
    private final AtomicInteger downvotes;
    private final Date createTime;
    private final HashSet<Tag> tags;
    private final String author;
    private int severity;
    public Report(String[] tags, String author) {
        upvotes = new AtomicInteger(0);
        downvotes = new AtomicInteger(0);
        this.author = author;
        createTime = new Date();
        this.tags = new HashSet<>();
        severity = 0;
        for (String s : tags) {
            severity += Tag.valueOfLabel(s).sev;
            this.tags.add(Tag.valueOfLabel(s));
        }
    }
    @Override
    public int compareTo(Report rep) {
        return this.getUpvotes() + rep.getUpvotes() - rep.getUpvotes() - this.getDownvotes();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getAuthor() {
        return author;
    }

    public HashSet<Tag> getTags() {
        return tags;
    }

    public int getUpvotes() {
        return upvotes.get();
    }

    public int getDownvotes() {
        return downvotes.get();
    }

    public void addUpvote() {
        this.upvotes.addAndGet(1);
    }

    public void addDownvote() {
        this.downvotes.addAndGet(1);
    }

    public int getSeverity() {
        return severity;
    }

    public int getScore() {
        return this.upvotes.get() - this.downvotes.get();
    }
}
