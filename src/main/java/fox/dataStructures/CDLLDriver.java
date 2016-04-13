package fox.dataStructures;

import java.util.Scanner;

/**
 * Created by Kelly on 4/11/2016.
 */
public class CDLLDriver {

    // Create instance of CDLinkedList class
    static CDLinkedList<Integer> list = new CDLinkedList();

    static Scanner input = new Scanner(System.in);

    // Hold user input
    static Integer num, anotherNum;

    public static void main (String[] args) {

        // Get user input and test to see if the methods from CDLinkedList
        // are working correctly.

        addNums();

        getRemove();

        searchList();

        insert();
    }

    /**
     * The getNum method asks the user for numbers to add to the list
     * @return numbers to be added
     */
    public static Integer getNum() {

        System.out.println("Please enter a number to add to the list: ");

        num = input.nextInt();

        return num;
    }

    /**
     * The addNums method adds numbers to the list and displays the result
     */
    public static void addNums() {

        list.add(getNum());
        list.add(getNum());
        list.add(getNum());
        list.add(getNum());

        list.displayValues();
    }

    /**
     * The removeNum method asks the user for a number to remove from
     * the list.
     * @return number to be removed
     */
    public static Integer removeNum() {

        System.out.println("Please enter a number to remove from the list: ");

        num = input.nextInt();

        return num;
    }

    /**
     * The getRemove method removes a number from the list and displays the
     * result
     */
    public static void getRemove() {

        list.removeNode(removeNum());

        list.displayValues();
    }

    /**
     * The getSearch method asks the user for a number to search.
     * @return number to search for
     */
    public static Integer getSearch() {

        System.out.println("Please enter a number to search the list for: ");

        num = input.nextInt();

        return num;
    }

    /**
     * The searchList method searches the list and displays whether the
     * number was found or not.
     */
    public static void searchList() {

        list.searchValue(getSearch());

        list.displayValues();
    }

    /**
     * The getInsert method asks the user to enter two numbers. The second
     * number will be inserted after the first number.
     * @return an array of the two numbers
     */
    public static Integer[] getInsert() {

        System.out.println("Enter a number from the list that you want"
                + " to insert another number after: ");

        num = input.nextInt();

        System.out.println("Enter a number to insert: ");

        anotherNum = input.nextInt();

        return new Integer[] {num, anotherNum};
    }

    /**
     * The insert method inserts the second number after the first number
     * and displays the result
     */
    public static void insert() {

        Integer[] ret = getInsert();

        list.insertAfterNode(ret[0], ret[1]);

        list.displayValues();
    }
}
