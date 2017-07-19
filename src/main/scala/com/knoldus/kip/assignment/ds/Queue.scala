package com.knoldus.kip.assignment.ds

class Queue[T](
                private val leading: List[T],
                private val trailing: List[T]
              ) {
  private def mirror =
    if (leading.isEmpty) {
      new Queue(trailing.reverse, Nil)
    }
    else {
      this
    }

  def head: T = mirror.leading.head

  def tail : Queue[T] = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }

  def enqueue(x: T): Queue[T] = new Queue(leading, x :: trailing)

  override def toString: String = {
    val list = leading ::: trailing.reverse
    list.toString
  }
}


object Queue1 extends App{

  val f1 = new Books
  val f2 = new Books
  val f3 = new Books

  val v1 = new Novels
  val v2 = new Novels

  val q1 = new Queue[Books](List(f1, f2), Nil)
  print(q1.enqueue(f3))

  val q2 = new Queue[Novels](List(v1, v2), Nil)
  print("\n Novels Queue: " + q2)

  //val q3 : Queue[Novels] = q1 --- This won't work
  //val q4 : Queue[Books] = q2 --- This won't work
}
