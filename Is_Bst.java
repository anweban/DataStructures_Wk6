package DataStructures_Wk6;

import java.util.*;
import java.io.*;

public class Is_Bst {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            if(tree.length > 0) {
                List<Integer> inOrderTrav = inOrder();
                for (int i = 0; i < inOrderTrav.size() - 1; i++) {
                    if (inOrderTrav.get(i) >= inOrderTrav.get(i + 1)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public List<Integer> inOrder(){
            List<Integer> result = new ArrayList<>();
            inOrderTraversal(result,0);
            return result;
        }

        public void inOrderTraversal(List<Integer> res, int n){
            if(tree[n].left != -1){
                inOrderTraversal(res, tree[n].left);
            }
            res.add(tree[n].key);
            if(tree[n].right != -1){
                inOrderTraversal(res, tree[n].right);
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new Is_Bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
