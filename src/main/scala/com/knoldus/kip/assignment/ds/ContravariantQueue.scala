package com.knoldus.kip.assignment.ds

class ContravariantQueue[-T] {

  def add(x: T): Unit = print("\n" + x)
}

object Queue3 extends App{

  val f1 = new Books

  val fr = new AcademicsBooks

  val v1 = new Novels

  val q1 = new ContravariantQueue[Books]
  q1.add(f1)

  val q2 = new ContravariantQueue[Novels]
  q2.add(v1)

  // val q3 : ContravariantQueue[AcademicBooks] = q2
  // --- This won't work

  val q4: ContravariantQueue[AcademicsBooks] = q1
  //q4.add(f1)----This won't work
  q4.add(fr)
}