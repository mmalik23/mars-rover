package mars

import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable.ArrayBuffer

class MarsTest extends AnyFunSuite {

  test("Can make a grid and show the world!") {
    val messages = new ArrayBuffer[String]()

    new Mars(messages.append, 1, 2).run()

    assert(messages.toList ===
      List(
        "Welcome to Mars! Mars has a waistline of 1 blocks and a height of 2 blocks",
        "Welcome to Mars! Mars has a waistline of 1 blocks and a height of 2 blocks", "The rover is currently sitting at (0,1), facing North"
      ))

  }

}
