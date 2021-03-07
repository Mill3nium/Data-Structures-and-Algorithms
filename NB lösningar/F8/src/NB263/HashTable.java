package NB263;

public class HashTable<E, T> {


    private static int CAPACITY = 101;
    private Entry<E, T> table[];
    private int nrOfKeys;
    private int nrDeletedKeys;
    private double THRESHOLD = 0.75;
    private Entry<E, T> DELETED = new Entry<>(null, null);

    public HashTable() {
        this.table = new Entry[CAPACITY];
        nrOfKeys = 0;
        nrDeletedKeys = 0;
    }

    /**find
     * Returns index of key-object
     * */
    public int find(Object key) {
        int index = key.hashCode() % table.length; // Get index of object(modulus så vi inte hamnar utanför)

        if (index < 0) {
            index += table.length;
        }

        while (table[index] != null && (!key.equals(table[index].key))) {
            index++;
            if (index >= table.length) {
                index = 0;
            }
        }
        return index;
    }

    /**Get */
    public T get(Object key) {

        int index = find(key);

        if (table[index] != null) {
            return table[index].value;
        } else return null;
    }
    /**Put */
    public T put(E key, T value){
        int index = find(key);

        if (table[index] == null){
            table[index] = new Entry<>(key,value);
            nrOfKeys++;
            double load = (double) (nrOfKeys + nrDeletedKeys)/table.length;

            if (load > THRESHOLD){
                rehash();
            }
            return null;
        }
        T oldValue = table[index].value;
        table[index].value = value;
        return oldValue;
    }

    /**Remove*/
    public T remove(Object key) {
        int index = find(key);

        if (table[index] == null || table[index].equals(DELETED)) {
            return null;
        } else {
            T value = table[index].value;
            table[index] = DELETED; // null element at index
            nrDeletedKeys += 1;
            nrOfKeys -= 1;
            return value;
        }
    }

    /**Rehash*/

    private void rehash() {
        Entry<E, T> oldTable[] = table;
        table = new Entry[oldTable.length * 2 - 1];
        nrOfKeys = 0;
        nrDeletedKeys = 0;

        for (int i = 0; i < table.length; i++) {
            if (oldTable[i] != null && oldTable[i] != DELETED) {
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }


    private static class Entry<E, T> {
        private E key;
        private T value;

        public Entry(E key, T value) {
            this.key = key;
            this.value = value;
        }

        public E getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

    }
}


