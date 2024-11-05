package org.example;

class WeightedQuickUnion {
    int[] id;
    int[] weight;
    int size_id;

    public WeightedQuickUnion(int size_id) {
        id = new int[size_id];
        this.size_id = size_id;
        weight = new int[size_id];
        for (int i = 0; i < size_id; i++) {
            id[i] = i;
            weight[i] = 1;
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
        if (weight[root_p] < weight[root_q]) { id[root_p] = root_q; weight[root_q] += weight[root_p]; }
        else                           { id[root_q] = root_p; weight[root_p] += weight[root_q]; }
    }

    public boolean connected(int p, int q) {
        return (root(p) == root(q));
    }
}

public class WeightedQuickUnionDemo {

    public static void main(String[] args) {
        int n = 10;
        WeightedQuickUnion obj = new WeightedQuickUnion(n);
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
        obj.printId();

    }

}
