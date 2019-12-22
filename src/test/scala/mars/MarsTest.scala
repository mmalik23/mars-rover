package mars

import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable.ArrayBuffer

class MarsTest extends AnyFunSuite {

  test("Can make a grid, show the world! and end the game!") {
    val messages = new ArrayBuffer[String]()

    new Mars(messages.append, () => "e", 1, 2).run()

    assert(messages.toList ===
      List(
        "Welcome to Mars! Mars has a waistline of 1 blocks and a height of 2 blocks",
        "The rover is at coordinates (0,1), facing North",
        "w: Move Forward",
        "a: Rotate anti-clockwise",
        "d: Rotate clockwise",
        "e: to end game",
        "remember to press enter afterwards!",
        "cya"
      )
    )



  }

}
