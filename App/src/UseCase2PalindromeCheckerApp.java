public class UseCase2PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam";
        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Input : " + input);
            System.out.println("Is Palindrome? : true");
        } else {
            System.out.println("Input : " + input);
            System.out.println("Is Palindrome? : false");
        }
    }
}


