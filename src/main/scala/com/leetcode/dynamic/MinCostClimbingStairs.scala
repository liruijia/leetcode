package com.leetcode.dynamic

//import breeze.linalg.{max, min}

/*
  数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。

  每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。

  请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯

  方法1 ：
  dp[i] 表示到达第 i 级楼梯所需要的最小代价
  转移到 第n阶 - 花费最小体力值  到n-1  再爬一个阶梯 花费cost[n] 上第n阶
             - 花费最小体力值  到n-2  再爬2个阶梯 花费cost[n] 上第n阶
  f(n) =  mincost(f(n-1), f(n-2)) + cost[i]

  方法2 ：
  dp[i] 表示到达第 i 级楼梯所需要的最小代价
  转移到  - 话费最小体力值到 n-1 但是还未上去 花费 cost[n-1]上去到n-1
         - 话费最小体力值到 n-2 但是还未上去 花费 cost[n-2]上去到n-2

  f(n) = mincost(f(n-1) + cost[n-1] , f(n-2) + cost[n-2])
 */

object MinCostClimbingStairs {
  def minCostClimbingStairs(cost:Array[Int]):Int={
    val n = cost.length
    if(n==0){
      (0)
    }else if(n==1){
      (cost(0))
    }else if(n==2){
      (cost.min)
    }
    val dp : Array[Int] = new Array[Int](n)
    dp(0) = cost(0)
    dp(1) = cost(1)
    var i = 2
    while (i<n){
      dp(i) =  Math.min(dp(i-1),dp(i-2))+cost(i)
      i+=1
    }
    (Math.min(dp(n-1),dp(n-2)))
  }

  // 只与前两个状态有关 所以 只需要定义两个变量进行轮换即可
  def minCostClimbingStairs2(cost : Array[Int]) : Int = {
    val n = cost.length
    var p : Int = 0
    var q : Int = 0
    var tmp : Int = 0

    for (i <- 2 to n){
      tmp = q
      q = Math.min(q + cost(i-1), p + cost(i-2))
      p = tmp
    }
    (q)
  }

  def main(args: Array[String]): Unit = {
    val cost : Array[Int] = Array(10,15,20)
//    print(minCostClimbingStairs(cost))
    println(minCostClimbingStairs2(cost))
  }
}

