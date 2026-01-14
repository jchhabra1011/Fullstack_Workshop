public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // Swap returns a new Pair with key/value reversed
    public Pair<V, K> swap() {
        return new Pair<>(value, key);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pair)) return false;
        Pair<?, ?> other = (Pair<?, ?>) obj;
        return (key == null ? other.key == null : key.equals(other.key)) &&
               (value == null ? other.value == null : value.equals(other.value));
    }

    @Override
    public int hashCode() {
        int result = (key == null ? 0 : key.hashCode());
        result = 31 * result + (value == null ? 0 : value.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
