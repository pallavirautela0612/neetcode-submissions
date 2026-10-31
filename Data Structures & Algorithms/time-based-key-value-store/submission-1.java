class TimeMap {

    Map<String, ArrayList<Timestamp>> map;
    public TimeMap() {

        map = new HashMap<>();       
    }
    
    public void set(String key, String value, int timestamp) {

        if (!map.containsKey(key)) {

            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Timestamp(timestamp, value));
    }
    
    public String get(String key, int timestamp) {

        if (map.containsKey(key)) {

            return findTimestampValue(map.get(key), timestamp);
        }
        return "";
    }

    // Binary Search bcz timestamps will be stored in ascending order
    private String findTimestampValue(ArrayList<Timestamp> list, int timestamp) {

        int left = 0; int right = list.size() -1;
        int possibleIdx = -1;

        while (left <= right) {

            int mid = left + (right - left)/2;
            if (list.get(mid).getTime() <= timestamp) {

                possibleIdx = mid;
                left = mid +1;
            } else {

                right = mid -1;
            }
        }

        String value = (possibleIdx == -1) ? "" : list.get(possibleIdx).getValue();
        return value;
    }
}

class Timestamp{

    int time;
    String value;

    public Timestamp(int time, String value) {
        
        this.time = time;
        this.value = value;
    }

    public int getTime() {

        return this.time;
    }

    public String getValue() {

        return this.value;
    }
}
