class LRUCache {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);

        //Doubly linked list
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {

        if (map.containsKey(key)) {

            Node node = map.get(key);
            delete(node);
            add(node);

            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {

        Node node = new Node(key, value);

        if (map.containsKey(key)) {

            delete(map.get(key));
            map.remove(key);
        }

        if (map.size() >= capacity) {

            Node lastNode = tail.prev;
            delete(lastNode);
            map.remove(lastNode.key);
        }

        add(node);
        map.put(key, node);
    }

    private void add(Node node) {

        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    private void delete(Node node) {

        Node temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;

        node.next = null;
        node.prev = null;
    }
}

class Node {

    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
