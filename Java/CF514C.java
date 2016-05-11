import java.util.*;

/**
 * Created by markdaniel on 4/19/16.
 */
public class CF514C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numWords = sc.nextInt();
        int numQueries = sc.nextInt();

        Trie trie = new Trie();

        sc.nextLine();

        for (int i = 0; i < numWords; i ++) {
            trie.insertWord(sc.nextLine());
        }

        for (int i = 0; i < numQueries; i ++) {
            System.out.println(trie.queryWord(sc.nextLine()));
        }
    }

    public static class TrieNode {
        boolean isWord;
        Map<Integer, TrieNode> children;
        public TrieNode() {
            isWord = false;
            children = new HashMap<>();
        }
    }

    public static class Trie {
        TrieNode root;
        String wordInserting;
        String queriedWord;
        Set<String> insertedWords;
        Map<String, Boolean> queriedWords;

        public Trie() {
            root = new TrieNode();
            insertedWords = new HashSet<>();
            queriedWords = new HashMap<>();
        }

        public void insertWord(String word) {
            if (insertedWords.contains(word)) {
                return;
            } else {
                insertedWords.add(word);
            }
            wordInserting = word;
            insert(root, 0);
        }

        public void insert(TrieNode node, int start) {
            if (start == wordInserting.length()) {
                node.isWord = true;
                return;
            }

            int letterIndex = wordInserting.charAt(start) - 'a';
            if (!node.children.containsKey(letterIndex)) {
                node.children.put(letterIndex, new TrieNode());
            }

            insert(node.children.get(letterIndex), start + 1);
        }

        public String queryWord(String word) {
            // Optimizing for the cases where many queries are repeated
            if (queriedWords.containsKey(word)) {
                return queriedWords.get(word) ? "YES" : "NO";
            }

            queriedWord = word;
            boolean res = query(this.root, 0, false);
            queriedWords.put(queriedWord, res);

            return res ? "YES" : "NO";
        }

        public boolean query(TrieNode node, int start, boolean penalized) {
            if (start == queriedWord.length()) {
                return (node.isWord && penalized);
            }

            int letterIndex = queriedWord.charAt(start) - 'a';
            for (int i = 0; i < 3; i ++) {
                if (node.children.containsKey(i)) {
                    if (i == letterIndex && query(node.children.get(i), start + 1, penalized)) {
                        return true;
                    } else if (i != letterIndex && !penalized && query(node.children.get(i), start + 1, true)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
