package datastructure.hashtable;

public class SimpleHashTable<K,V> {

    class Entry<K,V> {
        public int hash;
        public K key;
        public V value;
        public Entry<K,V> next;

        public Entry(int hash, K key, V value, Entry<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private float loadFactor;
    private int capacity;
    private int count;
    private int threshold;

    private transient Entry<K,V>[] table;
    
    public SimpleHashTable(int initialCapacity, float loadFactor) {
        if(initialCapacity < 0 || loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException(String.format("Illegal capacity or loadFactor [capacity=%s,loadFactor=%s]", initialCapacity, loadFactor));
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        table = (Entry<K,V>[]) new Entry[this.capacity];
        this.threshold = (int)(this.capacity * this.loadFactor);
    }

    public SimpleHashTable(){
        this(100000, 0.75f);
    }

    public synchronized V get(K key) {
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % this.capacity; 

        for(Entry<K,V> entry = this.table[index]; entry != null; entry = entry.next){
            if(entry.hash == hash && entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }

    public synchronized V put(K key, V value) {
        if (key == null || value == null)
            throw new IllegalArgumentException("Null is not allowed for key or value");
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % this.capacity; 
        
        for(Entry<K,V> entry = this.table[index]; entry != null; entry = entry.next){
            if(entry.hash == hash && entry.key.equals(key)){
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        if(count >= threshold){
            rehash();
            index = (hash & 0x7FFFFFFF) % this.capacity;
        }

        Entry<K,V> entry = this.table[index];
        table[index] = new Entry<K,V>(hash, key, value, entry);
        this.count ++;
        return null;
    }

    private void rehash() {
        int newCapacity = this.capacity * 2 + 1;
        Entry<K,V>[] newTable = (Entry<K,V>[]) new Entry[newCapacity];

        for(int i = this.capacity - 1; i >= 0 ; i --){
            for(Entry<K,V> entry = this.table[i]; entry != null; ) {
                Entry<K,V> nextEntry = entry.next;
                int index = (entry.hash & 0x7FFFFFFF) % newCapacity; 
                entry.next = newTable[index];
                newTable[index] = entry;
                entry = nextEntry;
            }
        }

        this.capacity = newCapacity;
        this.table = newTable;
        this.threshold =  (int) (this.capacity * this.loadFactor);
    }

    public synchronized V remove(K key){
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % this.capacity; 

        Entry<K,V> previous = null;

        for(Entry<K,V> entry = this.table[index]; entry != null; previous=entry, entry = entry.next){
            if(entry.hash == hash && entry.key.equals(key)){
                V value = entry.value;
                if(previous == null) {
                    this.table[index] = entry.next;
                } else {
                    previous.next = entry.next;
                }
                this.count--;
                entry = null;
                return value;
            }         
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleHashTable<String,String> table = new SimpleHashTable<String, String>(3, 0.75f);

        table.put("a","a_value");
        table.put("b","b_value");
        table.put("c","c_value");
        table.put("d","d_value");
        table.put("e","e_value");
        table.put("f","f_value");
        table.put("g","g_value");

        System.out.println(table.get("a"));
        System.out.println(table.get("b"));
        System.out.println(table.get("c"));
        System.out.println(table.get("d"));
        System.out.println(table.get("e"));
        System.out.println(table.get("f"));
        System.out.println(table.get("g"));

        System.out.println(table.get("ooo"));
    }
}
