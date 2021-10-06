/** 
 * Date: 2021-10-06
 * File Name: CollectionMain.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.two_dv600;

/***
 * Represent a demonstration of the classes ArrayIntStack and ArrayIntList
 */
public class CollectionMain {
    public static void main (String[] args) {
        demoArrayIntList();
        demoArrayIntStack();
    }

    /**
     * Demonstrates the ArrayInStack Class
     */
    public static void demoArrayIntStack() {
        ArrayIntStack arrayIntStack = new ArrayIntStack();

        StringBuilder stringBuilder = new StringBuilder("\nDemo For ArrayIntStack\n\n");

        stringBuilder.append("Adding 9 values to the new ArrayIntStack\n");
        addIntegersToCollection(9, arrayIntStack);
        stringBuilder.append("ArrayIntStack after adding 9 values: " + arrayIntStack + "\n");
        stringBuilder.append("Popping value from ArrayIntStack\n");
        stringBuilder.append("Popped value: " + arrayIntStack.pop() + "\n");
        stringBuilder.append("ArrayIntStack after using pop(): " + arrayIntStack + "\n");
        stringBuilder.append("Peeking at last value in ArrayIntStack\n");
        stringBuilder.append("Value from using peek(): " + arrayIntStack.peek() + "\n");
        stringBuilder.append("ArrayIntStack after using peek(): " + arrayIntStack + "\n");

        System.out.println(stringBuilder);
    }

    /**
     * Demonstrates the ArrayIntList Class
     */
    public static void demoArrayIntList() {
        ArrayIntList arrayIntList = new ArrayIntList();

        StringBuilder stringBuilder = new StringBuilder("\nDemo For ArrayIntList\n\n");

        //add()
        stringBuilder.append("Adding 9 values to the new ArrayIntList\n\n");
        addIntegersToCollection(9, arrayIntList);
        stringBuilder.append("ArrayIntList after adding 9 values: " + arrayIntList + "\n\n");
        //addAt()
        stringBuilder.append("Adding value 5 at index 3 in ArrayIntList\n\n");
        arrayIntList.addAt(5, 3);
        stringBuilder.append("ArrayIntList after using addAt(5,3): " + arrayIntList + "\n\n");
        //remove()
        stringBuilder.append("Removing value at index 2 in ArrayIntList\n\n");
        arrayIntList.remove(2);
        stringBuilder.append("ArrayIntList after using remove(2): " + arrayIntList + "\n\n");
        // get()
        stringBuilder.append("Getting value at index 5 in ArrayIntList\n\n");
        stringBuilder.append("The acquired value after using get(5) on ArrayIntList : " + arrayIntList.get(5) + "\n\n");
        //indexOf()
        stringBuilder.append("Finding index of value 7 in ArrayIntList\n\n");
        stringBuilder.append("The acquired index after using indexOf(7) on ArrayIntList : " + arrayIntList.indexOf(7) + "\n\n");
        //indexOf() index not in list
        stringBuilder.append("Finding index of a non existing value in ArrayIntList\n\n");
        stringBuilder.append("The acquired index after using indexOf(13) on ArrayIntList : " + arrayIntList.indexOf(13) + "\n\n");

        System.out.println(stringBuilder);
    }

    /**
     * Helper function that adds integers to the passed AbstractInCollection
     * @param numberOfIntegers How many integers to be added
     * @param collection The collection to add the integers to.
     */
    public static void addIntegersToCollection(int numberOfIntegers, AbstractIntCollection collection) {
        for (int i = 1; i <= numberOfIntegers; i++) {
            if (collection instanceof ArrayIntList) {
                ArrayIntList tempArrayIntList = (ArrayIntList)collection;
                tempArrayIntList.add(i);
            } else if(collection instanceof ArrayIntStack) {
                ArrayIntStack tempArrayIntStack = (ArrayIntStack)collection;
                tempArrayIntStack.push(i);
            }
        }
    }
}
