public class LetterNode {
    private char key;
    private WordTree data;
    private LetterNode left, right;

    public LetterNode(char key, WordTree data, LetterNode left, LetterNode right) {
        this.key = key;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public LetterNode(char key, WordTree data) {
        this.key = key;
        this.data = data;
        left = null;
        right = null;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public WordTree getData() {
        return data;
    }

    public void setData(WordTree data) {
        this.data = data;
    }

    public LetterNode getLeft() {
        return left;
    }

    public void setLeft(LetterNode left) {
        this.left = left;
    }

    public LetterNode getRight() {
        return right;
    }

    public void setRight(LetterNode right) {
        this.right = right;
    }
}
