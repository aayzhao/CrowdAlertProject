package backend.database;

import java.util.Map;
import java.util.HashMap;

public enum Tag {
    FIRE("Fire", 10),
    GAS_LEAK("Gas leak", 5),
    DEFAULT("", 0);

    private static final Map<String, Tag> BY_LABEL = new HashMap<>();
    private static final Map<Integer, Tag> BY_SEV = new HashMap<>();

    static {
        for (Tag e : values()) {
            BY_LABEL.put(e.label, e);
            BY_SEV.put(e.sev, e);
        }
    }

    public final String label;
    public final int sev;

    private Tag(String label, int sev) {
        this.label = label;
        this.sev = sev;
    }

    public static Tag valueOfLabel(String label) {
        return BY_LABEL.getOrDefault(label, DEFAULT);
    }
    public static Tag valueOfSev(int sev) {
        return BY_SEV.getOrDefault(sev, DEFAULT);
    }

}
