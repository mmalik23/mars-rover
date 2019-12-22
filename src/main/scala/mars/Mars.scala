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

case class Rover(x: Int, y: Int, direction: Direction.Direction) {
  import Direction._
  def relocate(command: Command): Rover = command match {
    case MoveForward         => direction match {
      case North => Rover(x, y + 1, direction)
      case East  => Rover(x + 1, y, direction)
      case South => Rover(x , y -1, direction)
      case West  => Rover(x -1, y, direction)
    }
    case RotateAntiClockwise => Rover(x, y, Direction.anticlockwise(direction))
    case RotateClockwise     => Rover(x, y, Direction.clockwise(direction))
  }
}


case class Grid(rows: Int, columns: Int) {
  override def toString() =
    s"Welcome to Mars! Mars has a waistline of $rows blocks and a height of $columns blocks"
}
