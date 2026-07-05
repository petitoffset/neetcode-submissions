class LRUCache {
    private Map<Integer, Entry> cache;
    private int capacity;
    private Entry head; // dummy
    private Entry tail; // dummy

    public LRUCache(int capacity) {
        cache = new HashMap<>();  
        this.capacity = capacity;  
        head = new Entry(0, 0);
        tail = new Entry(0, 0); 
        head.after = tail;
        tail.before = head;   
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Entry entry = cache.get(key);
        remove(entry);
        insert(entry); 
        return entry.value;        
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Entry entry = cache.get(key);
            entry.value = value;
            remove(entry);
            insert(entry); 
        } else {
            Entry entry = new Entry(key, value);
            cache.put(key, entry);
            insert(entry);
            if (cache.size() > capacity) {
                Entry first = this.head.after;
                cache.remove(first.key);
                remove(first);
            }
        }
    }

    private void remove(Entry entry) {
        Entry before = entry.before;
        Entry after = entry.after;
        before.after = after;
        after.before = before;
    }

    private void insert(Entry entry) {
        Entry last = this.tail.before;
        last.after = entry;
        entry.before = last;
        entry.after = this.tail;
        this.tail.before = entry;
    }
}

public class Entry {
    Entry before;
    Entry after;
    int value;
    int key;

    Entry (int key, int value) {
        this.key = key;
        this.value = value;
        this.before = null;
        this.after = null;
    }    
}
