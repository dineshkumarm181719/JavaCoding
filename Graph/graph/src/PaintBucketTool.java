import java.util.*;
import java.util.Queue;
public class PaintBucketTool {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int rows = s.nextInt();
        int cols = s.nextInt();
        int[][] image = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = s.nextInt();
            }
        }
        int startRow = s.nextInt();
        int startCol = s.nextInt();
        int newColor = s.nextInt();
        int oldColor = image[startRow][startCol];
        if (oldColor != newColor) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startRow, startCol});
            image[startRow][startCol] = newColor;
            int[][] directions = {
                    {-1, 0},
                    {1, 0},
                    {0, -1},
                    {0, 1}
            };
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < rows &&
                            nc >= 0 && nc < cols &&
                            image[nr][nc] == oldColor) {
                        image[nr][nc] = newColor;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}