object Q1 extends App {
  val num = new Rational(2, 3)

  println(num)
  println(num.neg)
}

class Rational(x:Int, y:Int){

  private def gcd(x:Int, y:Int):Int = if(y == 0) x else gcd(y, x % y)

  private val g = gcd(Math.abs(x), Math.abs(y))
  val numer = x / g
  val denom = y / g

  def neg = new Rational(- this.numer, this.denom)

  override def toString = this.numer.toString + " / " + this.denom.toString
}
