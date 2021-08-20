object Q1 extends App {

  val overdraft = (b:List[Account]) => b.filter(x => x.balance < 0)

  val Totalbalance = (b:List[Account]) => b.reduce((x, y) => new Account("", 0, x.balance + y.balance)).balance

  val interest = (b:List[Account]) => b.map(x => if(x.balance >=0) new Account(x.nic, x.acnum, x.balance + x.balance * 0.005) else new Account(x.nic, x.acnum, x.balance + x.balance * 0.01))


  val acc1 = new Account("103", 11, 10200)
  val acc2 = new Account("104", 12, 1500)
  val acc3 = new Account("105", 13, -2032)
  val acc4 = new Account("106", 14, 11200)
  val acc5 = new Account("107", 15, 10303)
  val acc6 = new Account("108", 16, -1020)

  var bank:List[Account] = List(acc1, acc2, acc3, acc4, acc5, acc6)

  println("Overdraft List")
  overdraft(bank).foreach(i => println(i))
  println()

  println("Sum of All Accounts: Rs " + Totalbalance(bank))
  println()

  println("Sum of All Accounts(After Interest): Rs " + Totalbalance(interest(bank)))
  println()
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
