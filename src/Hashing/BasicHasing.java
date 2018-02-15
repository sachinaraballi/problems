package Hashing;

public class BasicHasing {

    static String list[] = new String[] { "activity", "Alaska", "appearance", "arent", "article", "Aunt", "automobile", "avoid", "basket", "birthday" };
    static int arraySize = list.length;
    static String hashTable[] = new String[arraySize];
    static List[] linkedlist= new List[arraySize];
    static int[] array2 = new int[arraySize];
    static int[] array1 = new int[arraySize];

    public static int hashing(String str) {
        int hash = 7;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * 31 + str.charAt(i)) % arraySize;
        }
        return hash;
    }
    
    static boolean compare1(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < arraySize; i++) {
            array2[i] = array1[i] = -1;
        }
        for (int i = 0; i < arraySize; i++) {
            //hashing through normal array
            hashTable[hashing(list[i])] = list[i];
            System.out.println("key " + hashing(list[i]) + " value " + list[i]);
            
            //hashing through linkedlist
            int index = hashing(list[i]);
            if(linkedlist[index] == null)
                linkedlist[index] = new List();
            linkedlist[index].insert(list[i]);
            
            //hashing through line probing 
            int index1 = hashing(list[i]);
            array2[i] = array1[index1];
            array1[index1] = i;
            
        }
        for (int i = 0; i < arraySize; i++) {
            int index = hashing(list[i]);
            if(linkedlist[index] != null){
               System.out.println(linkedlist[index].search(list[i])); 
            }
        }
        for (int i = 0; i < arraySize; i++) {
            int index = hashing(list[i]);
            if(array1[index] == -1){
                System.out.println("not found");
            }
            for(int j = array1[index]; j > -1 ; j = array2[j]){
                if(compare1(list[i], list[j])){
                    System.out.println("found");
                    break;
                }
            }
        }
    }


   

}

class List {
    Node head;

    void insert(String value) {
        if (head == null) {
            head = new Node(value);
            return;
        } else {
            Node node = new Node(value);
            node.next = head;
            head = node;
        }
    }

    boolean search(String value) {
        Node cur = head;
        while (cur != null) {
            if (compare(cur.value, value)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    boolean compare(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}

class Node {
    String value;
    Node next;

    Node(String value) {
        this.value = value;
    }
}