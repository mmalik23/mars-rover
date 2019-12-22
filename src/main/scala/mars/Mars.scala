package mars

import scala.io.StdIn
import scala.util.Random

class Mars(
            writer: String => Unit = println,
            input:  () => String = StdIn.readLine,
            rows : Int =  Random.between(10,100),
            columns : Int = Random.between(10,100)
          ) {

  def run(): Unit = {
    val grid = Grid(rows, columns)
    val initialRover = Rover(Coordinates(rows/ 2, columns /2), Direction.North)
    writer(grid.toString())
    writer(initialRover.toString())
    writer("w: Move Forward")
    writer("a: Rotate anti-clockwise")
    writer("d: Rotate clockwise")
    writer("e: to end game")
    writer("remember to press enter afterwards!")

    letsPlay(grid, input)(initialRover)

  }

  final def letsPlay(grid: Grid, input: () => String)(rover: Rover): Unit = {

    val recurse = letsPlay(grid, input) _
    def translate(rover: Rover): Rover = rover.copy(coordinates = rover.coordinates.translate(grid))
    def consoleLog(rover: Rover): Rover = {
      writer(rover.toString)
      rover
    }
    val f = (rover.relocate _).andThen(translate).andThen(consoleLog).andThen(recurse)

    input() match {
      case "w" => f(MoveForward)
      case "a" => f(RotateAntiClockwise)
      case "d" => f(RotateClockwise)
      case "e" => writer("cya")
      case _ =>
        writer("something weird happened: try agauin")
        recurse(rover)

    }
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

  override def toString: String = s"The rover is at coordinates $coordinates, facing $direction"
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
