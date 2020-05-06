class LRUCache {
    private Map<Integer,Node> map;
    int cache_capacity;
    Node head = new Node();
    Node tail = new Node();
    
    LRUCache(int capacity){
        this.cache_capacity = capacity;
        map = new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key){
        int result = -1;
        if(map.containsKey(key)){
            Node node = map.get(key);
            result = node.value;
            remove(node);
            add(node);
        }
        return result;
    }
    
    public void put(int key, int value){
        Node node = map.get(key);
        if(node != null){
            //we need to first remove the element and then add 
            //because hashmaps are unordered so we need to maintain that
            //so that the element comes in front of the linkedlist
            remove(node);
            node.value = value;
            add(node);
        }else{
            Node new_node = new Node();
            new_node.value = value;
            new_node.key = key;
            if(map.size() == cache_capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            map.put(key,new_node);
            add(new_node);
        }
    }
    
    //first get rid of the easy functionalities
    private void add(Node node){
        //need to add to the head of the node
        Node head_next = head.next;
        
        head.next = node;
        node.prev = head;
        node.next = head_next;
        head_next.prev = node;
        
    }
    private void remove(Node node){
        Node node_next = node.next;
        Node node_prev = node.prev;
        
        node_prev.next = node_next;
        node_next.prev = node_prev;
    }
}

class Node{
    int key;
    int value;
    Node prev;
    Node next;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */