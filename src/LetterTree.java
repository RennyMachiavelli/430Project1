public class LetterTree {
    private LetterNode root;

    public LetterTree() {
        root = null;
    }

    public void insert(LetterNode letterNode) {
        insert(root, letterNode);
    }

    public void insert(LetterNode currentNode, LetterNode letterNode) {
        if(currentNode == null)
            root = letterNode;
        else {
            if(currentNode.getKey() < letterNode.getKey()) {
                if(currentNode.getRight() == null)
                    currentNode.setRight(letterNode);
                else
                    insert(currentNode.getRight(), letterNode);
            }
            else {
                if(currentNode.getLeft() == null)
                    currentNode.setLeft(letterNode);
                else
                    insert(currentNode.getLeft(), letterNode);
            }
        }
    }

    public void display() {
        display(root);
    }

    public void display(LetterNode currentNode) {
        if (currentNode == null)
            System.out.println("The tree is empty");
        else {
            if (currentNode.getLeft() != null)
                display(currentNode.getLeft());

                System.out.print(Character.toUpperCase(currentNode.getKey()));
                currentNode.getData().display();
                System.out.println();

            if (currentNode.getRight() != null)
                display(currentNode.getRight());
        }
    }
}
