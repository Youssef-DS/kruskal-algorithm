package Problem4;

import java.util.Scanner;

class kruskal {

    int h = 0;
    int v;
    int[] parent;

    public kruskal(int vertex) {
        v = vertex + 1;
        parent = new int[v];
    }

    int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    void union(int i, int j) {
        int a = find(i);
        int b = find(j);
        parent[a] = b;
    }

    public void kruskalMST(int cost[][]) {
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
        int edge_count = 0;
        do {
            int min = -1, a = -1, b = -1;
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (find(i) != find(j) && cost[i][j] > min) {
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }
            union(a, b);
            edge_count++;
            h += min;
        } while (edge_count < v - 1);
    }

    public static void main(String[] args) {

        int v, e, count = 1, to, from, B = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        v = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        e = sc.nextInt();
        System.out.println("Enter the edges: <from> <to>");
        int[][] matrix = new int[v + 1][v + 1];
        kruskal ob = new kruskal(v);
        while (count <= e) {
            from = sc.nextInt();
            to = sc.nextInt();
            int cost = Math.abs(to - from);
            matrix[from][to] = cost;
            B += cost;
            count++;
        }
        ob.kruskalMST(matrix);
        int result = B - ob.h;
        System.out.println("the total minimum cost of removing edges is :" + "\n" + result);
    }
}