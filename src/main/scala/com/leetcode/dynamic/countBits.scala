package com.leetcode.dynamic

/*
给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
输入: n = 2
输出: [0,1,1]
解释:
0 --> 0
1 --> 1
2 --> 10

-- 动态方程: dp(i) = dp(i/2) + i%2
n=5
0 --> 0 0
1 --> 1 1
2 --> 10 1
3 --> 11 2 dp(2)+1
4 --> 100  dp(2)
5 --> 101  2 1+余数
6 --> 110  2 dp(3)
7 --> 111  3 2+1  dp(3) + 余数
8 --> 1000 1 dp(4)


 */

object countBits {
  def countBits(n: Int): Array[Int] = {
    if(n==0){
      (Array(0))
    }else if(n==1){
      (Array(0,1))
    }else{
      val dp = new Array[Int](n+1)
      dp(0) = 0
      dp(1) = 1
      for (i<- Range(2,n+1)){
        val tmp1 = i/2
        dp(i) = dp(tmp1) + i%2
      }
      (dp)
    }
  }

  def main(args: Array[String]): Unit = {
    val n =2
    print(countBits(n).toVector)
  }
}
