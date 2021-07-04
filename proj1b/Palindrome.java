public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> result = new ArrayDeque<>();
        for(int i = 0; i < word.length(); ++i) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    /*iterater


    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = new ArrayDeque<>();
        wordDeque = wordToDeque(word);
        for(int i = 0, j = wordDeque.size() - 1; i < j; ++i, --j) {
            if(wordDeque.get(i) != wordDeque.get(j)){
                return false;
            }
        }
        return true;
    }
    */
    private boolean isPalindrome(Deque<Character> cDeque) {
        if(cDeque.isEmpty())
            return true;
        if(cDeque.removeFirst() == cDeque.removeLast() || cDeque.isEmpty())
            return isPalindrome(cDeque);
        return false;

    }
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<>();
        wordDeque = wordToDeque(word);
        return isPalindrome(wordDeque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = new ArrayDeque<>();
        wordDeque = wordToDeque(word);
        if(wordDeque.size() == 1 || wordDeque.size() == 0)
            return true;
        for(int i = 0, j = wordDeque.size() - 1; i < j; ++i, --j) {
            if(!cc.equalChars(wordDeque.get(i), wordDeque.get(j))) {
                return false;
            }
        }
        return true;
    }

}
