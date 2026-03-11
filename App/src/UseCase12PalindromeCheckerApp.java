/*
 * Main CLASS - UseCase12PalindromeCheckerApp
 * =============================================================================
 * Use Case 12: Strategy Pattern For Palindrome Algorithms
 * -----------------------------------------------------------------------------
 * Description:
 *
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 *
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete Stack based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * No performance comparison is done in this use case.
 * The focus is purely on algorithm interoperability
 *
 * The goal is to teach extensible algorithm design.
 *
 * @Author: Developer
 * @Version: 1.0
 */

import java.util.*;
interface PalindromeStrategy{
    boolean isPalindrome(String input);
}
class StackStrategy implements PalindromeStrategy{
    public boolean isPalindrome(String input){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<input.length();i++){
            stack.push(input.charAt(i));
        }
        String reversed="";
        while(!stack.isEmpty()){
            reversed+=stack.pop();
        }
        return input.equals(reversed);
    }
}
class DequeueStrategy implements PalindromeStrategy{
    public boolean isPalindrome(String input){
        Deque<Character> deque=new ArrayDeque<>();
for(char c:input.toCharArray()){ deque.addLast(c);
}while(deque.size()>1){
if(deque.removeFirst()!=deque.removeLast()){
return false;
}
}return true;
}
}
class PalindromeChecker{
private PalindromeStrategy strategy;
public PalindromeChecker(PalindromeStrategy strategy){
this.strategy=strategy;}
public boolean checkPalindrome(String input){return strategy.isPalindrome(input);
}}
public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Choose Strategy: ");
        System.out.println("1.Stack Strategy");
        System.out.println("2.Deque Strategy");
        int choice = sc.nextInt();
        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeueStrategy();
        }
        PalindromeChecker checker = new PalindromeChecker(strategy);
        if (checker.checkPalindrome(input)) {
            System.out.println("The string is Palindrome");
        } else {
            System.out.println("The string is not Palindrome");
        }
    }
}