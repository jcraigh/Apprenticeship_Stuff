package training.Lists;

public class MyLinkedList {

    Node head;

    public static void main(String args[]) {
        MyLinkedList list = new MyLinkedList();
        list = insert(list, "This is head");
        list = insert(list, "part of list");
        list = insert(list, "Hope this works");
        list = insert(list, "last");

        printList(list);

        size(list);

        Node lastNode = getLast(list);
        System.out.println("\nThe last node in the list is: " + lastNode.data);

        Node searched = search(list, "Hope this works");
        System.out.println("\nThis is the searched node: " + searched.data);

        list = delete(list, "Hope this works");

        printList(list);

        size(list);
    }

    static class Node {
        String data;
        Node nextNode;

        Node(String d) {
            data = d;
            nextNode = null;
        }
    }

    public static MyLinkedList insert(MyLinkedList list, String data) {
        Node newNode = new Node(data);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.nextNode != null) {
                last = last.nextNode;
            }

            last.nextNode = newNode;
        }

        return list;
    }

    public static void printList(MyLinkedList list) {
        System.out.println("\nThis is all thats in the list:");
        Node currentNode = list.head;

        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.nextNode;
        }
    }

    public static Node getLast(MyLinkedList list) {
        Node currentNode = list.head;

        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    public static MyLinkedList delete(MyLinkedList list, String data) {
        if (list.head.data == data) {
            list.head = list.head.nextNode;
            return list;
        }
        Node currentNode = list.head;

        while (currentNode.nextNode.data != data) {
            if (currentNode.nextNode == null) {
                return null;
            }
            currentNode = currentNode.nextNode;

        }

        currentNode.nextNode = currentNode.nextNode.nextNode;
        return list;
    }

    public static Node search(MyLinkedList list, String data) {
        Node currentNode = list.head;

        while (currentNode.data != data) {
            if (currentNode.nextNode == null) {
                return null;
            }
            currentNode = currentNode.nextNode;

        }

        return currentNode;
    }

    public static void size(MyLinkedList list) {
        int s = 0;
        if (list.head == null) {
            s = 0;
        } else {
            Node currentNode = list.head;
            s = 1;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
                s++;
            }
        }
        System.out.println("\nThe list size is " + s);
    }
}
