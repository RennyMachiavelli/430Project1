public class WordTree {
    private WordNode root;
    private int words = 0, distinctWords = 0;

    public WordTree() {
        root = null;
    }

    public void insert(WordNode wordNode) {
        insert(root, wordNode);
    }

    public void insert(WordNode currentNode, WordNode wordNode) {
        words++;
        if (currentNode == null)
            root = wordNode;
        else {
            //if words are equal add position to WordNode ArrayList
            if (currentNode.getWord().equals(wordNode.getWord()))
                currentNode.addPosition(wordNode.getPositions().get(0));
            //checks to see if words are not equal in length
            else if (currentNode.getWord().length() != wordNode.getWord().length()) {
                //if current word is 1 letter then we know that word node > current word
                if(currentNode.getWord().length() == 1)
                    checkRight(currentNode, wordNode);
                //if word node length = 1 then we know that current node length is greater
                else if(wordNode.getWord().length() == 1)
                    checkLeft(currentNode, wordNode);
                else {
                    int i = 1;
                    boolean done = false;
                    while (!done && i < Math.min(currentNode.getWord().length(), wordNode.getWord().length())) {
                        if (currentNode.getWord().charAt(i) < wordNode.getWord().charAt(i)) {
                            checkRight(currentNode, wordNode);
                            done = true;
                        } else if (currentNode.getWord().charAt(i) > wordNode.getWord().charAt(i)) {
                            checkLeft(currentNode, wordNode);
                            done = true;
                        }
                        i++;
                    }
                }
            }
            else {
                //if words are equal length compare each element until one is less than or greater than the other
                int i = 1;
                while (i < currentNode.getWord().length()) {
                    if (currentNode.getWord().charAt(i) < wordNode.getWord().charAt(i)) {
                        checkRight(currentNode, wordNode);
                        i = currentNode.getWord().length();
                    } else if (currentNode.getWord().charAt(i) > wordNode.getWord().charAt(i)) {
                        checkLeft(currentNode, wordNode);
                        i = currentNode.getWord().length();
                    }
                    i++;
                }
            }
        }
    }

    private void checkRight(WordNode currentNode, WordNode wordNode) {
        if (currentNode.getRight() == null) {
            currentNode.setRight(wordNode);
            distinctWords++;
        }
        else
            insert(currentNode.getRight(), wordNode);
    }

    private void checkLeft(WordNode currentNode, WordNode wordNode) {
        if (currentNode.getLeft() == null) {
            currentNode.setLeft(wordNode);
            distinctWords++;
        }
        else
            insert(currentNode.getLeft(), wordNode);
    }

    public void display() {
        display(root);
    }

    public void display(WordNode currentNode) {
        if(currentNode == null)
            System.out.print("\nNo words in this tree");
        else {
            if(currentNode.getLeft() != null)
                display(currentNode.getLeft());

            System.out.print("\n" + currentNode.getWord() + "\t");
            Object[] positions = currentNode.getPositions().toArray();
            for(int i = 0; i < positions.length; i++)
                System.out.print(positions[i] + ", ");

            if(currentNode.getRight() != null)
                display(currentNode.getRight());
        }
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public int getDistinctWords() {
        return distinctWords;
    }

    public void setDistinctWords(int distinctWords) {
        this.distinctWords = distinctWords;
    }
}
