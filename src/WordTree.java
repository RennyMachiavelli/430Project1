public class WordTree {
    private WordNode root;

    public WordTree() {
        root = null;
    }

    public void insert(WordNode wordNode) {
        insertNode(root, wordNode);
    }

    public void insertNode(WordNode currentNode, WordNode wordNode) {
        if (currentNode == null)
            root = wordNode;

        else {
            if(currentNode.getWord().equals(wordNode.getWord()))
                currentNode.addPosition(wordNode.getPositions().get(0));
            else if (currentNode.getWord().length() == 1 || wordNode.getWord().length() == 1) {
                //if words are only 1 character long
                if (currentNode.getWord().length() == 1 && wordNode.getWord().length() != 1)
                    checkRight(currentNode, wordNode);
                else
                    checkLeft(currentNode, wordNode);
            }
            else if(currentNode.getWord().length() < wordNode.getWord().length())
                checkRight(currentNode, wordNode);
            else if(currentNode.getWord().length() > wordNode.getWord().length())
                checkLeft(currentNode, wordNode);
            //if second character of each word is the same check each letter until !=
            else {
                if(currentNode.getWord().charAt(1) == wordNode.getWord().charAt(1)) {
                    int i = 1;
                    while (currentNode.getWord().charAt(i) == wordNode.getWord().charAt(i))
                        i++;
                    //if current word < new word check if right of current is empty
                    if (currentNode.getWord().charAt(i) < wordNode.getWord().charAt(i))
                        checkRight(currentNode, wordNode);
                    else if (currentNode.getWord().charAt(i) > wordNode.getWord().charAt(i))
                        checkLeft(currentNode, wordNode);
                }
                //if current word is < new word
                else if (currentNode.getWord().charAt(1) < wordNode.getWord().charAt(1))
                    checkRight(currentNode, wordNode);
                    //if current word > new word
                else if (currentNode.getWord().charAt(1) > wordNode.getWord().charAt(1))
                    checkLeft(currentNode, wordNode);
            }
        }
    }

    private void checkRight(WordNode currentNode, WordNode wordNode) {
        if (currentNode.getRight() == null)
            currentNode.setRight(wordNode);
        else
            insertNode(currentNode.getRight(), wordNode);
    }

    private void checkLeft(WordNode currentNode, WordNode wordNode) {
        if (currentNode.getLeft() == null)
            currentNode.setLeft(wordNode);
        else
            insertNode(currentNode.getLeft(), wordNode);
    }

    public void display() {
        displayNode(root);
    }

    public void displayNode(WordNode currentNode) {
        if(currentNode == null)
            System.out.print("\nNo words in this tree");
        else {
            if(currentNode.getLeft() != null)
                displayNode(currentNode.getLeft());

            System.out.print("\n" + currentNode.getWord() + "\t");
            Object[] positions = currentNode.getPositions().toArray();
            for(int i = 0; i < positions.length; i++)
                System.out.print(positions[i] + ", ");

            if(currentNode.getRight() != null)
                displayNode(currentNode.getRight());
        }
    }
}
