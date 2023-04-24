class JavaHere {

    public static void main(String[] args) {
        DSU dsu = new DSU(10);
        dsu.union(1, 2);
        dsu.union(4, 2);
        dsu.union(5, 2);
        dsu.union(3, 6);
        dsu.union(7, 8);
        dsu.union(9, 10);

        dsu.union(8, 5);

        dsu.printLeaders();
    }
}

public class DSU {

    private final int[] leaders;
    private final int[] size;

    public DSU(int n) {
        leaders = new int[n + 1];
        size = new int[n + 1];

        for(int i = 1; i <= n; ++ i) {
            leaders[i] = i;
            size[i] = 1;
        }
    }

    public int find(int n) {
        if(leaders[n] == n) {
            return n;
        }
        return leaders[n] = find(leaders[n]);
    }

    public void union(int a, int b) {
        int leaderA = find(a);
        int leaderB = find(b);

        if(size[leaderA] >= size[leaderB]) {
            leaders[leaderB] = leaderA;
            size[leaderA] += size[leaderB];
        } else {
            leaders[leaderA] = leaderB;
            size[leaderB] += size[leaderA];
        }

    }

    public void printLeaders() {
        for(int i = 1; i < leaders.length; ++ i) {
            System.out.println(i + " " + leaders[i]);
        }
    }

}
