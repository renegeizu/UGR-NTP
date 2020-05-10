object SeriesRecurrentes extends App {

  def seriesRecurrentes[A](i0: Int, i1: Int, iesimo: Int, sucesion: (Int, Int) => Int): Int = {

    @annotation.tailrec
    def secuenciar(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => secuenciar(n - 1, b, sucesion(a, b))
    }

    if (iesimo > 0) {
      secuenciar(iesimo, i0, i1)
    } else {
      -1
    }
  }

  def test(): Unit = {

    println("Series Definidas de Forma Recurrente" + "\n")

    println("Serie de Fibonacci (2): " + seriesRecurrentes(0, 1, 2, (a, b) => a + b) + "\n")
    println("Serie de Fibonacci (3): " + seriesRecurrentes(0, 1, 3, (a, b) => a + b) + "\n")
    println("Serie de Fibonacci (4): " + seriesRecurrentes(0, 1, 4, (a, b) => a + b) + "\n")
    println("Serie de Fibonacci (5): " + seriesRecurrentes(0, 1, 5, (a, b) => a + b) + "\n")

    println("Serie de Lucas (2): " + seriesRecurrentes(2, 1, 2, (a, b) => a + b) + "\n")
    println("Serie de Lucas (3): " + seriesRecurrentes(2, 1, 3, (a, b) => a + b) + "\n")
    println("Serie de Lucas (4): " + seriesRecurrentes(2, 1, 4, (a, b) => a + b) + "\n")
    println("Serie de Lucas (5): " + seriesRecurrentes(2, 1, 5, (a, b) => a + b) + "\n")

    println("Serie de Pell (2): " + seriesRecurrentes(2, 6, 2, (a, b) => 2 * b + a) + "\n")
    println("Serie de Pell (3): " + seriesRecurrentes(2, 6, 3, (a, b) => 2 * b + a) + "\n")
    println("Serie de Pell (4): " + seriesRecurrentes(2, 6, 4, (a, b) => 2 * b + a) + "\n")
    println("Serie de Pell (5): " + seriesRecurrentes(2, 6, 5, (a, b) => 2 * b + a) + "\n")

    println("Serie de Pell - Lucas (2): " + seriesRecurrentes(2, 2, 2, (a, b) => 2 * b + a) + "\n")
    println("Serie de Pell - Lucas (3): " + seriesRecurrentes(2, 2, 3, (a, b) => 2 * b + a) + "\n")
    println("Serie de Pell - Lucas (4): " + seriesRecurrentes(2, 2, 4, (a, b) => 2 * b + a) + "\n")
    println("Serie de Pell - Lucas (5): " + seriesRecurrentes(2, 2, 5, (a, b) => 2 * b + a) + "\n")

    println("Serie de Jacobsthal (2): " + seriesRecurrentes(0, 1, 2, (a, b) => b + 2 * a) + "\n")
    println("Serie de Jacobsthal (3): " + seriesRecurrentes(0, 1, 3, (a, b) => b + 2 * a) + "\n")
    println("Serie de Jacobsthal (4): " + seriesRecurrentes(0, 1, 4, (a, b) => b + 2 * a) + "\n")
    println("Serie de Jacobsthal (5): " + seriesRecurrentes(0, 1, 5, (a, b) => b + 2 * a) + "\n")
  }

  test()
}
