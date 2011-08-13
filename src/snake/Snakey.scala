package snake

import processing.core._

object Snakey extends PApplet {
  def main(args: Array[String]) {
    val game = new Snakey
    val frame = new javax.swing.JFrame("Snakey")
    frame.getContentPane().add(game)
    game.init

    frame.pack
    frame.setVisible(true)
  }
}

class Snakey extends PApplet {
  val black = 0
  val white = 255
  val gridSize = 100
  val screenSize = 1000

  var fruit = new Fruit
  val snake = new Snake

  val boxThickness = screenSize / gridSize

  override def setup() = {
    size(screenSize, screenSize)
    background(black)
    frameRate(15)
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

    background(black)
    fill(white)
    println("drawing")
    snake.parts.foreach { part =>
      rect(part.coordinates._2 * boxThickness, part.coordinates._1 * boxThickness, boxThickness, boxThickness)
    }
    fill(255, 0, 0)
    rect(fruit.coordinates._2 * boxThickness, fruit.coordinates._1 * boxThickness, boxThickness, boxThickness)
    snake.updateSnake
    if (snake.parts.last.coordinates == fruit.coordinates) {
      fill(0)
      rect(fruit.coordinates._2 * boxThickness, fruit.coordinates._1 * boxThickness, boxThickness, boxThickness)
      fruit = new Fruit
    }
  }
}