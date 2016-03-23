package Amzon.OA2;


import java.util.Arrays;

public class Days {
    //   int[] dayChange(int[] cells, int days), cells 数组，有8个元素，每天的变化情况是
    // 当前位置 cell == (cell[i - 1] == cell[i + 1]) ? 0 : 1, 左右相等，当前位置为0， 不等为1，
    // 默认 cells[0]左边 和 cells[cells.length - 1]右边的位置元素都是0， 求days天后的变化.
    public static int[] day(int[] input, int day) {
        if (day <= 0) return input;
        int[] res = new int[input.length];
        for (int i = 0; i < day; i++) {
            res[0] = input[1] == 1 ? 1 : 0; // 头尾特殊情况,默认和 index 0 左边是0, index length-1 右边是0
            res[res.length - 1] = input[input.length - 2] == 1 ? 1 : 0;
            for (int j = 1; j < res.length - 1; j++)
                res[j] = input[j - 1] == input[j + 1] ? 0 : 1;
            input = Arrays.copyOf(res, res.length);
        }
        return res;
    }
}
