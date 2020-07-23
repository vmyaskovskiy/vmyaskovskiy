package ru.job4j.lyambda;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleHashMap решение задачи 8. Реализовать собственную структуру данных - HashMap[#143718]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class SimpleHashMap<K, V> implements Iterable<SimpleEntry> {

    public SimpleHashMap() {
    }

    private int capacity = 12;
   public SimpleEntry<K, V>[] table = new SimpleEntry[this.capacity];

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
        SimpleEntry<K, V>[] newTable = new SimpleEntry[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            if (i < oldCapacity && this.table[i] != null) {
                int newIndex = indexFor(hash(this.table[i].getKey().hashCode()), this.capacity);
               newTable[newIndex] = this.table[i];
            }
        }
        this.table = newTable;
    }

    public void setEntry(K key, V value, int hash, int index) {
        SimpleEntry<K, V> one = new SimpleEntry<K, V>();
        one.setHash(hash);
        one.setKey(key);
        one.setValue(value);
        this.table[index] = one;
    }

    public  boolean insert(K key, V value) {

        int hash = hash(key.hashCode());
        int index = indexFor(hash, this.capacity);
        SimpleEntry<K, V> e = this.table[index];
        if (e == null) {
            setEntry(key, value, hash, index);
            return true;
        } else if (e.hash == hash && (e.getKey() == key || e.getKey().equals(key))) {
            setEntry(key, value, hash, index);
            return true;
        } else if (e.hash == hash && e.getKey() != key) {
            return false;
        }
        System.out.println("увеличиваем таблицу");
            increaseTable();
            int newIndex = indexFor(hash(key.hashCode()), this.capacity);
        setEntry(key, value, hash, newIndex);
        return true;
    };

    public V get(K key) {
        int hash = hash(key.hashCode());
        for (int i = 0; i < this.capacity; i++) {
            if (!(this.table[i] == null)) {
                if (this.table[i].hash == hash
                        && this.table[i].getKey() == key
                        || this.table[i].getKey().equals(key)) {
                    return this.table[i].getValue();
                }
            }
        }
        return null;
    };

    public int getCapacity() {
        return this.capacity;
    }

    public boolean delete(K key) {
        int hash = hash(key.hashCode());
        int index = indexFor(hash, this.capacity);
        boolean res = false;

        if (this.table[index] != null ? true : false) {
            this.table[index] = null;
            res = true;
        }
        return res;
    };


    @Override
    public Iterator<SimpleEntry> iterator() {
        SimpleEntry[] e = this.table;
        int l = getCapacity();
        Iterator<SimpleEntry> iterator = new Iterator<>() {
            private int ind = 0;
            @Override
            public boolean hasNext() {
               if (ind >= l) {
                   throw new NoSuchElementException();
               }
                while (e[ind] == null) {
                    ind++;
                    if (ind >= l) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public SimpleEntry next() {
              if (!hasNext()) {
                  throw new NoSuchElementException();
              }
              return e[ind++];
            }
        };
        return  iterator;
    }
}
