package snake
import scala.collection.mutable

class Snake {
  var parts = mutable.IndexedSeq(new BodyPart((41, 50), "down"))

  def updateSnake {
    parts.zipWithIndex.foreach {
      case (p, i) =>
        if (i == parts.length - 1) {
          p.direction match {
            case "up" => p.coordinates = (p.coordinates._1 - 1, p.coordinates._2)
            case "down" => p.coordinates = (p.coordinates._1 + 1, p.coordinates._2)
            case "left" => p.coordinates = (p.coordinates._1, p.coordinates._2 - 1)
            case "right" => p.coordinates = (p.coordinates._1, p.coordinates._2 + 1)
          }
        } else {
          parts(i).coordinates = parts(i + 1).coordinates
        }
    }
  }
  def grow {
    val tail = parts.first
    val newTail = tail.direction match {
      case "up" => new BodyPart((tail.coordinates._1 + 1, tail.coordinates._2), tail.direction)
      case "down" => new BodyPart((tail.coordinates._1 - 1, tail.coordinates._2), tail.direction)
      case "left" => new BodyPart((tail.coordinates._1, tail.coordinates._2 + 1), tail.direction)
      case "right" => new BodyPart((tail.coordinates._1, tail.coordinates._2 - 1), tail.direction)
    }
    parts = newTail +: parts
  }
}