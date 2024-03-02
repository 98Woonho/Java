import java.util.Objects;

public class Tip_Main {
    public static void main(String[] args) {

    }
}

class Custom {
    private Custom custom;
    public Custom(Custom custom) {
        // 이렇게 했을 때 저장되는 값은?
        // >> 주어진 객체가 멤버변수로 저장됨
        // 그렇다면 객체가 통째로 저장이되나요?
        // >> 이미 메모리상 어딘가에 저장(힙 Heap)되어있으므로, 거기의 주소(참조 주소 Reference Address)만 여기에 저장
        // >> 외부로부터 전달받은 객체와 이 객체는 전혀 다른 힙으로 생성되어있고, 레퍼런스 주소만 전달됨(Pass by reference)
        this.custom = custom;

        // 값 전달(Pass by value) : 값을 복사해서 전달
        // 포인터 전달(Pass by pointer) : 포인터 주소를 전달(자바에서는 불가능, C언어 계통처럼 포인터를 사용할 수 있어야 함)
        //   >> 포인터(Pointer) ? 특정한 물리적 메모리 주소를 가리키는 값(Raw 개념)
        // 레퍼런스 전달(Pass by reference) : 레퍼런스 주소를 전달
        //   >> 레퍼런스(Reference) ? 객체를 가리키위해 JVM이 보유하고 있는 주소 값(물리적 주소보다 상위 개념)
        //
        // - 가비지 컬렉션(GC : Garbage Collection)
        // 이 레퍼런스에 대해 참조하고 있는 사실이 없는지
        // 가비지 컬렉터(Garbage Collector)가 GC 타임에 확인해서 없을 경우
        // 객체 파괴(Destroy)
    }
}



/**
 * 데이터 스트럭처 추상화 인터페이스 입니다.
 * @param <K> 위치 키 값의 타입
 */
interface DataStructure<K> {
    /**
     * 객체를 가져옵니다.
     * @param key 특정한 객체를 가리킬 위치 키 값
     * @return 탐색된 노드
     */
    Node<K> get(K key);

    /**
     * 자료구조의 끝에 노드를 추가합니다.
     * @param node 추가할 노드
     * @return 추가된 위치 키 값
     */
    K add(Node<K> node);

    /**
     * 특정한 위치에 노드를 추가합니다.
     * @param key 추가될 위치 키 값
     * @param node 추가할 노드
     */
    boolean add(K key, Node<K> node);

    /**
     * 노드를 삭제합니다.
     * @param node 삭제할 노드
     */
    void remove(Node<K> node);

    /**
     * 노드를 삭제합니다.
     * @param key 삭제할 노드의 위치 키 값
     */
    void removeByKey(K key);

    /**
     * 전체 노드를 삭제합니다.
     */
    void clear();

    /**
     * 추상화된 노드
     *
     * @param <K> 이 노드의 위치 값(`DataStructure`의 K와 동일하게 설정 필요)
     */
    interface Node<K> {
        K getKey();
        void setKey(K key);
    }
}
class DataStructureList implements DataStructure<Integer> {
    // >> Node Design
    // |               Value                    |
    // ------------------------------------------
    // | Next Instance Reference Address (Next) |
    //
    // >> List Design
    // | Value |    |----> | Value |    |----> | Value |    |----> ...
    // ---------    |      ---------    |      ---------    |
    // | Next  |----|      | Next  |----|      | Next  |----|

    // 구현방법 1. 배열을 이용해서 위의 구조를 만드는 방법
    //            >> 노드가 추가될 때마다 배열을 새로 생성할 필요가 있음
    //            >> 충분한 배열을 미리 선언할 것
    // 구현방법 2. 다른 자료구조를 이용해서 위의 구조를 만드는 방법
    //            >> 공간이 조금 차지할 수 있음(다른 자료구조에서 사용하는 공간)
    //            >> 사용할 다른 자료구조가 없다면, 구현할 수가 없음(미리 다른 자료구조 필요)
    //            >> 크기가 유동적이게 될 수 있음
    //            >> 비교적 구현하기가 간단함
    // 구현방법 3. 객체의 레퍼런스 주소를 이용해서 위의 구조를 만드는 방법
    //            >> 리스트 구현형식에 비해 비교적 구현하기가 까다로움
    //            >> 특별한 다른 자료구조가 필요없음

    // 순회 시 처음부터 찾을 객체 : 가장 맨 앞의 객체
    private Node<Integer> first = null;
    // 추가 시 마지막 객체
    private Node<Integer> last = null;

