package ru.job4j.lyambda;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Entry> {

    private int capacity = 12;
    public class Entry<K, V> {
        private K key;
        private V value;
        int hash;

        public Entry(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
        public K getKey() {
            return (K) key;
        }
        public V getValue() {
           return (V) value;
        }
    }
    Entry<K, V> e = null;

   public Entry<K, V>[] table = new Entry[this.capacity];


    public int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public int indexFor(int h, int capacity) {
        return h & (capacity - 1);
    }

    public void setCapacity() {
        this.capacity = this.capacity * 2 + 2;
    }


    public void increaseTable() {
        int oldCapacity = this.capacity;
        setCapacity();
        Entry<K, V>[] newTable = new Entry[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            if (i < oldCapacity) {
               newTable[i] = this.table[i];
            }
        }
        this.table = newTable;
    }

    public  boolean insert(K key, V value) {

        int hash = hash(key.hashCode());
        int index = indexFor(hash, this.capacity);
        Entry<K, V> e = this.table[index];
        if (e == null) {
            this.table[index] = new Entry<K, V>(key, value, hash);
            return true;
        } else if (e.hash == hash && (e.getKey() == key || e.getKey().equals(key))) {
            this.table[index] = new Entry<K, V>(key, value, hash);
            return true;
        } else if (e.hash == hash && e.getKey() != key) {
            return false;
        }
        System.out.println("увеличиваем таблицу");
            increaseTable();
            int newIndex = indexFor(hash(key.hashCode()), this.capacity);
            this.table[newIndex] = new Entry<K, V>(key, value, hash);
        return true;
    };

    public V get(K key) {
        int hash = hash(key.hashCode());
        for (int i = 0; i < this.capacity; i++) {
            if (this.table[i] == null) {
            } else if (this.table[i].hash == hash
                    && this.table[i].getKey() == key
                    || this.table[i].getKey().equals(key)) {
                return this.table[i].getValue();
            }
        }
        return null;
    };

    public int getCapacity() {
        return this.capacity;
    }

    public boolean delete(K key) {
        int hash = key.hashCode();
        for (int i = 0; i < this.capacity; i++) {
            if (this.table[i] == null) {
            } else if (this.table[i].hash == hash
                    && this.table[i].getKey() == key
                    || this.table[i].getKey().equals(key)) {
                this.table[i] = null;
                return true;
            }
        } return false;
    };


    @Override
    public Iterator<SimpleHashMap.Entry> iterator() {
        Entry[] e = this.table;
        int l = getCapacity();
        Iterator<SimpleHashMap.Entry> iterator = new Iterator<>() {
            private int ind = 0;
            @Override
            public boolean hasNext() {
                return ind < l;
            }
            @Override
            public Entry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return  e[ind++];
            }
        };
        return  iterator;
    }
}
