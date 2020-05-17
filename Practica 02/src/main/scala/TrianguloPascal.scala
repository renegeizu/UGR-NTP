object TrianguloPascal extends App {

  def calcularValorTrianguloPascal(fila: Int, columna: Int): Int = {
    if (fila < columna) {
      -1
    }else if (columna == 0 || columna == fila) {
      1
    } else {
      calcularValorTrianguloPascal(fila - 1, columna) + calcularValorTrianguloPascal(fila - 1, columna - 1)
    }
  }

  def generarTriangulo(filas: Int): Unit = {
    for (fila <- 0 to filas) {
      for (columna <- 0 to fila) {
        print(calcularValorTrianguloPascal(fila, columna) + " ")
      }

      println("")
    }

    println("")
  }

  def test(): Unit = {
    println("Triangulo de Pascal (Test)" + "\n")

    generarTriangulo(10)

    println("El valor para (15, 10) es " + calcularValorTrianguloPascal(15, 10))
    println("El valor para (10, 15) es " + calcularValorTrianguloPascal(10, 15))
    println("El valor para (10, 10) es " + calcularValorTrianguloPascal(10, 10))
    println("El valor para (15, 15) es " + calcularValorTrianguloPascal(15, 15))
    println("El valor para (3, 2) es " + calcularValorTrianguloPascal(3, 2))
  }

  test()
}