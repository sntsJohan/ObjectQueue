// Johan Santos CS22S1
// Laboratory 4.2 | Another Methods of Queue

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class ObjectQueueMethods {
    private ArrayList<Object> originalQueue;
    private ArrayList<Object> queue;
    private int size;
    
    
    // set the size of the queue
    public ObjectQueueMethods(int size) {
        this.size = size;
        queue = new ArrayList<Object>(size);
    }
    
    // add method
    public void queueAdd(Object item) {
        if (queue.size() < size) {
            queue.add(item);
        } else {
            System.out.println("Cannot add element, Queue is currently full");
        }
    }
    
    // remove method
    public Object queueRemove() {
        if (queue.isEmpty() == true) {
            System.out.println("Queue is empty");
            return null;
        } else {
            return queue.remove(0);
        }
    }

    // prints the queue (mas malinis na po pagprint dito compared sa 1st program :))
    public void display() {
        System.out.print("[");
            for (int i = 0; i < queue.size(); i++) {
                System.out.print(queue.get(i));
                if (i != queue.size() - 1) {
                System.out.print(", ");
        }
    }
    System.out.println("]");
    }

    // gets the last element in the queue (the element in the last index)
    public Object getLast() {
        if (queue.isEmpty() == true) {
            System.out.println("Queue is empty");
            return null;
        } else {
            return queue.get(queue.size() - 1);
        }
    }
    
    // reverse the order of the elements within the queue
     public void reverse() {
        for (int i = 0; i < queue.size() / 2; i++) {
            int j = queue.size() - i - 1;
            Object temp = queue.get(i);
            queue.set(i, queue.get(j));
            queue.set(j, temp);
        }
    }
    
     // sorts the queue using bubble sort
     public void sort() {
        int n = queue.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Comparable<Object> current = (Comparable<Object>)queue.get(j);
                Comparable<Object> next = (Comparable<Object>)queue.get(j + 1);
                if (current.compareTo(next) > 0) {
                    Object temp = queue.get(j);
                    queue.set(j, queue.get(j + 1));
                    queue.set(j + 1, temp);
                }
            }
        }
    }
    
    // shuffle the elements in the queue
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < queue.size(); i++) {
            int randomIndex = rand.nextInt(queue.size());
            Object temp = queue.get(i);
            queue.set(i, queue.get(randomIndex));
            queue.set(randomIndex, temp);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // takes the size of the queue from the user input
        System.out.print("Enter size of the queue: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        ObjectQueueMethods queue = new ObjectQueueMethods(size);
        ObjectQueueMethods originalQueue = new ObjectQueueMethods(size);
        
        // takes the elements of the queue from the user input
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element #" + (i + 1) + ": ");
            String input = scanner.nextLine();
            queue.queueAdd(input);
            originalQueue.queueAdd(input);
        }
        
        // allows the user to manipulate the queue through inputs
        int choice = 0;
        do {
            System.out.println("\nSelect an option:");
            System.out.println("[1] Reverse the elements in the Queue");
            System.out.println("[2] Sort the queue using Bubble Sort");
            System.out.println("[3] Randomize/Shuffle the position of the elements in the queue");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                // Reverses the order of the elements within the queue
                case 1:
                    queue.reverse();
                    System.out.println("Queue reversed.");
                    System.out.println("\nThe updated Queue is : ");
                    queue.display();
                    break;
                case 2:
                // Sorts the queue using bubble sort algorithm
                   queue.sort();
                   System.out.println("\nThe sorted Queue is : ");
                   queue.display();
                    break;
                case 3:
                // Shuffles the elements within the queue
                    queue.shuffle();
                    System.out.println("Queue shuffled.");
                    System.out.println("\nThe updated Queue is : ");
                    queue.display();
                    break;
                case 0:
                // Stops the program
                    break;
                default:
                // Shows when user inputs an invalid command.
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
        // terminate scanner
        scanner.close();
    }
}