    @Override
    public Node<Integer> get(Integer key) {
        if(first == null) {
            return null;
        }
        ListNode current = (ListNode)first;
        // i: 0 1 2 3 4 5 6
        // c:       |
        while(current != null) {
            if(current.getKey() == key) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public Integer add(Node<Integer> node) {
        if(!validateNode(node)) {
            return 0;
        }

        if(last == null) {
            first = node;
            last = node;
        } else {
            ListNode listNode = (ListNode)last;
            listNode.setNext((ListNode)node);
            node.setKey(last.getKey() + 1);
            last = node;
        }
        return node.getKey();
    }

    @Override
    public boolean add(Integer key, Node<Integer> node) {
        if(!validateNode(node)) {
            return false;
        }

        if(last == null) {
            first = node;
            last = node;
        } else {
            ListNode listNode = (ListNode)last;
            // Last key : 5
            // node key : 6
            // 0 1 2 3 4

            //  i: 0 1 2 3 4 5 6
            //  r:       3
            // nj: 0 1 2   3 4 5 6
            // nj: 0 1 2   4 5 5 6
            Node<Integer> tmpNode = get(key-1);
            if(tmpNode == null) {
                // 마지막의 위치를 넘어선 경우
                // 일반적으로는 추가하지 않도록 구현됨
                return false;
            }

            ListNode findedNode = (ListNode)tmpNode;
            if(findedNode.getNext() == null) {
                // 다음 노드가 없을 경우 : 마지막 위치
                node.setKey(findedNode.getKey() + 1);
                findedNode.setNext((ListNode) node);
                last = node;
                return false;
            }

            // node.getKey() == 3
            // 3번째부터 각각 +1씩 키 값을 만들어줌
            // 0 1 2 3 4 5 6
            //       |
            // 0 1 2   4 5 6 7
            ListNode tmpFindedNode = findedNode.getNext();
            while(tmpFindedNode != null) {
                tmpFindedNode.setKey(tmpFindedNode.getKey() + 1);
                tmpFindedNode = tmpFindedNode.getNext();
            }

            // 기존 이전의 노드와 기존 이전의 노드 다음 노드 사이에 끼워넣음
            ListNode nextNode = findedNode.getNext();
            findedNode.setNext((ListNode)node);
            ((ListNode)node).setNext(nextNode);
            // 디펜스 코드 : 만에하나 잘못 오동작했다고 하더라도, 오류 방지를 해줄 것임
            if(((ListNode) node).getNext() == null){
                last = node;
            }
        }
        return true;
    }

    @Override
    public void remove(Node<Integer> node) {
        Node<Integer> existsNode = get(node.getKey()-1);
        if(existsNode == null) {
            // 삭제 대상 객체의 이전 객체가 없을 경우
            return;
        }
        ListNode previousNode = (ListNode)existsNode;
        // 삭제 대상 객체
        ListNode targetNode = previousNode.getNext();
        if(targetNode == null){
            // 삭제 대상 객체가 없을 경우
            return;
        }

        // 삭제 대상 객체가 존재할 경우
        // 삭제 대상만 꺼내줌
        ListNode nextNode = targetNode.getNext();
        if(nextNode != null) {
            // 키 값 정렬
            //  i : 0 1 2 3 4 5 6 7
            //  r :       3
            // nj : 0 1 2   4 5 6 7
            // nj : 0 1 2   3 4 5 6
            ListNode tmpNode = nextNode;
            while(tmpNode != null) {
                tmpNode.setKey(tmpNode.getKey() - 1);
                tmpNode = tmpNode.getNext();
            }

            previousNode.setNext(nextNode);
            nextNode.setNext(null);
        } else {
            previousNode.setNext(null);
            last = previousNode;
        }
    }

    @Override
    public void removeByKey(Integer key) {
        remove(new ListNode(key));
    }

    @Override
    public void clear() {
        if(first == null) {
            return;
        }
        ListNode current = (ListNode)first;
        while(current != null) {
            ListNode tmp = current.getNext();
            current.setNext(null);
            current = tmp;
        }
        first = null;
        last = null;
    }

    boolean validateNode(Node<Integer> node) {
        return node instanceof ListNode;
    }

    class ListNode implements Node<Integer> {
        private Integer mKey;
        private ListNode mNext;

        ListNode(Integer key) {
            this.mKey = key;
        }

        @Override
        public Integer getKey() { return mKey; }

        @Override
        public void setKey(Integer key) { this.mKey = key; }

        public ListNode getNext() { return mNext; }

        public void setNext(ListNode next) { this.mNext = next; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return Objects.equals(mKey, listNode.mKey);
        }

        @Override
        public int hashCode() {
            return Objects.hash(mKey);
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "mKey=" + mKey +
                    ", mNext=" + mNext +
                    '}';
        }
    }
}
