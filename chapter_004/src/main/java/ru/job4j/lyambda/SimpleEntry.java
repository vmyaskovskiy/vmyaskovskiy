package ru.job4j.lyambda;

public class SimpleEntry<K, V> {

        private K key;
        private V value;
        int hash;

    public SimpleEntry() {
    }

    public void setKey(K key) {
            this.key = key;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public void setHash(int hash) {
        this.hash = hash;
    }

    public K getKey() {
        return (K) key;
    }
        public V getValue() {
        return (V) value;
    }
}
