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

  println("Series Definidas de Forma Recurrente" + "\n")

  val fibonacci = seriesRecurrentes(0, 1, 5, (a, b) => a + b)
  println("Serie de Fibonacci" + fibonacci + "\n")

  val lucas = seriesRecurrentes(2, 1, 5, (a, b) => a + b)
  println("Serie de Lucas" + lucas + "\n")

  val pell = seriesRecurrentes(2, 6, 5, (a, b) => 2 * a + b)
  println("Serie de Pell" + pell + "\n")

  val pell_lucas = seriesRecurrentes(2, 2, 5, (a, b) => 2 * a + b)
  println("Serie de Pell - Lucas" + pell_lucas "\n")

  val jacobsthal = seriesRecurrentes(0, 1, 5, (a, b) => a + 2 * b)
  println("Serie de Jacobsthal" + jacobsthal + "\n")

}
