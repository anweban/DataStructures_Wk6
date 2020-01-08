package DataStructures_Wk6;
import java.util.*;
import java.io.*;

public class Is_Bst_Hard {
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

        class Result{
            int max;
            int min;
            boolean isbst;
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
                Result result = inOrderTraversal(0);
                if(!result.isbst){
                    return false;
                }
            }
            return true;
        }


        public Result inOrderTraversal(int n){
            Boolean bst = true;
            int maxVal;
            int minVal;
            if(tree[n].left == -1){
                minVal = tree[n].key;
            }else{
                Result result= inOrderTraversal(tree[n].left);
                if(result.isbst && result.max < tree[n].key){
                    minVal = result.min;
                }else{
                    bst = false;
                    minVal = Integer.MAX_VALUE;
                }
            }

            if(tree[n].right == -1) {
                maxVal = tree[n].key;
            }else{
                Result result= inOrderTraversal(tree[n].right);
                if(result.isbst && result.min >= tree[n].key){
                    maxVal = result.max;
                }else{
                    bst = false;
                    maxVal = Integer.MIN_VALUE;
                }
            }
            Result res = new Result();
            res.isbst = bst;
            res.max = maxVal;
            res.min = minVal;
            return res;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new Is_Bst_Hard().run();
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
