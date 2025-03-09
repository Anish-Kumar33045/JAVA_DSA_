
/*
 *   trie comes from word RETRIVAL
 *  the main purpose of data structure is to retrieve stored information very fast
 *  
 * application of trie:
 *  auto complete words on typing in google
 *  search contacts in phone
 *  spell checking
 *  
 *  Trie Node ->
 *  trieNode in trie represents a single alphabet of word.
 * 
 *  TrieNode[] children // refers to other TrieNodes in Trie, 
    //   also called as child nodes of trieNode 
    // size of arr is 26 for english alphabets

     boolean isWord // boolean value to indicate the end of word
      // the value is set as true when the word inserted completly

      char a ='a'; a -> 97 Ascii value
      char z = 'z' z-'a' -> 25 similarly all
 */
public class Trie {

    private TrieNode root;
    
    public Trie(){
        root = new TrieNode(); // root is empty
    }

    private class TrieNode{
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public void insert(String word){
        if(word == null || word.isEmpty()){
            throw new IllegalArgumentException("Invalid input");
        }
        word = word.toLowerCase();
        TrieNode current = root;
        for(int i = 0; i <word.length(); i++){
           char c = word.charAt(i);
           int index = c-'a';
           if(current.children[index] ==null){
            TrieNode node = new TrieNode();
             current.children[index] = node;
             current = node;
           } else{
            current = current.children[index];
           }
        }
        current.isWord = true;
    }

    public  boolean search(String word){
        return false;
   }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cab");
        trie.insert("son");
        trie.insert("so");
        System.out.println("values inserted sucessfully !!!");
    }

}
