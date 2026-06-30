class TimeMap {
    private static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<Entry>())
        .add(new Entry(timestamp, value));        
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Entry> list = map.get(key);
        int l = 0;
        int r = list.size() - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).value;
            } else if (list.get(mid).timestamp < timestamp) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans < 0 ? "" : list.get(ans).value;        
    }
}
