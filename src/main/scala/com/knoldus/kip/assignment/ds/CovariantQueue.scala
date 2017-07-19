package com.knoldus.kip.assignment.ds

class CovariantQueue[+T] (
                           private val leading: List[T],
                           private val trailing: List[T]
                         ) {
  private def mirror =
    if (leading.isEmpty) {
      new CovariantQueue(trailing.reverse, Nil)
    }
    else {
      this
    }

  def head: T = mirror.leading.head

  def tail : CovariantQueue[T] = {
    val q = mirror
    new CovariantQueue(q.leading.tail, q.trailing)
  }

  // def enqueue(x: T): Queue[T] = new Queue(leading, x :: trailing)

  override def toString: String = {
    val list = leading ::: trailing.reverse
    list.toString
  }

}

object Queue2 extends App{

  val f1 = new Books
  val f2 = new Books
  val f3 = new Books

  val v1 = new Novels
  val v2 = new Novels

  val q1 = new CovariantQueue[Books](List(f1, f2), Nil)
  print("\n Books Queue: " + q1)

  val q2 = new CovariantQueue[Novels](List(v1, v2), Nil)
  print("\n Novels Queue: " + q2)


  val q3 : CovariantQueue[Books] = q2
  print("\n Books(Novels) Queue: " + q3)

  // val q4: CovariantQueue[AcademicBooks] = q1
  // --- This won't work

}