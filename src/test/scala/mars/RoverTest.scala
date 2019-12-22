package mars

import org.scalatest.funsuite.AnyFunSuite
import Direction._

class RoverTest extends AnyFunSuite {
  val rover = Rover(0, 0, North)

  test("rover should change direction when rotated clockwise") {
    assert(rover.relocate(RotateClockwise) == Rover(0, 0, East))
  }

  test("rover should change direction when rotated anti clockwise") {
    assert(rover.relocate(RotateAntiClockwise) == Rover(0, 0, West))
  }

  test("can move rover forward nortwards") {
    assert(rover.relocate(MoveForward) == Rover(0, 1, North))
  }

  test("can move rover forward eastwards") {
    val rover = Rover(0, 0, East)
    assert(rover.relocate(MoveForward) == Rover(1, 0, East))
  }

  test("can move rover forward westwards") {
    val rover = Rover(0, 0, West)
    assert(rover.relocate(MoveForward) == Rover(-1, 0, West))
  }

  test("can move rover forward southwards") {
    val rover = Rover(0, 0, South)
    assert(rover.relocate(MoveForward) == Rover(0, -1, South))
  }

}
