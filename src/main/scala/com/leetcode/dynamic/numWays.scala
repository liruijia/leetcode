package com.leetcode.dynamic

/*
  一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

  答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。-- 每一步都需要取模

  dp(j) = dp(n-1) + dp(n-2)

  -- 直接使用 dp 记录 - 消耗存储内存
  -- 最终结果 只和前两个状态相关 因此只需要记录前面两个状态即可
 */

object numWays {
  def numWays(n: Int): Int = {
    if (n<=1){
      (1)
    }else if(n==2){
      (2)
    }else{
      val dp = new Array[Int](n+1)
      dp(0)=0
      dp(1)=1
      dp(2)=2
      for (i <- Range(3,n+1)){
        dp(i) = (dp(i-1) + dp(i-2)) % (1000000007)
      }
      (dp(n))
    }
  }

  def numWays2(n: Int): Int = {
    if (n<=1){
      (1)
    }else if(n==2){
      (2)
    }else{
      var after1 = 1
      var after2 = 2
      var tmp = 0
      for (i <- Range(3,n+1)){
        tmp = ((after1 + after2) % (1000000007))
        after1=after2
        after2=tmp
      }
      (after2)
    }
  }

  def main(args: Array[String]): Unit = {
    val n =46
    print(numWays2(n))
  }
}
