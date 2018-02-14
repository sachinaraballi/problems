//https://www.hackerrank.com/challenges/no-prefix-set/problem

package Trie;

import java.util.Scanner;

/**
 * 
 * @author sachinaraballi
 *
 */

public class NoPrefixSet {

    static class Node {
        char character;
        Node[] children = new Node[26];
        boolean isLeaf;

        Node(char c, boolean isLeaf) {
            this.character = c;
            this.isLeaf = isLeaf;
        }
    }

    static boolean flag = true;
    static Node root;
    static {
        root = new Node(' ', false);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            if (flag) {
                add(sc.next());
            }
        }
        if (flag) {
            System.out.println("GOOD SET");
        }
    }

    public static void add(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new Node(ch, false);
            } else {
                if (current.children[ch - 'a'].isLeaf || i == word.length() - 1) {
                    flag = false;
                    System.out.println("BAD SET");
                    System.out.println(word);
                }

            }
            current = current.children[ch - 'a'];
        }
        current.isLeaf = true;
    }

}

//
/*
Sample Input00

7
aab
defgab
abcde
aabcde
cedaaa
bbbbbbbbbb
jabjjjad
Sample Output00

BAD SET
aabcde
Sample Input01

4
aab
aac
aacghgh
aabghgh
Sample Output01

BAD SET
aacghgh

*/
