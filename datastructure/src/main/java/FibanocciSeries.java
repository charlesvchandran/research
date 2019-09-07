// import java.io.*;
// import java.util.*;

/*
 * In mathematics, the Fibonacci numbers or Fibonacci series or
 * Fibonacci sequence are the numbers in the following integer
 * sequence:
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 *
 * By definition: the first two numbers in the Fibonacci
 * sequence are 0 and 1, and each subsequent number is the sum
 * of the previous two.  It does translate as:
 * fib(n) = fib(n-1) + fib(n-2)
 * with the condition that fib(0)=0 and fib(1)=1
 *
 * Please implement in Java the method for computing
 * any fibonacci numbers. Please explain your approach
 */

import java.util.HashMap;
import java.util.Map;

class FibanocciSeries {
   public static void main(String[] args) {
     final int fNumber = 100;
     final Long result = fib(fNumber);
     System.out.println("Result fibonnaci(" + fNumber + ")=" + result);
   }

   public static Long fib(int fibNumber) {

     Map<Integer, Long> fibNumbers = new HashMap<>();

     for (int i=0;i<=fibNumber;i++) {
       Long fnum = Long.valueOf(i);
       if (i  > 1) fnum = fibNumbers.get(i-2) + fibNumbers.get(i-1);
       fibNumbers.put(i, fnum);
     }
     return fibNumbers.get(fibNumber);
   }
 }

// fib(100) = 3736710778780434371