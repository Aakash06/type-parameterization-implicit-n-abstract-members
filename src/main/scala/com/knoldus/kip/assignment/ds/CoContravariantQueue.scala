package com.knoldus.kip.assignment.ds

class CoContravariantQueue[-S, +T] {

  def write(x: S): T = {
    x match {
      case res: T => res
    }
  }

}

object Queue6 extends App{

  val f1 = new Books

  val fr1 = new AcademicsBooks

  val o1 = new ScienceBooks

  val a1 = new MathematicsBooks

  val b1 = new Biology

  val v1 = new Novels

  val v2 = new Botany

  val q = new CoContravariantQueue[AcademicsBooks,Biology]

  print("1st :" + q.write(fr1))

  //print("2nd :" + q.write(f1))--This won't work

  print("3rd :" + q.write(o1))
  print("4th :" + q.write(b1))
  print("5th :" + q.write(a1))
  print("6th :" + q.write(v2))

  //print("7th :" + q.write(v1))--This won't work
}