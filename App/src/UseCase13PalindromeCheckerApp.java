/*
 * MAIN CLASS - UseCase13PerformanceComparisonApp
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of salience estimation algorithms.
 *
 * At this stage, the application:
 * - Uses a salience strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * This use case focuses purely on performance
 * measurement and algorithm comparison.
 *
 * The goal is to introduce benchmarking concepts.
 *
 * Author: Developer
 * Version: 1.0
 */

import java.util.*;
public class UseCase13PalindromeCheckerApp {
    public static boolean StackPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }
        return input.equals(reversed);
    }

    public static boolean dequePalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
        deque.addLast(c);
        }
        while(deque.size()>1){
            if(deque.removeFirst()!=deque.removeLast()){
                return false;
        }
    }
        return true;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();

        long startstack=System.nanoTime();
        boolean stackresult=StackPalindrome(input);
        long endstack=System.nanoTime();

        long startdeque=System.nanoTime();
        boolean dequeresult=dequePalindrome(input);
        long endsdeque=System.nanoTime();

        System.out.println("Stack Result: "+stackresult);
        System.out.println("stack Execution Time: "+(endstack-startstack)+"ns");
        System.out.println("Deque Result "+dequeresult);
        System.out.println("deque Execution Time: "+(endsdeque-startdeque)+"ns");
        sc.close();
    }
}