package org.example;

class QuickUnion {
    int[] id;
    int size_id;

    public QuickUnion(int size_id) {
        id = new int[size_id];
        this.size_id = size_id;
        for (int i = 0; i < size_id; i++) {
            id[i] = i;
        }
    }
    public void printId() {
        for (int i = 0; i < size_id; i++) System.out.print(id[i] + " ");
        System.out.println();

    }
    public int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public void union(int p, int q) {
        int root_p = root(p);
        int root_q = root(q);
        if (connected(root_p, root_q)) {
            System.out.println("It is already connected");
            return;
        }
        id[root_p] = root_q;
    }

    public boolean connected(int p, int q) {
        //System.out.printf("%d %d ",id[p],id[q]);
        return (root(p) == root(q));
    }
}

public class QuickUnionDemo {

    public static void main(String[] args) {
        int n = 10;
        QuickUnion obj = new QuickUnion(n);
        obj.union(4, 3);
        obj.union(3, 8);
        obj.union(6, 5);
        obj.union(2, 1);
        obj.union(4, 9);
        System.out.println(obj.connected(8, 9));
        System.out.println(obj.connected(0, 5));
        obj.union(5, 0);
        System.out.println(obj.connected(0, 5));
        obj.union(7, 2);
        obj.union(6, 1);

    }

}
