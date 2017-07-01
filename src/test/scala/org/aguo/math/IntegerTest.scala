package org.aguo.math

import org.scalatest.{ FlatSpec, Matchers }

import Integer._

class IntegerTest extends FlatSpec with Matchers {
  "gcd" should "compute the greatest common divisor" in {
    gcd(2, 3) should be (1)
    gcd(3, 2) should be (1)
    gcd(4, 7) should be (1)
    gcd(2, 4) should be (2)
    gcd(4, 2) should be (2)
    gcd(8, 12) should be (4)
    gcd(-4, 7) should be (1)
    gcd(2, -4) should be (2)
    gcd(-8, -12) should be (4)
  }

  "lcm" should "compute the least common multiple" in {
    lcm(2, 3) should be (6)
    lcm(4, 6) should be (12)
    lcm(12, 14) should be (84)
  }
}
