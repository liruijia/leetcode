package com.leetcode.dynamic

object FibonacciSequence {
  // 状态转移 - f(n)= f(n-1) + f(n-2)
  // 传统 - 递归
  def fib(n:Int) : Int = {
    if(n==0){
      (0)
    }else{
      if(n==1){
        (1)
      }else{
        val F:Array[Int] = new Array[Int](n+1)
        F(1)=1
        F(2)=1
        F(0)=0
        if (n==2){
          (F(n))
        }else{
          var i : Int = 3
          while(i<n+1){
            F(i) = F(i-1) + F(i-2)
            i = i +1
          }
          (F(n))
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    print(fib(10))
  }
}
