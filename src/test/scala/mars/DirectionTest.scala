package mars

import org.scalatest.funsuite.AnyFunSuite
import Direction._

class DirectionTest extends AnyFunSuite {

  test("clockwise are working properly") {

    assert(
      List(North, South, East, West)
        .map(Direction.clockwise)  === List(East, West, South, North)
    )
  }

  test("anticlockwise are working properly") {

    assert(
      List(North, South, East, West)
        .map(Direction.anticlockwise)  === List(West, East, North, South)
    )

  }
}
