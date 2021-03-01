/**
 * 幻方
 */

public class MSquare {
    private int[][] data;
    private int n;

    public MSquare(int n) {
        this.n = n;
        data = new int[n][n];
    }

    public MSquare make() {
        int i = 0;
        int j = n / 2;
        for (int d = 1; d <= n * n; d++) {
            data[i][j] = d;
            int ti = --i, tj = ++j;
            if (i < 0) {
                ti = n - 1;
            }
            if (j >= n) {
                tj = 0;
            }
            if (data[ti][tj] != 0) {
                ti = i + 2;
                tj = j - 1;
            }
            i = ti;
            j = tj;
        }
        return this;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                builder.append(data[i][j] + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            int data = Integer.parseInt(args[0]);
            if ((data & 1) == 1) {
                System.out.println(new MSquare(data).make());
            } else {
                System.err.println("参数只能是奇数");
            }
        } else {
            System.err.println("参数个数错误， 需要一个参数");
        }
    }
}