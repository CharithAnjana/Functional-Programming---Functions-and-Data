object Q3 extends App {
  val acc1 = new Account("37", 100, 23000)
  val acc2 = new Account("73", 105, 90220)

  println("Before Transfer")
  println("acc num - " + acc1.acnum + ", balance -" + acc1.balance)
  println("acc num - " + acc2.acnum + ", balance -" + acc2.balance)

  println()
  acc1.transfer(acc2, 3000)

  println("After Transfer")
  println("acc num - " + acc1.acnum + ", balance -" + acc1.balance)
  println("acc num - " + acc2.acnum + ", balance -" + acc2.balance)
}

class Account(id:String, n:Int, b:Double){
  val nic:String = id
  val acnum:Int = n
  var balance:Double = b

  def withdraw(a:Double) = this.balance -= a

  def deposit(a:Double) = this.balance += a

  def transfer(a:Account, b:Double):Unit = {
    this.withdraw(b)
    a.deposit(b)
  }

  override def toString = "[" + this.nic + ":" + this.acnum + ":" + this.balance + "]"
}
