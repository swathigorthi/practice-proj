package linkedList;

public class Main {
    public static void main(String[] args) {
        // LinkedList list = new LinkedList().buildTest();// 3,4,2,1
        // list.push(2);
        // list.listToString();
        // System.out.println("no.of 2's:" + list.count(2)); // 2,3,4,2,1
        // System.out.println("Element at index 2:" + list.getNth(2));
        // System.out.println("pop:" + list.pop());// 3,4,2,1
        // list.listToString();
        // System.out.println("element at index 2:" + list.getNth(2));
        // list.listToString();
        // list.insertNth(5, 2);// 34521
        // list.listToString();
        // list.insertSort();
        // list.listToString();
        // LinkedList list2 = new LinkedList();
        // list2.push(10).push(20);
        // list.append(list2);
        // list.listToString();
        // list2.listToString();
        // LinkedList list3 = new LinkedList();
        // LinkedList list4 = new LinkedList();
        // list.frontBackSplit(list3, list4);
        // System.out.println("list:");
        // list.listToString();
        // System.out.println("list3:");
        // list3.listToString();
        // System.out.println("list4:");
        // list4.listToString();
        // // LinkedList list = new LinkedList();
        // // list.push(4).push(3).push(1);
        // // list.sortedInsert(2);
        // // list.listToString();
        // // list.sortedInsert(0);
        // // list.listToString();
        // // list.sortedInsert(5);
        // // list.listToString();
        // LinkedList list = new LinkedList();
        // list.push(2);
        // list.push(2);
        // list.push(1);
        // list.push(1);
        // list.push(1);
        // list.listToString();
        // list.removeDuplicates();
        // list.listToString();
        // LinkedList list1 = new LinkedList();
        // LinkedList list2 = new LinkedList();
        // list1.buildTest();
        // list2.buildTest();
        // list1.moveNode(list2);
        // list1.listToString();
        // list2.listToString();
        // LinkedList list = new LinkedList().buildTest();
        // list.push(5);
        // list.listToString();
        // LinkedList list1 = new LinkedList();
        // LinkedList list2 = new LinkedList();
        // list.alternatingSplit(list1, list2);
        // list.listToString();
        // list1.listToString();
        // list2.listToString();
        // LinkedList list = new LinkedList();
        // list.pushToEnd(4);
        // list.pushToEnd(5);
        // list.listToString();
        // System.out.println(list.head.value);
        // System.out.println(list.end.value);
        // list.push(5);
        // System.out.println(list.head.value);
        // System.out.println(list.end.value);
        // list.listToString();
        // LinkedList list1 = new LinkedList();
        // list1.push(1).push(3).push(2);
        // list1.listToString();
        // LinkedList list2 = new LinkedList();
        // list2.push(10).push(15).push(21).push(31).push(41);
        // list2.listToString();
        // LinkedList list = new LinkedList();
        // list.shuffleMerge(list1, list2);
        // list.listToString();
        // Node node = new Node(5);
        // System.out.println(node.value);
        // changeNode(node);
        // System.out.println(node.value);
        // LinkedList list = new LinkedList();
        // list.push(3).push(5).push(1).push(6).push(2);
        // list.listToString();
        // list.mergeSort();
        // list.listToString();
        // LinkedList list1 = new LinkedList();
        // list1.push(5).push(4).push(3).push(3).push(2).push(1);
        // list1.listToString();
        // LinkedList list2 = new LinkedList();
        // list2.push(6).push(3).push(3).push(1);
        // list2.listToString();
        // LinkedList list = new LinkedList();
        // list.sortedIntersect(list1, list2);
        // list.listToString();
        LinkedList list = new LinkedList();
        list.push(5).push(4).push(3).push(2).push(1);
        list.listToString();
        list.recursiveReverse();
        list.listToString();
    }

    public static void changeNodeValue(Node A) {
        A.value = 5;
    }

    public static void changeNodeNext(Node A) {
        A.next = new Node(10);
    }

    public static void changeNode(Node A) {
        A = new Node(10);
    }
}
