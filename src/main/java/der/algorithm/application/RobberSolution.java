package der.algorithm.application;
/**
* @FileName:RobberSolution
* @Description:  You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
* @Author: Derrick Ye
*/
public class RobberSolution {

    public int robPlan(int[] money) {

        if(money.length == 0) return 0;
        if(money.length == 1) return money[0];

        int[] res = new int[money.length];

        res[0] = money[0];
        res[1] = money[0] >money[1] ? money[0] :money[1];

        for(int i = 2; i < money.length; i++) {

            res[i] = Math.max(res[i - 2] + money[i], res[i - 1]);

        }

//        for(int i = 0; i < res.length; i++) {
//
//            System.out.print(res[i] + " ");
//
//        }

        return res[res.length - 1];

    }
}
