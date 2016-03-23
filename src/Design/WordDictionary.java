package Design;

public class WordDictionary {

    class WordNode {
        // Initialize your data structure here.
        WordNode[] children = new WordNode[26];
        Boolean isWord = false;

        public WordNode() {}
    }

    private WordNode root;

    public WordDictionary() {
        root = new WordNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        WordNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new WordNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] chars, int index, WordNode ws) {
        if (index == chars.length) {
            return ws.isWord;
        }
        char c = chars[index];
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                WordNode n = ws.children[i];
                if (n != null) {
                    if (search(chars, index + 1, n)) {//一定是index+1 ,因为要回来的
                        return true;
                    }
                }
            }
            return false;
        }
        WordNode node = ws.children[c - 'a'];
        return node != null && search(chars, ++index, node);
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".at"));
        wd.addWord("bat");
        System.out.println(wd.search(".at"));
        System.out.println(wd.search("an."));
        System.out.println(wd.search("a.d."));
        System.out.println(wd.search("b."));
        System.out.println(wd.search("a.d"));
        System.out.println(wd.search("."));
    }
}
