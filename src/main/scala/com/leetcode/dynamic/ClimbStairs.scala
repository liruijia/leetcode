package com.leetcode.dynamic

/*
  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

  f(n) = f(n-1) + 1 / f(n-2)+2

  重叠子问题
 */

object ClimbStairs {
  def climbStairs(n:Int):Int={
    if (n==0) {
      (0)
    }else if(n==1){
      (1)
    }else if(n==2){
      (2)
    }else {
      val  dp : Array[Int] = new Array[Int](n+1)
      dp(0) = 0
      dp(1) = 1
      dp(2) = 2
      var i = 3
      while (i<n+1){
        dp(i) = dp(i-1)+dp(i-2)
        i+=1
      }
      (dp(n))
    }
  }

  def main(args: Array[String]): Unit = {
    print(climbStairs(10))
  }
}
