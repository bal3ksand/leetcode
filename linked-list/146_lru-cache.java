/* https://leetcode.com/problems/lru-cache/ */

class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int maxCapacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, (float) 0.75, true);
        maxCapacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key))
            return cache.get(key);
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if (!cache.containsKey(key) && cache.size() == maxCapacity) {
            Iterator iter = cache.keySet().iterator();
            iter.next();
            iter.remove();
        }
        cache.put(key, value);
    }
}