package ru.job4j.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Class Koffe решение задачи Кофемашина. [#34741]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Koffe {

    public int findOut(int ost) {
        int[] res = new int[] {10, 5, 2, 1};
        for (int i = 0; i < res.length; i++) {
            int x = ost - res[i];
            if (x  >= 0) {
                return res[i];
            }
        } return 0;
    }
    public List<Integer> changes(int value, int price) {
        List<Integer> outRes = new ArrayList<Integer>();
        int ost = value - price;
        int x = ost;
        while (ost > 0) {
            int y = this.findOut(x);
            outRes.add(y);
            ost = ost - y;
            x = ost;
        }
        return outRes;
    }

    public int[] changesTwo(int value, int price) {
        int[] outRes = new int[] {};
        int ost = value - price;
        int x = ost;
        while (ost > 0) {
            int y = this.findOut(x);
            outRes = Arrays.copyOf(outRes, outRes.length + 1);
            outRes[outRes.length - 1] = y;
            ost = ost - y;
            x = ost;
        }
        return outRes;
    }

}
