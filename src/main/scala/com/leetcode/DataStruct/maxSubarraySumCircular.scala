package com.leetcode.DataStruct

/*
  给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。

在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）

此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次 (至多环绕一次)。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，
不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）

输入：[1,-2,3,-2]
输出：3
解释：从子数组 [3] 得到最大和 3

(分治的思想 动态规划)

从无环到有环 -- 无环直接遍历 找最大， 有环 跨越
最大值 可能在中间 也可能在两头

--  最大值中间 -- 同无环情况 最大序列和
--  最大值两端 -- 有环情况 此使中间为最小序列和 此时 则需要将 累计和-最小序列和= 最大序列和
--  特殊情况  全为负数
--  特殊情况  全为正数 此时 无环  因构成的最大序列环A数组中的每一个元素最多一次

从基础情况出发

输入：[3,-1,2,-1]
          3  -1  2   -1
tmp_max   3   2  4    3
max       3   3  4    4
tmp_min   3   -1  1   -1
mix       3   -1  -1   -1
累计       3   2    4    3
最终 4
怎么样判断 有环或者无环 ？
-- 3 无环
-- 3 -1  无环
-- 3 -1 2 无环
-- 3 -1 2 -1 有环
-- 3 -1 2 -1 6 有环
-- 低于3无环？ 高于3有环？ -- 无意义！！！

sum - 最小 ? 4 -- 如果最大序列和 >=0  4

-- 特殊情况 全为负数
输入     -2,-3,-1
tmp_max -2 -2 -1
max     -2 -2 -1   小于0
tmp_min -2 -5 -6
min     -2 -5 -6
累计 ：  -2 -5 -6
最终：-1

-- 最终结果 要么直接是 无环情况下 这种 max  要么有环
Math.max(max , sum-min if max>0 else max)



输出：4
解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
 */

object maxSubarraySumCircular {

  def maxSubarraySumCircular(nums : Array[Int]): Int={
    val n : Int = nums.length
    if(n==1){
      (nums(0))
    }else{
      var tmp_max = nums(0)
      var max1 = nums(0)
      var tmp_min = nums(0)
      var min1 = nums(0)
      var sumAll = nums(0)
      for (i <- Range(1,n)){
        tmp_max = Math.max(nums(i), tmp_max + nums(i))
        max1 = Math.max(tmp_max, max1)
        tmp_min = Math.min(nums(i), tmp_min + nums(i))
        min1 = Math.min(tmp_min, min1)
        sumAll+=nums(i)
      }
      val final_max = Math.max(max1,if(max1>0) sumAll-min1 else max1 )
      (final_max)
    }
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(6,9,-3)
    print(maxSubarraySumCircular(nums = nums))
  }

}
