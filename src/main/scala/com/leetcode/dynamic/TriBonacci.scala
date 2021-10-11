package com.leetcode.dynamic


// 求第n个斐波拉切数 F(N+3)=F(N+2)+F(N+1)+F(N)
object TriBonacci {
  def tribonacci(n:Int) : Int = {
    if(n==0){
      (0)
    }else{
      if(n==1){
        (1)
      }else{
        val F:Array[Int] = new Array[Int](n+1)
        F(0) = 0
        F(1) = 1
        F(2) = 1
        if(n==2){
          (F(n))
        }else{
          var i = 3
          while(i<n+1){
            F(i)=F(i-1)+F(i-2)+F(i-3)
            i+=1
          }
          (F(n))
        }
      }
    }

  }

  def main(args: Array[String]): Unit = {
    print(tribonacci(10))
  }
}
