package snake

class Fruit(gridWidth: Int, gridHeight: Int) {
  val coordinates = ((Math.random * gridWidth).toInt, (Math.random * gridHeight).toInt)
}