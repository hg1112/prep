package org.example;

class QuickFind {
    int[] id;
    int size_id;

    public QuickFind(int size_id) {
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

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        if (pid == qid) {
            System.out.println("It is already connected");
            return;
        }
        for (int i = 1; i < size_id; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    public boolean connected(int p, int q) {
        return (id[p] == id[q]);
    }
}

public class QuickFindDemo {

    public static void main(String[] args) {
        int n = 10;
        QuickFind obj = new QuickFind(n);
        obj.union(4, 3);
        obj.union(3, 8);
        obj.union(6, 5);
        obj.union(2, 1);
        obj.union(4, 9);
        System.out.println(obj.connected(8, 9));
        System.out.println(obj.connected(0, 5));
        obj.union(5, 0);
        obj.union(7, 2);
        obj.union(6, 1);
        obj.printId();
    }

}
