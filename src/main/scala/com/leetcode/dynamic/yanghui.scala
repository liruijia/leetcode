 package com.leetcode.dynamic


/*
  杨辉三角：

  给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
  在「杨辉三角」中，每个数是它左上方和右上方的数的和。

  输入: numRows = 5
  输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]


  分组： 动态规划 & 数组


  题解：

    n = 1 f[0]=1  0
    n = 2 f[0]=1 f[1]=1
    n = 3 f[0]=1 f[1] = 2 f[2] = 1  0
               0   1             2  1
    n = 4 f[0]=1 f[1] = 3, f[2] = 3 , f[3] = 1


    内部： f[n,j] = f[n-1, j-1] + f[n-1,j]
    边界： f[n,l] = 1
 */
object yanghui {
  def generate(nums : Int):List[List[Int]]={
    if (nums==0){
      (List.empty)
    } else if (nums==1){
      (List(List(1)))
    }else{
      var f = List(List(1))

      for (  i<- Range(1,nums,1)){
        val inter1 = List(0) ++ f.dropRight(i-1).flatten
        val inter2 = f.dropRight(i-1).flatten ++List(0)
        val sum_list = inter1.zip(inter2).map(t=>t._1+t._2)

        f = f.+:(sum_list)
      }
      (f.reverse)
      }
  }

  def main(args: Array[String]): Unit = {
    val nums=5
    print(generate(nums))
  }
}
