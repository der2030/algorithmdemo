package der.algorithm.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
* @FileName:TwentyFourGame
* @Description: you can add , subtract, multiply and divide by the given 4 number at random ,
 *   and its final result equals 24
 *   for example:
 *    data-{2,4,7,8}
 *    solution- (((8*7)/2)-4),(((7/2)*8)-4),(4*((2*7)-8)),(((8/2)*7)-4),(((2*7)-8)*4),etc.
* @Author: Derrick Ye
*/


public class TwentyFourGame {

    private int[] data;
    private final int numbers = 4;
    private final int result = 24;
    private Map<Integer, Set<CalItem>> map;
    private Set<String> answers;

    public TwentyFourGame(int[] data) {
        this.data = data;
        map = new HashMap<Integer, Set<CalItem>>();
        answers = new HashSet<String>();
    }

    public void calculate() {
        for (int i = 0; i < (1 << numbers); i++) {
            Set<CalItem> set = new HashSet<CalItem>();
            map.put(i, set);
        }
        for (int i = 0; i < numbers; i++) {
            CalItem e = new CalItem(data[i], data[i] + "");
            Set<CalItem> set = new HashSet<CalItem>();
            set.add(e);
            map.put(1 << i, set);
        }
        for (int i = 1; i < (1 << numbers); i++) {
            fork(i);
        }
        Set<CalItem> mSet = map.get((1 << numbers) - 1);
        for (CalItem e : mSet) {
            if (e.value == result) {
                answers.add(e.info);
            }
        }
        if (answers.size() == 0) {
            System.out.println("No way to calculate!");
        } else {
            for (String s : answers)
                System.out.println(s);
            System.out.println("There are " + answers.size() + " ways to calculate!");
        }

    }

    public Set<CalItem> fork(int num) {
        Set<CalItem> numSet = map.get(num);
        if (numSet.size() > 0)
            return numSet;
        else {
            for (int x = 1; x <= num; x++) {
                if ((x & num) == x) {
                    Set<CalItem> s1 = fork(x);
                    Set<CalItem> s2 = fork(num - x);
                    for (CalItem item1 : s1) {
                        for (CalItem item2 : s2) {

                            String str = "(" + item1.info + "+" + item2.info + ")";
                            numSet.add(new CalItem(item1.value + item2.value, str));

                            str = "(" + item1.info + "-" + item2.info + ")";
                            numSet.add(new CalItem(item1.value - item2.value, str));

                            str = "(" + item2.info + "-" + item1.info + ")";
                            numSet.add(new CalItem(item2.value - item1.value, str));

                            str = "(" + item1.info + "*" + item2.info + ")";
                            numSet.add(new CalItem(item1.value * item2.value, str));

                            if (item1.value != 0) {
                                str = "(" + item2.info + "/" + item1.info + ")";
                                numSet.add(new CalItem(item2.value / item1.value, str));
                            }
                            if (item2.value != 0) {
                                str = "(" + item1.info + "/" + item2.info + ")";
                                numSet.add(new CalItem(item1.value / item2.value, str));
                            }
                        }
                    }
                }
            }
            return numSet;
        }
    }
}


class CalItem{
    public double value;
    public String info;
    public CalItem(double v,String i){
        value = v;
        info = i;
    }
}

