package apz.fr.utils;

public interface Producer<T> {

    T next();

    default T[] next(T[] out) {
        for(int i=0; i<out.length; i++) {
            out[i] = next();
        }
        return out;
    }

    static <T> T next(Producer<T> instance) {
        return (instance != null ? instance.next() : null);
    }
}
