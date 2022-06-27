class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key); /*store the value*/
            remove(node); /*remove the node from the tail*/
            insert(node); /*insert right after head*/
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key)); /*this becomes my last recently used*/
        }
        if(map.size()==capacity){
            remove(tail.prev);  /*if capacty is full remove from thetail*/
        }
        insert(new Node(key,value)); /*insert after head*/
    }
    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insert(Node node){
        map.put(node.key,node);
        Node newHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = newHead;
        newHead.prev = node;
    }

    class Node {
        Node next, prev;
        int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
