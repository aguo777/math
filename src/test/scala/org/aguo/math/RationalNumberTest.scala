package org.aguo.math

import org.scalatest.{ FlatSpec, Matchers }

class RationalNumberTest extends FlatSpec with Matchers {
  "RationalNumber" should "equal each other and integers" in {
    RationalNumber(2, 1) should be (RationalNumber(2))
    RationalNumber(4, 2) should be (RationalNumber(2))
    RationalNumber(6, 8) should be (RationalNumber(3, 4))
    RationalNumber(2, 1) should be (2)
  }

  it should "hash correctly" in {
    Set(RationalNumber(4, 2)) should contain (2)
    Set(RationalNumber(6, 8)) should contain (RationalNumber(3, 4))
  }

  it should "negate (idempotently)" in {
    RationalNumber(1, 2).negate should be (RationalNumber(-1, 2))
    RationalNumber(1, 2).negate should be (RationalNumber(1, -2))
    RationalNumber(1, 2).negate.negate should be (RationalNumber(1, 2))
  }

  it should "reciprocal (idempotently)" in {
    RationalNumber(1, 2).reciprocal should be (RationalNumber(2))
  }

  it should "add" in {
    RationalNumber(6, 8) + RationalNumber(1, 2) should be (RationalNumber(5, 4))
  }

  it should "subtract" in {
    RationalNumber(6, 8) - RationalNumber(1, 2) should be (RationalNumber(1, 4))
    RationalNumber(5, 9) - RationalNumber(5, 9) should be (RationalNumber.Zero)
  }

  it should "multiply" in {
    RationalNumber(6, 8) * RationalNumber(1, 2) should be (RationalNumber(3, 8))
  }

  it should "divide" in {
    RationalNumber(6, 8) / RationalNumber(1, 2) should be (RationalNumber(3, 2))
    RationalNumber(5, 9) / RationalNumber(5, 9) should be (RationalNumber.One)
  }
}
