import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSGrid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] graph = new char[n][m];

        Point start = null;
        Point finish = null;

        for(int i = 0; i < n; ++ i) {
            for(int j = 0; j < m; ++ j) {
                graph[i][j] = scanner.next().charAt(0);
                if(graph[i][j] == 'A') {
                    start = new Point(i, j);
                }
                if(graph[i][j] == 'B') {
                    finish = new Point(i, j);
                }
            }
        }

        boolean[][] used = new boolean[n][m];

        Queue<Cell> queue = new LinkedList<>();

        queue.add(new Cell(start, 0));
        used[start.x][start.y] = true;

        while(!queue.isEmpty()) {
            Cell current = queue.remove();
            int x = current.coordinate.x;
            int y = current.coordinate.y;

            if(current.coordinate.x == finish.x && current.coordinate.y == finish.y) {
                System.out.println(current.steps);
            }

            if(x - 1 >= 0 && !used[x - 1][y] && graph[x - 1][y] != '#') {
                used[x - 1][y] = true;
                queue.add(new Cell(new Point(x - 1, y), current.steps + 1));
            }

            if(x + 1 < n && !used[x + 1][y] && graph[x + 1][y] != '#') {
                used[x + 1][y] = true;
                queue.add(new Cell(new Point(x + 1, y), current.steps + 1));
            }

            if(y - 1 >= 0 && !used[x][y - 1] && graph[x][y - 1] != '#') {
                used[x][y - 1] = true;
                queue.add(new Cell(new Point(x, y - 1), current.steps + 1));
            }

            if(y + 1 < m && !used[x][y + 1] && graph[x][y + 1] != '#') {
                used[x][y + 1] = true;
                queue.add(new Cell(new Point(x, y + 1), current.steps + 1));
            }

        }
    }

}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Cell {
    Point coordinate;
    int steps;
    public Cell(Point coordinate, int steps) {
        this.coordinate = coordinate;
        this.steps = steps;
    }
}

/*
6 8
. # . . . . . .
A . . . # . . .
. # . . # . . .
# . # # # . . .
. # . . # . . #
. . . . . . . B
*/
