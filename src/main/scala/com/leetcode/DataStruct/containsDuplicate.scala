package com.leetcode.DataStruct

import scala.collection.mutable.Set

import scala.collection.mutable

/*

给定一个整数数组，判断是否存在重复元素。

如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

HastSet

输入: [1,2,3,1]
输出: true

-- 思路 hashset
 */

object containsDuplicate {
  // 一般思路
  // SET 会超出内存限制
  // hasset 同样
  def containsDuplicate(nums : Array[Int]) : Boolean = {
    val n : Int = nums.length
    if(n==0){
      (false)
    }
    val hashset = new mutable.HashSet[Int]()
    hashset.add(nums(0))
    println(hashset)
    var i = 1
//    import scala.util.control.Breaks._
    while (i<n){
      if (hashset.contains(nums(i))){
        return true
      }else{
        hashset.add(nums(i))
        println(hashset)
        i+=1
      }
    }
    (false)
  }


  def containsDuplicate2(nums:Array[Int]):Boolean={
    if (nums.length == nums.toSet.size){
      (false)
    }else{
      (true)
    }
  }

  def main(args: Array[String]): Unit = {
    val nums : Array[Int] = Array(1,2,3,1)
//    print(containsDuplicate(nums))
    print(containsDuplicate2(nums))
  }
}
