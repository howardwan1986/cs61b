public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> worddeque = new ArrayDeque<Character>();

        for (int i = 0; i < word.length(); i++) {
            worddeque.addLast(word.charAt(i));
        }

        return worddeque;
    }


    private boolean isPalindrome (Deque<Character> worddeque) {
        if (worddeque.size() <= 1) {
            return true;
        }

        return worddeque.removeFirst() == worddeque.removeLast() && isPalindrome(worddeque);

    }

    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(word.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
