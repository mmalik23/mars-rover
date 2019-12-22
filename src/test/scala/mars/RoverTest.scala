package mars

import org.scalatest.funsuite.AnyFunSuite
import Direction._

class RoverTest extends AnyFunSuite {
  val rover = Rover(Coordinates(0, 0), North)

  test("rover should change direction when rotated clockwise") {
    assert(rover.relocate(RotateClockwise) == rover.copy(direction = East))
  }

  test("rover should change direction when rotated anti clockwise") {
    assert(rover.relocate(RotateAntiClockwise) == rover.copy(direction = West))
  }

  test("can move rover forward nortwards") {
    assert(rover.relocate(MoveForward) == rover.copy(coordinates = Coordinates(0, 1)))
  }

  test("can move rover forward eastwards") {
    val rover = Rover(Coordinates(0, 0), East)
    assert(rover.relocate(MoveForward) ==  rover.copy(coordinates = Coordinates(1, 0)))
  }

  test("can move rover forward westwards") {
    val rover = Rover(Coordinates(0, 0), West)
    assert(rover.relocate(MoveForward) == rover.copy(coordinates = Coordinates(-1, 0)))
  }

  test("can move rover forward southwards") {
    val rover = Rover(Coordinates(0, 0), South)
    assert(rover.relocate(MoveForward) == rover.copy(coordinates = Coordinates(0, -1)))
  }

}
