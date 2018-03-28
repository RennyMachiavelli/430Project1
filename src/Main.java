import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        LetterTree lt = new LetterTree();

        WordTree aTree = new WordTree();
        WordTree bTree = new WordTree();
        WordTree cTree = new WordTree();
        WordTree dTree = new WordTree();
        WordTree eTree = new WordTree();
        WordTree fTree = new WordTree();
        WordTree gTree = new WordTree();
        WordTree hTree = new WordTree();
        WordTree iTree = new WordTree();
        WordTree jTree = new WordTree();
        WordTree kTree = new WordTree();
        WordTree lTree = new WordTree();
        WordTree mTree = new WordTree();
        WordTree nTree = new WordTree();
        WordTree oTree = new WordTree();
        WordTree pTree = new WordTree();
        WordTree qTree = new WordTree();
        WordTree rTree = new WordTree();
        WordTree sTree = new WordTree();
        WordTree tTree = new WordTree();
        WordTree uTree = new WordTree();
        WordTree vTree = new WordTree();
        WordTree wTree = new WordTree();
        WordTree xTree = new WordTree();
        WordTree yTree = new WordTree();
        WordTree zTree = new WordTree();

        WordTree[] wordTrees = {aTree, bTree, cTree, dTree, eTree, fTree, gTree, hTree, iTree, jTree, kTree, lTree,
        mTree, nTree, oTree, pTree, qTree, rTree, sTree ,tTree, uTree, vTree, wTree, xTree, yTree, zTree};

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int nonBlankCharacters = 0, totalWords= 0;

        System.out.println("\nEnter the name of the file:");
        String fileName = keyboard.nextLine();

        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);

        System.out.println("Input File Name: " + fileName);

        StringBuilder sb = new StringBuilder(inputFile.nextLine());
        while(inputFile.hasNext()) {
            sb.append(inputFile.next() + " ");
        }
        for(int i = 0; i < sb.length(); i++) {
            if (!Character.isWhitespace(sb.charAt(i)))
                nonBlankCharacters++;
            if(Character.isDigit(sb.charAt(i))) {
                sb.deleteCharAt(i);
                i--;
            }
        }
        String originalStr = sb.toString();
        String str = originalStr.toLowerCase();

        String[] tokens = str.split("[ ]");
        totalWords = 0;
        for(int i = 0; i < tokens.length; i++)  {
            switch (tokens[i].charAt(0)) {
                case 'a': aTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'b': bTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'c': cTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'd': dTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'e': eTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'f': fTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'g': gTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'h': hTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'i': iTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'j': jTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'k': kTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'l': lTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'm': mTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'n': nTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'o': oTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'p': pTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'q': qTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'r': rTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 's': sTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 't': tTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'u': uTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'v': vTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'w': wTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'x': xTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'y': yTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                case 'z': zTree.insert(new WordNode(tokens[i],i));
                    totalWords ++;
                break;
                default: break;
            }
        }
        for(int j = 0; j < wordTrees.length; j++) {
            lt.insert(new LetterNode(alphabet[j],wordTrees[j]));
        }
        System.out.println("Statistical Summary");
        System.out.println("Total Number of Non-Blank Characters: " + nonBlankCharacters);
        System.out.println("Total Number of Words: " + totalWords);
        System.out.println("Index of Distinct Words and Their Position(s)");
        lt.display();
    }
}