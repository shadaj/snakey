package snake

import processing.core._

object Snakey {
  def main(args: Array[String]) {
    val game = new Snakey
    val frame = new javax.swing.JFrame("Snakey")
    frame.add(game)
    game.init

    frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE)
    frame.pack
    frame.setVisible(true)
  }
}

class Snakey extends PApplet {
  val black = 0
  val white = 255
  val gridSize = 50
  val screenSize = 500
  
  var red = 255
  var fruit = new Fruit(gridSize, gridSize)
  val snake = new Snake(gridSize)

  val boxThickness = screenSize / gridSize

  override def setup() = {
    size(screenSize, screenSize)
    background(white)
    frameRate(10)
  }

  override def draw() = {
    setFocusable(true)
    if (keyPressed) {
      println("keyed")
      keyCode match {
        case PConstants.UP => snake.parts.last.direction = "up"
        case PConstants.DOWN => snake.parts.last.direction = "down"
        case PConstants.LEFT => snake.parts.last.direction = "left"
        case PConstants.RIGHT => snake.parts.last.direction = "right"
      }
    }

    background(white)
    fill(0, 255, 0)
    println("drawing")
    snake.parts.foreach { part =>
      rect(part.coordinates._1 * boxThickness, part.coordinates._2 * boxThickness, boxThickness, boxThickness)
    }
    fill(red, 0, 0)
    rect(fruit.coordinates._1 * boxThickness,fruit.coordinates._2 * boxThickness, boxThickness, boxThickness)
    snake.updateSnake
    red = red - 1
    if (snake.parts.last.coordinates == fruit.coordinates || red == 0) {
      fill(white)
      rect(fruit.coordinates._1 * boxThickness,fruit.coordinates._2 * boxThickness, boxThickness, boxThickness)
      snake.grow
      val dim = getSize()
      println(dim)
      fruit = new Fruit(dim.width/boxThickness, dim.height/boxThickness)
      red = 255
    }
  }
}