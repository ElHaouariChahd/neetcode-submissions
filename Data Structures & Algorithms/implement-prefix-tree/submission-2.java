

class PrefixTree {
    private static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean end = false;
        int count = 0;
    }

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        if (search(word)) return;           
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
            node.count++;
        }
        node.end = true;
    }

    private TrieNode find(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) return null;      
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.end;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }
}