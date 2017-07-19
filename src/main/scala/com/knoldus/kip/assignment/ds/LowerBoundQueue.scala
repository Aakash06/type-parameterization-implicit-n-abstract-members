package com.knoldus.kip.assignment.ds

class LowerBoundQueue[T] (
                           private val leading: List[T],
                           private val trailing: List[T]
                         ) {
  private def mirror =
    if (leading.isEmpty) {
      new LowerBoundQueue(trailing.reverse, Nil)
    }
    else {
      this
    }

  def head: T = mirror.leading.head

  def tail : LowerBoundQueue[T] = {
    val q = mirror
    new LowerBoundQueue(q.leading.tail, q.trailing)
  }

  def enqueue[U >:T](x: U): LowerBoundQueue[U] = new LowerBoundQueue(leading, x :: trailing)

  override def toString: String = {
    val list = leading ::: trailing.reverse
    list.toString
  }

}

object Queue4 extends App{

  val fr1 = new AcademicsBooks

  val o1 = new ScienceBooks
  val o2 = new ScienceBooks

  val a1 = new MathematicsBooks

  val b1 = new Biology

  val q2 = new LowerBoundQueue[ScienceBooks](List(o1, o2), Nil)

  print("\n" + q2.enqueue(b1))
  print("\n" + q2.enqueue(a1))
  print("\n" + q2.enqueue(fr1))

  print("\n Book Queue: " + q2)

  //val q3 : LowerBoundQueue[Food] = q2
  //print("\n Food(Veg) Queue: " + q3)

  //val q4: LowerBoundQueue[Fruit] = q1
  // --- This won't work

}
