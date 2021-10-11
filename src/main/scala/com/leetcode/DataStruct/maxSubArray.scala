package com.leetcode.DataStruct

/*
  给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

  输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
  输出：6
  解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

 */

object maxSubArray{
  // 遍历- 普通 -- 动态规划

  /*
    比较 当前大 还是 加起来大 连续的 - 复杂度O(n)
    动态转移方程：
    max(f(n), dp(n-1)+f(n))

    只需要记录下来 sum(i)
   */
  def maxSubArray(nums : Array[Int]) : Int = {
    val n : Int = nums.length
    if(n==0){
      (0)
    }else if(n==1){
      (nums(0))
    }else{
      var i = 0
      var maxsum = nums(0)
      var temp_sum = 0
      while(i<n){
        temp_sum = Math.max(nums(i)+temp_sum,nums(i))
        maxsum = Math.max(temp_sum, maxsum)
        i+=1
      }
      (maxsum)
    }
  }


  /*
    分治 ：
    把一个复杂的问题分成两个或更多的相同或相似的子问题，再把子问题分成更小的子问题……直到最后子问题可以简单的直接求解，
    原问题的解即子问题的解的合并

    -- 二分
    -- 傅里叶

     -- 分成左右两个相似的子问题，通过解决子问题提来解决原来的问题，其需要考虑到 左边部分/右边部分/跨越中心三种情况
        跨越中心 这一种 在考虑的时候 则是从中间开始进行扩散 ， 而不是从两边 跨越中心 则意味着中间是联通的 ， 左边最大和
        则需要从中心从右到左进行计算， 右边最大和 则需要从中心 从 左到右边进行计算
   */

  def maxSubArray2(nums : Array[Int]):Int = {
    val n : Int  = nums.length
    if (n==0){
      (0)
    }else if(n==1){
      (nums(0))
    }else{
      val maxLeft = maxSubArray2(nums.take(n/2))
      val maxRight = maxSubArray2(nums.takeRight(n-n/2))
      val mid : Int = n/2
      var tmpMaxLeft = nums(mid-1)
      var tmpMaxRight = nums(mid)
      var tmp1 = 0
      var tmp2 = 0
      for (i <-Range(mid-1 ,-1 ,-1)){
        tmp1 += nums(i)  // 不断转移
        tmpMaxLeft=Math.max(tmp1,tmpMaxLeft) // 获取最大
      }
      for (i <- mid until n){
        tmp2 += nums(i)
        tmpMaxRight = Math.max(tmp2, tmpMaxRight)
      }
      val finalMax = Math.max(Math.max(maxLeft,maxRight),tmpMaxLeft+tmpMaxRight)
      (finalMax)
    }

  }


  def main(args: Array[String]): Unit = {
    val nums : Array[Int] = Array(-2,1)
    print(maxSubArray2(nums) + "\n")
    print(maxSubArray(nums))
  }
}
