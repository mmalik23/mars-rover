package mars

import scala.io.StdIn
import scala.util.Random

class Mars(
            writer: String => Unit =  println,
            rows : => Int =  Random.between(10,100),
            columns : => Int = Random.between(10,100)
          ) {
  def run(): Unit = {
    val grid = Grid(rows, columns)
    val initialRover = Rover(Coordinates(rows/ 2, columns /2), Direction.North)
    writer(grid.toString())
    writer(initialRover.toString())
  }
}

object Mars {
  def main(args:Array[String]): Unit = new Mars().run()
}

case class Rover(coordinates: Coordinates, direction: Direction.Direction) {
  import Direction._
  def relocate(command: Command): Rover = command match {
    case MoveForward         => direction match {
      case North => Rover(coordinates.moveVertically(1), direction)
      case East  => Rover(coordinates.moveHorizontally(1), direction)
      case South => Rover(coordinates.moveVertically(- 1), direction)
      case West  => Rover(coordinates.moveHorizontally(- 1), direction)
    }
    case RotateAntiClockwise => Rover(coordinates, Direction.anticlockwise(direction))
    case RotateClockwise     => Rover(coordinates, Direction.clockwise(direction))
  }

  override def toString: String = s"The rover is currently sitting at $coordinates, facing $direction"
}

case class Coordinates(x: Int, y: Int) {

  def moveHorizontally(delta: Int): Coordinates = Coordinates(x + delta, y)

  def moveVertically(delta: Int): Coordinates = Coordinates(x, y + delta)

  def translate(grid: Grid): Coordinates = {
    def t(coordinate: Int, length: Int) = ((coordinate % length) + length) % length
    Coordinates(t(x, grid.rows), t(y,grid.columns))
  }

  override def toString = s"($x,$y)"
}

case class Grid(rows: Int, columns: Int) {
  override def toString =
    s"Welcome to Mars! Mars has a waistline of $rows blocks and a height of $columns blocks"
}
