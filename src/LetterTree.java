public class LetterTree {
    private LetterNode root;

    public LetterTree() {
        root = null;
    }

    public void insert(LetterNode letterNode) {
        insertNode(root, letterNode);
    }

    public void insertNode(LetterNode currentNode, LetterNode letterNode) {
        if(currentNode == null)
            root = letterNode;
        else {
            if(currentNode.getKey() < letterNode.getKey()) {
                if(currentNode.getRight() == null)
                    currentNode.setRight(letterNode);
                else
                    insertNode(currentNode.getRight(), letterNode);
            }
            else {
                if(currentNode.getLeft() == null)
                    currentNode.setLeft(letterNode);
                else
                    insertNode(currentNode.getLeft(), letterNode);
            }
        }
    }

    public void display() {
        displayNode(root);
    }

    public void displayNode(LetterNode currentNode) {
        if (currentNode == null)
            System.out.println("The tree is empty");
        else {
            if (currentNode.getLeft() != null)
                displayNode(currentNode.getLeft());

                System.out.print(Character.toUpperCase(currentNode.getKey()));
                currentNode.getData().display();
                System.out.println();

            if (currentNode.getRight() != null)
                displayNode(currentNode.getRight());
        }
    }
}
