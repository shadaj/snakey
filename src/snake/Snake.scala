package snake

class Snake(gridSize: Int) {
  var parts = List(new BodyPart((gridSize/2, gridSize/2), "down"))

  def updateSnake {
    val p: BodyPart = parts.last
    parts = parts.tail :+
    	 (p.direction match {
            case "up" => p.copy(coordinates = (p.coordinates._1, p.coordinates._2 - 1))
            case "down" => p.copy(coordinates = (p.coordinates._1, p.coordinates._2 + 1))
            case "left" => p.copy(coordinates = (p.coordinates._1 - 1, p.coordinates._2))
            case "right" => p.copy(coordinates = (p.coordinates._1 + 1, p.coordinates._2))
          })
  }
  
  def grow {
    val tail = parts.first
    val newTail = tail.direction match {
      case "up" => new BodyPart((tail.coordinates._1, tail.coordinates._2 + 1), tail.direction)
      case "down" => new BodyPart((tail.coordinates._1, tail.coordinates._2 - 1), tail.direction)
      case "left" => new BodyPart((tail.coordinates._1 + 1, tail.coordinates._2), tail.direction)
      case "right" => new BodyPart((tail.coordinates._1 - 1, tail.coordinates._2), tail.direction)
    }
    parts = newTail +: parts
  }
}