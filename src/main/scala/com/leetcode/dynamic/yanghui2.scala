
package com.leetcode.dynamic

/*
  给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。

  在「杨辉三角」中，每个数是它左上方和右上方的数的和

  输入: rowIndex = 3
  输出: [1,3,3,1]

  -- 一种方法是 直接求到f(n) 按照杨辉三角的方法 最后把想要的rowIndex的元素取出来即可

  -- 另外一种，f(n) 只依赖于 前一行元素 所以存储的元组只需要存储前一位和后一位持续滚动存储即可
 */
object yanghui2 {
  def getRow(rowIndex: Int): List[Int] = {

    if (rowIndex==0){
      (List(1))
    }else if(rowIndex==1){
      (List(1,1))
    }
    var f = List(List(1))
    for (  i<- Range(1,rowIndex+1,1)){
      val inter1 = List(0) ++ f.dropRight(i-1).flatten
      val inter2 = f.dropRight(i-1).flatten ++List(0)
      val sum_list = inter1.zip(inter2).map(t=>t._1+t._2)

      f = f.+:(sum_list)
    }
    (f.reverse.apply(rowIndex))
  }

  def getRow2(rowIndex: Int): List[Int] = {

    if (rowIndex==0){
      (List(1))
    }else if(rowIndex==1){
      (List(1,1))
    }
    var f = List(List(1))
    for (  i<- Range(1,rowIndex+1,1)){
      val inter1 = List(0) ++ f.last
      val inter2 = f.last ++ List(0)
      val sum_list = inter1.zip(inter2).map(t=>t._1+t._2)
      f = List(sum_list)
    }
    (f.flatten)
  }

  def main(args: Array[String]): Unit = {
    val rowIndex = 2
    print(getRow2(rowIndex))
  }
}
