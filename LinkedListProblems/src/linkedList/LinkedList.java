package linkedList;

public class LinkedList {
    Node head;
    Node end;

    public LinkedList() {};

    public LinkedList(Node head) {
        this.head = head;
        this.end = head;
    }

    public int size() {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            i++;
            temp = temp.next;
        }
        return i;
    }

    public LinkedList push(int newInt) {
        Node newNode = new Node(newInt);
        if (head == null) {
            head = newNode;
            end = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        return this;
    }

    public LinkedList pushToEnd(int newInt) {
        Node newNode = new Node(newInt);
        if (head == null) {
            push(newInt);
        }
        else {
            end.next = new Node(newInt);
            end = end.next;
        }
        return this;
    }

    public LinkedList buildTest() {
        push(1).push(2).push(4).push(3);
        // 3,4,2,1
        return this;
    }

    public int count(int searchFor) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.value == searchFor) {
                i++;
            }
            temp = temp.next;
        }
        return i;
    }

    public Integer getNth(int n) {
        if (n == 0 && head != null) {
            return head.value;
        }
        else {
            Node temp = head;
            int i = 0;
            while (temp != null && i < n) {
                temp = temp.next;
                i++;
            }
            return temp != null ? temp.value : null;
        }
    }

    public Integer pop() {
        Integer returnInt = null;
        if (head != null) {
            returnInt = head.value;
            head = head.next;
        }
        return returnInt;
    }

    public LinkedList insertNth(int newNo, int index) {
        if (index == 0) {
            push(newNo);
        }
        else {
            Node temp = head;
            int i = 0;
            while (temp != null && i < index - 1) {
                temp = temp.next;
                i++;
            }
            if (temp != null) {
                Node node = new Node(newNo, temp.next);
                temp.next = node;
            }
        }
        return this;
    }

    public LinkedList sortedInsert(int newNo) {
        Node temp = head;
        Node prev = null;
        while (temp != null && temp.value < newNo) {
            prev = temp;
            temp = temp.next;
        }
        if (prev != null) {
            Node node = new Node(newNo, temp);
            prev.next = node;
        }
        else {
            push(newNo);
        }
        return this;
    }

    public LinkedList insertSort() {
        LinkedList newList = new LinkedList();
        Node temp = head;
        while (temp != null) {
            newList.sortedInsert(temp.value);
            temp = temp.next;
        }
        head = newList.head;
        return this;
    }

    public LinkedList append(LinkedList list2) {
        Node temp = head;
        if (temp != null) {
            while (temp.next != null) {
                temp = temp.next;
            }
        }
        else {
            head = new Node(list2.pop());
            temp = head;
        }
        Integer newInt = list2.pop();
        while (newInt != null) {
            temp.next = new Node(newInt);
            temp = temp.next;
            newInt = list2.pop();
        }
        return this;
    }

    public void frontBackSplit(LinkedList list1, LinkedList list2) {
        int size = size();
        int half = size % 2 == 0 ? (size / 2) : (size / 2 + 1);
        int i = 1;
        while (i <= half) {
            list1.push(pop());
            i++;
        }
        while (i <= size) {
            list2.push(pop());
            i++;
        }
    }

    public LinkedList removeDuplicates() {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            prev = temp;
            temp = temp.next;
            while (temp != null && temp.value == prev.value) {
                prev.next = temp.next;
                temp = prev.next;
            }
        }
        return this;
    }

    public LinkedList moveNode(LinkedList list2) {
        Integer newInt = list2.pop();
        if (newInt != null) {
            push(newInt);
        }
        return this;
    }

    public LinkedList alternatingSplit(LinkedList list1, LinkedList list2) {
        // Integer newInt = pop();
        // while (newInt != null) {
        // list1.push(newInt);
        // newInt = pop();
        // if (newInt != null) {
        // list2.push(newInt);
        // }
        // newInt = pop();
        // }
        // return this;
        int i = 0;
        while (head != null) {
            if (i % 2 == 0) {
                list1.moveNode(this);
            }
            else {
                list2.moveNode(this);
            }
            i++;
        }
        return this;
    }

    public LinkedList shuffleMerge(LinkedList list1, LinkedList list2) {
        Integer newInt = pop();
        while (newInt != null) {
            newInt = pop();
        }
        int i = 0;
        while (list1.head != null && list2.head != null) {
            if (i % 2 == 0) {
                pushToEnd(list1.pop());
            }
            else {
                pushToEnd(list2.pop());
            }
            i++;
        }
        if (list1.head != null) {
            append(list1);
        }
        else if (list2.head != null) {
            append(list2);
        }
        return this;
    }

    public LinkedList sortedMerge(LinkedList list1, LinkedList list2) {
        Integer newInt = pop();
        while (newInt != null) {
            newInt = pop();
        }
        while (list1.head != null && list2.head != null) {
            if (list1.head.value < list2.head.value) {
                pushToEnd(list1.pop());
            }
            else {
                pushToEnd(list2.pop());
            }
        }
        if (list1.head != null) {
            append(list1);
        }
        else if (list2.head != null) {
            append(list2);
        }
        return this;
    }

    public LinkedList mergeSort() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        if (head != null) this.frontBackSplit(list1, list2);
        if (list1.head != null && list1.head.next != null) list1.mergeSort();
        if (list2.head != null && list2.head.next != null) list2.mergeSort();
        if (list1.head != null && list2.head != null) {
            sortedMerge(list1, list2);
        }
        return this;
    }

    public LinkedList sortedIntersect(LinkedList list1, LinkedList list2) {
        Node temp1 = list1.head;
        Node temp2 = list2.head;
        while (temp1 != null && temp2 != null) {
            if (temp1.value == temp2.value) {
                if (head == null || end.value != temp1.value) {
                    pushToEnd(temp1.value);
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else if (temp1.value < temp2.value) {
                temp1 = temp1.next;
            }
            else {
                temp2 = temp2.next;
            }
        }
        return this;
    }

    public LinkedList reverse() {
        Node prev = head;
        if (prev != null) {
            Node temp = prev.next;
            while (temp != null) {
                if (prev == head) {
                    prev.next = null;
                }
                Node temp2 = temp.next;
                temp.next = prev;
                prev = temp;
                temp = temp2;
                if (temp == null) {
                    head = prev;
                }
            }
        }
        return this;
    }

    public LinkedList recursiveReverse() {
        // if (head == null) return this;
        // LinkedList list = new LinkedList(head.next);
        // if (list.head == null) return this;
        // list = list.recursiveReverse();
        // head.next.next = head;
        // head.next = null;
        // head = list.head;
        // return this;
        if (head != null) {
            Node temp = head.next;
            if (temp != null) {
                LinkedList list = new LinkedList(temp);
                list.recursiveReverse();
                temp.next = head;
                head.next = null;
                head = list.head;
            }
        }
        return this;
    }

    public void listToString() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "-");
            temp = temp.next;
        }
        System.out.println();
    }
}
