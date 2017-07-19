package com.knoldus.kip.assignment.ds

class UpperBoundQueue[T] (
                           private val leading: List[T],
                           private val trailing: List[T]
                         ) {
  private def mirror =
    if (leading.isEmpty) {
      new UpperBoundQueue(trailing.reverse, Nil)
    }
    else {
      this
    }

  //def head: T = mirror.leading.head

  def tail : UpperBoundQueue[T] = {
    val q = mirror
    new UpperBoundQueue(q.leading.tail, q.trailing)
  }

  def enqueue[U <:T](x: T): UpperBoundQueue[T] = new UpperBoundQueue(leading, x :: trailing)

  override def toString: String = {
    val list = leading ::: trailing.reverse
    list.toString
  }

}

object Queue5 extends App{

  val fr1 = new AcademicsBooks

  val o1 = new ScienceBooks
  val o2 = new ScienceBooks

  val a1 = new MathematicsBooks

  val b1 = new Biology

  val q2 = new UpperBoundQueue[ScienceBooks](List(o1, o2), Nil)
  //q2.enqueue(a1)--This won't work
  //q2.enqueue(fr1)--This won't work

  val q3 = q2.enqueue(b1)

  print("\n Books Queue: " + q3)


}