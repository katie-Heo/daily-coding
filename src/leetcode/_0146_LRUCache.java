package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0146_LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // LinkedList는 O(1)이 아니라서 사용못함.
    // 최신 사용한 값은 Tail에 offer addLast (최신사용한 값)
    // 지울 값은 Head removeFirst (오래된거)

    Map<Integer, Node> cache = new HashMap<>();
    int size;
    private final Node head; // 직후에 삭제하기위한 구분자
    private final Node tail; // 직전에 추가,

    public _0146_LRUCache(int capacity) {
        size = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // 기존에 있는 데이터는 순서를 보정한다.
        Node node = cache.get(key);
        if (node != null) {

            // 노드를 다음 노드로 연결하고, node를 tail에 add한다. moveToTail
            node.pre.next = node.next;
            node.next.pre = node.pre;

            // addTail
            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;

            return node.value;
        }
        // 기존에 없는것은 -1 리턴
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;

            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;
        } else {

            if (size == cache.size()) {
                //removeHead, addTail,
                //삭제시 다음 노드를 연결한다.

                Node delNode = head.next;
                delNode.pre.next = delNode.next;
                delNode.next.pre = delNode.pre;

                cache.remove(delNode.key);
            }

            // addTail
            Node newNode = new Node(key, value);
            newNode.pre = tail.pre;
            newNode.next = tail;
            tail.pre.next = newNode;
            tail.pre = newNode;
            cache.put(key, newNode);
        }
    }

}

//정답은 동일한 일을 하는 역할을 리펙토링하는것이지.

class LRUCache {

    // 1. Doubly Linked List의 노드 정의
    // key, value 외에 이전/다음 노드 포인터를 가집니다.
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 2. &#xD575;&#xC2EC; &#xC790;&#xB8CC;&#xAD6C;&#xC870; &#xC120;&#xC5B8;
    private final int capacity;
    // O(1) 탐색을 위한 HashMap. (Key, Node)를 저장합니다.
    private final Map<Integer, Node> map;

    // Doubly Linked List를 위한 dummy head와 tail.
    // 이 dummy 노드들 덕분에 head/tail이 null일 때의 엣지 케이스를 처리할 필요가 없어 코드가 깔끔해집니다.
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // dummy head, tail 초기화 및 연결
        this.head = new Node(0, 0); // key, value는 의미 없음
        this.tail = new Node(0, 0); // key, value는 의미 없음
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    // --- (A) Doubly Linked List 핵심 헬퍼 메서드 ---

    /**
     * 노드를 리스트에서 제거합니다. (O(1))
     * (이전 노드의 next)를 (다음 노드)로, (다음 노드의 prev)를 (이전 노드)로 연결합니다.
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 노드를 리스트의 맨 뒤(tail 직전)에 추가합니다. (O(1))
     * (가장 최근에 사용된 노드가 됨)
     */
    private void addNodeToTail(Node node) {
        // 1. 새 노드를 tail의 이전 노드와 tail 사이에 연결
        node.prev = tail.prev;
        node.next = tail;

        // 2. 기존 tail의 이전 노드가 새 노드를 가리키게 함
        tail.prev.next = node;

        // 3. tail이 새 노드를 가리키게 함
        tail.prev = node;
    }

    /**
     * 기존 노드를 맨 뒤로 이동시킵니다. (O(1))
     * (제거 + 맨 뒤에 추가)
     */
    private void moveToTail(Node node) {
        removeNode(node);
        addNodeToTail(node);
    }

    /**
     * 리스트의 맨 앞 노드(head 직후)를 제거하고 반환합니다. (O(1))
     * (가장 오래 사용된 노드(LRU)를 제거할 때 사용)
     */
    private Node removeHead() {
        // head.next가 null일 수 없습니다. (최소한 tail이 있음)
        Node lruNode = head.next;
        removeNode(lruNode);
        return lruNode;
    }

    // --- (B) LRUCache의 핵심 기능 구현 ---

    /**
     * get(key) : O(1)
     * 1. HashMap에서 key를 O(1)로 찾습니다.
     * 2. 찾은 노드를 '가장 최근에 사용'했으므로 리스트의 맨 뒤로 O(1)에 이동시킵니다.
     * 3. 값을 반환합니다.
     */
    public int get(int key) {
        // 1. HashMap에 키가 있는지 O(1) 확인
        Node node = map.get(key);

        if (node == null) {
            return -1; // 존재하지 않음
        }

        // 2. 존재한다면, '최근에 사용'했으므로 맨 뒤로 이동
        moveToTail(node);

        // 3. 값 반환
        return node.value;
    }

    /**
     * put(key, value) : O(1)
     */
    public void put(int key, int value) {
        // 1. HashMap에 키가 이미 존재하는지 O(1) 확인
        Node node = map.get(key);

        if (node != null) {
            // --- 시나리오 1: Key가 이미 존재 (갱신) ---

            // 1-1. 값(value)만 갱신
            node.value = value;

            // 1-2. '최근에 사용'했으므로 맨 뒤로 이동
            moveToTail(node);

        } else {
            // --- 시나리오 2: 새로운 Key (신규 삽입) ---

            // 2-1. (중요) 삽입 전, 캐시가 꽉 찼는지 확인
            if (map.size() == capacity) {
                // 2-1a. 꽉 찼다면, 가장 오래된 노드(LRU)를 제거
                Node lruNode = removeHead(); // 리스트에서 제거 (O(1))
                map.remove(lruNode.key);     // HashMap에서 제거 (O(1))
            }

            // 2-2. 새 노드를 생성
            Node newNode = new Node(key, value);

            // 2-3. 새 노드를 리스트의 맨 뒤(MRU)에 추가
            addNodeToTail(newNode);

            // 2-4. 새 노드를 HashMap에 추가
            map.put(key, newNode);
        }
    }
}