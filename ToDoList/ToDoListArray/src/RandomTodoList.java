import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomTodoList {
    private ArrayList<String> todoList;
    private ArrayList<String> completedItems;
    private Random random;
    private static int count =0;

    public RandomTodoList() {
        todoList = new ArrayList<>();
        completedItems = new ArrayList<>();
        random = new Random();

    }

    public void addTodoItem(String item) {
        todoList.add(item);
    }
    public void printListNow() {
        System.out.println("This is the Todo list");
        for (int k = 0; k < todoList.size(); k++) {
            System.out.println(k + todoList.get(k));
        }
        System.out.println("This is the completed list");
        for (int k=0; k< completedItems.size(); k++){
            System.out.println(k + completedItems.get(k));
        }
    }
    public void printRandomItem() {
        if (count == 1) {
            System.out.println("Todo list is empty!");
            System.out.println("You have completed all the tasks in your todo list!");
            System.out.println(count);
            System.exit(0);
            return;
        }



        String randomItem;
        do {
            randomItem = todoList.get(random.nextInt(todoList.size()));
        } while (completedItems.contains(randomItem));

        System.out.println("Random Todo Item: " + randomItem);
        completedItems.add(randomItem);
        todoList.remove(randomItem);
        count--;
        System.out.println(count);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RandomTodoList todoListManager = new RandomTodoList();

        System.out.println("Welcome to Random Todo List Manager!");
        System.out.println("Enter your todo list items (type 'done' to finish):");

        String input;
        while (true) {
            count++;
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            todoListManager.addTodoItem(input);
        }

        System.out.println("\nRandomly selected todo list items:");


        while (true) {
            // Print the todo list each time before asking for user input
            todoListManager.printListNow();
            System.out.println("\nEnter 'd' to get a random item, or 'exit' to quit:");


            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("d")) {
                todoListManager.printRandomItem();
            } else {
                System.out.println("Invalid command! Please enter 'print' or 'exit'.");
            }
        }

        System.out.println("\nThank you for using Random Todo List Manager!");
    }
}
