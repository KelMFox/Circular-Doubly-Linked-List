package fox.dataStructures;

/**
 * Created by Kelly on 4/11/2016.
 */
public class CDLinkedList<T> {

    private Node cursor;

    private int count;

    /**
     * Default Constructor
     */
    public CDLinkedList() {

        count = 0;
    }

    public boolean isEmpty() {

        return (count == 0);
    }

    public void add(T val) {

        Node<T> newNode = new Node(val);

        if (isEmpty()) {

            cursor = newNode;
            cursor.next = cursor;
            cursor.previous = cursor;

        } else {

            newNode.previous = cursor.previous;
            newNode.next = cursor;
            cursor.previous.next = newNode;
            cursor.previous = newNode;

        }
        count++;
    }

    public void insertAfterNode(T currentVal, T value) {

        Node<T> newNode = new Node(value);

        Node<T> currentNode = cursor;

        int i = 0;

        while (i < count) {

            if (currentNode.getValue().equals(currentVal)) {

                newNode.next = currentNode.next;
                newNode.previous = currentNode;
                currentNode.next = newNode;

                if (currentNode == cursor)

                    cursor = cursor.previous;

                count++;

                return;
            }
            currentNode = currentNode.next;
            i++;
        }
        System.out.println(currentVal + " is not in the list.");
    }

    public void removeNode(T val) {

        if (isEmpty()) {

            System.out.println("List is empty.");
        } else {

            Node<T> nodeToBeRemoved = cursor;

            int i = 0;

            while (i < count) {

                if (nodeToBeRemoved.getValue().equals(val)) {

                    Node<T> pred = nodeToBeRemoved.previous;
                    Node<T> succ = nodeToBeRemoved.next;

                    pred.next = succ;
                    succ.previous = pred;

                    if (nodeToBeRemoved == cursor)

                        cursor = cursor.next;

                    count--;

                    return;
                }

                i++;
                nodeToBeRemoved = nodeToBeRemoved.next;
            }
            System.out.println(val + " is not in the list.");
        }
    }

    public void displayValues() {

        Node<T> temp = cursor;

        int i = 0;

        System.out.println("List values: ");

        while (i < count) {

            System.out.println(temp.getValue());

            temp = temp.next;

            i++;
        }
    }

    public void searchValue(T val) {

        // Start at the "head" of the list
        Node<T> currentNode = cursor;

        int i = 0;

        // Iterate through the list until the specified element is found
        while (i < count) {

            if (currentNode.getValue().equals(val)) {

                System.out.println(currentNode.getValue() +
                        " was found");
                return;
            }

            currentNode = currentNode.next;
            i++;
        }
        System.out.println(val + " is not in the list.");
    }

    private class Node<T> {

        private final T val;
        private Node<T> next = null;
        private Node<T> previous = null;

        public Node(T val) {

            this.val = val;
        }

        public T getValue() {

            return this.val;
        }
    }
}

