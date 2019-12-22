package mars

sealed trait Command

case object MoveForward extends Command
case object RotateAntiClockwise extends Command
case object RotateClockwise extends Command
