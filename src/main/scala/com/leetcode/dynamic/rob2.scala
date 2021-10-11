package com.leetcode.dynamic

/*
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

正常情况下 ：  dp(n) = Math.max(dp(n-2) + nums(n-1) , dp(n-1))

环形 - 第一位偷了 最后一位不偷 反之亦然

最大值要么就是 ：要么第一位不偷的情况下最大值
要么最后一位不偷情况下的最大值

第一位不偷： 2~n
  dp[0] = 0
  dp[1] = 0
  dp[2] = nums(1) = 3
  dp[3] = Math.max(dp(1) + nums(2) , dp(2)) = 3

最后一位不偷：1~n-1
  dp[n] = 0
  dp[0] = 0
  dp[1] = nums(0) = 2
  dp(2) = Math.max(dp(0) + nums(1) , dp(1)) = 3


  dp(j) = Math.max(dp(j-2) + nums(j-1),dp(j-1))
 */

object rob2 {

  def rob2(nums : Array[Int]) : Int = {
    val n : Int = nums.size
    if (n==0){
      (0)
    }else if(n==1){
      (nums(0))
    }else{
      val dp : Array[Int] = new Array[Int](n+1)
      val dm : Array[Int] = new Array[Int](n+1)
      dp(0)= 0
      dp(1)=0
      dp(2)=nums(1)

      for (i <- Range(3,n+1)){
        dp(i) = Math.max(dp(i-2) + nums(i-1), dp(i-1))
      }

      dm(n)=0
      dm(0)=0
      dm(1)=nums(0)
      for (i <- Range(2,n)){
        dm(i) = Math.max(dm(i-2) + nums(i-1), dm(i-1))
      }
      (Math.max(dp.max,dm.max))
    }
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1,2,3,1)
    print(rob2(nums))
  }
}
