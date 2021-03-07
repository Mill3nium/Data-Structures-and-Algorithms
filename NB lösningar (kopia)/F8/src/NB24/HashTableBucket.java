package NB24;

import NB263.*;

import java.util.*;

public class HashTableBucket<K, V> {


    private LinkedList<Entry<K, V>>[] table;

    @SuppressWarnings("unchecked")
    public HashTableBucket(int initialSize) {
        table = new LinkedList[initialSize];
    }

    public static void main(String[] args) {
        HashTableBucket<Object, Object> hashTableBucket = new HashTableBucket(10);

        hashTableBucket.put("Milan", 1);
        hashTableBucket.put("Languric", 2);
        hashTableBucket.put("KTH", 3);
        hashTableBucket.put("Stockholm", 4);



       // System.out.println(hashTableBucket.get("Milan"));
        //System.out.println(hashTableBucket.remove("Milan"));

        System.out.println();
        System.out.println(hashTableBucket.toString());

        hashTableBucket.remove("Milan");
        System.out.println(hashTableBucket.toString());


        // String[] array2 = {"A", "B", "C", "D", "A", "A"};
        //System.out.println(hashTableBucket.getUnique(array));
        //String[] array = {"Jag", "Älskar", "Java", "<3"};
    }

    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null;
        }
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        } else {
            V oldValue;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
        }
        table[index].addFirst(new Entry<>(key, value));
        return null;
    }

    /**Prints all unique values and nr of them*/
    public String getUnique(String[] array) {
        StringBuilder sb = new StringBuilder();
        HashSet<String> unique = new LinkedHashSet<>();
        unique.addAll(Arrays.asList(array));

        var count = 0;
        for (var u : unique) {
            count++;
            sb.append(u + " ");
        }
        sb.append(" |Number of unique words are: " + count + " pcs");

        return sb.toString();
    }

    /**removes element*/
    public V remove(K key) {
        int index = key.hashCode() % table.length; //Get index
        return (V) table[index].remove();
    }

    /**toString*/
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (var element : table)
            sb.append(element + " ");
        return sb.toString();
    }

    private static class Entry<K, V> {


        public K key;
        public V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}