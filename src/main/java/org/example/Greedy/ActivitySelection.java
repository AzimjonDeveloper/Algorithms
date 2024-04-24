package org.example.Greedy;

import java.util.Set;
import java.util.LinkedHashSet;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] s = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2,12};
        int[] f = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        Set<Integer> set = getMaxLength(s, f);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    public static Set<Integer> getMaxLength(int[] s, int[] f) {
        Set<Integer> largestSet = new LinkedHashSet<Integer>();
        largestSet.add(0);
        int j = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i] >= f[j]) {
                largestSet.add(i);
                j = i;
            }
        }
        return largestSet;
    }
}
