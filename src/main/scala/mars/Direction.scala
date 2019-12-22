package mars

object Direction extends Enumeration {
  type Direction = Value
  val North, East, South, West = Value

  def clockwise(direction: Direction.Direction): mars.Direction.Value =
    Direction.values.find(d => d.id == direction.id + 1).getOrElse(North)

  def anticlockwise(direction: Direction.Direction): mars.Direction.Value =
    Direction.values.find(d => d.id == direction.id - 1).getOrElse(West)
}
