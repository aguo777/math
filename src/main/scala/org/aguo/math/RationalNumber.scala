package org.aguo.math

import Integer._

case class RationalNumber(private val origNumerator: BigInt, private val origDenominator: BigInt = 1) {

  require(origDenominator != 0)

  val divisor: BigInt = gcd(origNumerator, origDenominator)
  val numerator: BigInt = origNumerator / divisor
  val denominator: BigInt = origDenominator / divisor

  def negate: RationalNumber = {
    RationalNumber(-this.numerator, this.denominator)
  }

  def reciprocal: RationalNumber = {
    RationalNumber(this.denominator, this.numerator)
  }

  def +(that: RationalNumber): RationalNumber = {
    val newNumerator = this.numerator * that.denominator + that.numerator * this.denominator
    val newDenominator = this.denominator * that.denominator
    RationalNumber(newNumerator, newDenominator)
  }

  def *(that: RationalNumber): RationalNumber = {
    RationalNumber(this.numerator * that.numerator, this.denominator * that.denominator)
  }

  def -(that: RationalNumber): RationalNumber = this + that.negate

  def /(that: RationalNumber): RationalNumber = this * that.reciprocal

  override def toString: String = s"${this.numerator} / ${this.denominator}"

  override def equals(obj: scala.Any): Boolean = obj match {
    case that: RationalNumber => (this - that).numerator == 0
    case that: Int => this == RationalNumber(that)
    case that: BigInt => this == RationalNumber(that)
    case _ => throw new IllegalArgumentException(s"Cannot compare $this to $obj")
  }

  override def hashCode(): Int = (this.numerator, this.denominator).hashCode()

}

object RationalNumber {

  val Zero = RationalNumber(0)
  val One = RationalNumber(1)

  implicit def intToRationalNumber(n: BigInt): RationalNumber = RationalNumber(n)

  def unapply(arg: RationalNumber): Option[(BigInt, BigInt)] = Some((arg.numerator, arg.denominator))
}
