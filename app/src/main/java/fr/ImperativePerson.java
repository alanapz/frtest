package fr;
import java.util.*;

public enum ImperativePerson {
    TU,
    NOUS,
    VOUS;

    public <T> T select(T tu, T nous, T vous) {
        if (this == TU) {
            return tu;
        }
        else if (this == NOUS) {
            return nous;
        }
        else if (this == VOUS) {
            return vous;
        }
        else {
            return null;
        }
    }
    
    public static <T, M extends Map<ImperativePerson, T>> M populate(M map, T tu, T nous, T vous) {
        map.put(ImperativePerson.TU, tu);
        map.put(ImperativePerson.NOUS, nous);
        map.put(ImperativePerson.VOUS, vous);
        return map;
    }
}