public class JavaHere {
    public static void main(String[] args) {
        DSU dsu = new DSU(10);

        dsu.union(1, 2);
        dsu.union(4, 5);
        dsu.union(7, 5);
        dsu.union(3, 6);
        dsu.union(1, 6);
        dsu.union(8, 9);

        for(int i = 1; i < 10; ++ i) {
            System.out.println(i + " -> " + dsu.find_leader(i));
        }

        System.out.println("-------------");

        dsu.union(6, 9);

        for(int i = 1; i < 10; ++ i) {
            System.out.println(i + " -> " + dsu.find_leader(i));
        }
    }
}

class DSU {

    private final int[] leader;
    private final int[] size;

    public DSU(int n) {
        leader = new int[n];
        size = new int[n];

        for(int i = 0; i < n; ++ i) {
            leader[i] = i;
            size[i] = 1;
        }
    }

    public void union(int a, int b) {
        int leader_a = find_leader(a);
        int leader_b = find_leader(b);

        if(size[leader_a] >= size[leader_b]) {
            leader[leader_b] = leader_a;
            size[leader_a] += size[leader_b];
        } else {
            leader[leader_a] = leader_b;
            size[leader_b] += size[leader_a];
        }
    }

    public int find_leader(int n) {
        if(leader[n] == n) {
            return n;
        }
        return leader[n] = find_leader(leader[n]);
    }

}
