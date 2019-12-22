package mars

import scala.util.Random

class Mars(
            writer: String => Unit =  println,
            rows : => Int =  Random.between(10,100),
            columns : => Int = Random.between(10,100)
          ) {
  def run(): Unit = {
    val grid = Grid(rows, columns)
    writer(grid.toString())
  }
}

object Mars {
  def main(args:Array[String]) = new Mars().run()
}



case class Grid(rows: Int, columns: Int) {
  override def toString() =
    s"Welcome to Mars! Mars has a waistline of $rows blocks and a height of $columns blocks"
}
