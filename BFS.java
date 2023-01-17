import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();// number of nodes
        int m = scanner.nextInt();// number of edges

        LinkedList<Integer>[] graph = new LinkedList[n];
        for(int i = 0; i < n; ++ i) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < m; ++ i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] used = new boolean[n];

        int startNode = scanner.nextInt();
        int finishNode = scanner.nextInt();

        Queue<City> queue = new LinkedList<>();

        used[startNode] = true;
        queue.add(new City(startNode, 0));

        while(!queue.isEmpty()) {
            City current = queue.remove();

            if(current.name == finishNode) {
                System.out.println(current.steps);
                break;
            }

            for(int neighbor: graph[current.name]) {
                if(!used[neighbor]) {
                    used[neighbor] = true;
                    queue.add(new City(neighbor, current.steps + 1));
                }
            }
        }

    }
}

class City {
    int name;
    int steps;
    public City(int name, int steps) {
        this.name = name;
        this.steps = steps;
    }
}
