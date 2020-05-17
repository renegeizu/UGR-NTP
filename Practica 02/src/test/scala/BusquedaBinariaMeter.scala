import BusquedaBinaria.busquedaBinaria
import org.scalameter.api._

object BusquedaBinariaMeter extends Bench.LocalTime {

  private val COMPARADOR_INT = (x: Int, y: Int) => x < y

  val ranges: Gen[Range] = for {
    size <- Gen.range("size")(10000, 100000, 10000)
  } yield 0 until size

  performance of "Busqueda" config(
    exec.benchRuns -> 10,
    exec.independentSamples -> 10
  ) in {
    measure method "Busqueda Binaria" in {
      using(ranges) curve "Busqueda Binaria" in {
        r => {
          busquedaBinaria[Int](r.toArray, r(10), COMPARADOR_INT)
        }
      }
    }
  }

}
