public class Node{
    int val;
    int key;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.val = val;
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    int cap;
    HashMap<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.cap = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.prev = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void insertAfterHead(Node node){
        Node current = this.head.next;
        this.head.next = node;
        node.prev = head;
        node.next = current;
        current.prev = node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            deleteNode(node);
            insertAfterHead(node);
            return cache.get(key).val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).val = value;
            Node node = cache.get(key);
            deleteNode(node);
            insertAfterHead(node);
        } else {
            if(cache.size() >= cap){
                Node lru = tail.prev;
                deleteNode(tail.prev);
                cache.remove(lru.key);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            insertAfterHead(node);
        }
    }
}
