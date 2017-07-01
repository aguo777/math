package org.aguo.math

object Integer {
  def gcd(a: BigInt, b: BigInt): BigInt = {
    val r = (a % b).abs
    if (r == 0) b else gcd(b, r)
  }

  def lcm(a: BigInt, b: BigInt): BigInt = {
    a * b / gcd(a, b)
  }
}
