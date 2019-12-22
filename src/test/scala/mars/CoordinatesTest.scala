package mars

import org.scalatest.funsuite.AnyFunSuite

class CoordinatesTest extends AnyFunSuite {

  val grid: Grid = Grid(4, 5)

  test("can get some coordinates") {
    assert(Coordinates(3,4).translate(grid)  == Coordinates(3,4))
  }

  test("returns on opposite side of grid (zero indexed)") {
    assert(Coordinates(4,5).translate(grid)  == Coordinates(0,0))

  }

  test("negative coordinates should end up on other side of board") {
    assert(Coordinates(-1, -1).translate(grid)  == Coordinates(3,4))
  }

  test("negative coordinates at limit should translate to start of board") {
    assert(Coordinates(-4, -5).translate(grid)  == Coordinates(0,0))
  }

  test("bigger negative coordinates should end up on other side of board") {
    assert(Coordinates(-5, -6).translate(grid)  == Coordinates(3,4))
  }


}
