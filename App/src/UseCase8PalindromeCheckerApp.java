import java.util.LinkedList;

public class UseCase8PalindromeCheckerApp {

    // ── Inner Node class for singly linked list ──────────────────────────────
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // ── Build a singly linked list from the input string ─────────────────────
    static Node buildLinkedList(String input) {
        Node head = null;
        Node tail = null;

        for (char c : input.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // ── Find the middle node using fast & slow pointer technique ─────────────
    // Slow moves 1 step, fast moves 2 steps.
    // When fast reaches the end, slow is at the middle.
    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // 1 step
            fast = fast.next.next;  // 2 steps
        }
        return slow; // middle node
    }

    // ── Reverse a linked list in-place and return the new head ───────────────
    static Node reverseList(Node head) {
        Node prev    = null;
        Node current = head;

        while (current != null) {
            Node nextNode  = current.next; // save next
            current.next   = prev;         // reverse link
            prev           = current;      // advance prev
            current        = nextNode;     // advance current
        }
        return prev; // new head (was the last node)
    }

    // ── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // Define the input string
        String input = "level";

        // Create a LinkedList to store characters
        LinkedList<Character> list = new LinkedList<>();

        // Add each character to the linked list
        for (char c : input.toCharArray()) {
            list.add(c);
        }

        // Flag to track palindrome state
        boolean isPalindrome = true;

        // Compare until only one or zero elements remain
        while (list.size() > 1) {
            char first = list.removeFirst(); // front character
            char last  = list.removeLast();  // rear character

            if (first != last) {
                isPalindrome = false;
                break;
            }
        }

        // Display the result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}


