class MinStack {

    Node head;

    public MinStack() {
        
        head = null;
    }
    
    public void push(int val) {

        if (head == null) {

            Node node = new Node(val, val);
            head = node;
        } else {

            Node node = new Node(val, Math.min(val, head.minVal));
            node.next = head;
            head = node;
        }
    }
    
    public void pop() {

        head = head.next;
    }
    
    public int top() {

        return head.val;
    }
    
    public int getMin() {

        return head.minVal;
    }
}

class Node {

    int val;
    int minVal;
    Node next;

    public Node(int val, int minVal) {

        this.val = val;
        this.minVal = minVal;
        this.next = null;
    }
}
