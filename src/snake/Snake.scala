package snake
import scala.collection.mutable

class Snake {
  val parts = mutable.IndexedSeq(new BodyPart((41, 50), "down"), new BodyPart((42, 50), "down"), new BodyPart((43, 50), "down"), new BodyPart((44, 50), "down"), new BodyPart((45, 50), "down"), new BodyPart((46, 50), "down"), new BodyPart((47, 50), "down"), new BodyPart((48, 50), "down"), new BodyPart((49, 50), "down"), new BodyPart((50, 50), "down"))

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
}