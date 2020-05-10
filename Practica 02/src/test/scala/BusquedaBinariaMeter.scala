import org.scalameter.api._

object BusquedaBinariaMeter extends Bench.LocalTime {

  private val MINIMO = 0
  private val MAXIMO = 100
  private val COMPARADOR_INT = (x: Int, y: Int) => x < y

  val ranges: Gen[Range] = for {
    size <- Gen.range("size")(1000, 100000, 1000)
  } yield 0 until size

  measure method "map" in {
    using(ranges) curve("Range") in {
      list => {
        val listaOrdenada = list.sorted

        BusquedaBinaria.busquedaBinaria[Int](listaOrdenada.toArray, list(list.length/2), COMPARADOR_INT)

        BusquedaBinaria.busquedaBinaria[Int](listaOrdenada.toArray, list(list.length/5), COMPARADOR_INT)

        BusquedaBinaria.busquedaBinaria[Int](listaOrdenada.toArray, list(list.length/10), COMPARADOR_INT)
      }
    }
  }

}
