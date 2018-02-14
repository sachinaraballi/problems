//https://www.hackerrank.com/domains/data-structures/trie

package Trie;

import java.util.Scanner;

/**
 * 
 * @author sachinaraballi
 *
 */

class Node {
    char character; // to hold current character
    Node[] children = new Node[26]; // child nodes
    boolean isLeaf; // true if end of word
    int count; // visited count

    Node(char c, boolean isLeaf, int count) {
        this.character = c;
        this.isLeaf = isLeaf;
        this.count = count;
    }
}

public class Contacts {

    static Node root;

    static {
        root = new Node(' ', false, 0);
        // root will be always empty
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            String operation = sc.next();
            String input = sc.next();
            if (operation.equals("add")) {
                add(input);
            } else if (operation.equals("find")) {
                System.out.println(find(input));
            }
        }
    }

    public static void add(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.children[ch - 'a'] == null) { // if children array
                                                      // content is empty
                current.children[ch - 'a'] = new Node(ch, false, 1); // insert
                                                                     // new node
            } else {
                current.children[ch - 'a'].count++; // else mark visited
            }
            current = current.children[ch - 'a']; // update pointer
        }
        current.isLeaf = true; // end node
    }

    public static int find(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.children[ch - 'a'] == null || current.children[ch - 'a'].character != ch) {
                return 0;
            } else {
                current = current.children[ch - 'a'];
            }
        }
        return current.count;
    }

}

/*
 * Sample Input
 * 
 * 4 
 * add hack 
 * add hackerrank 
 * find hac 
 * find hak
 * 
 *  Sample Output
 * 
 * 2 0
 */
