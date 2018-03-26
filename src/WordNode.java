import java.util.ArrayList;

public class WordNode {
    private String word;
    private WordNode left, right;
    private ArrayList<Integer> positions =  new ArrayList<>();

    public WordNode(String word, WordNode left, WordNode right, int position) {
        this.word = word;
        this.left = left;
        this.right = right;
        positions.add(position);
    }

    public WordNode(String word, int position) {
        this.word = word;
        left = null;
        right = null;
        positions.add(position);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public WordNode getLeft() {
        return left;
    }

    public void setLeft(WordNode left) {
        this.left = left;
    }

    public WordNode getRight() {
        return right;
    }

    public void setRight(WordNode right) {
        this.right = right;
    }

    public ArrayList<Integer> getPositions() {
        return positions;
    }

    public void addPosition(int n) {
        positions.add(n);
    }
}
