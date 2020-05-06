import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll

object BusquedaSaltosTest extends Properties("Busqueda a Saltos Generica") {

  private val MAXIMO = 100
  private val COMPARADOR_INT = (x: Int, y: Int) => x < y

  val generarEnteros: Gen[List[Int]] = Gen.listOf(Gen.choose(0, MAXIMO))

  property("Comprobar Busqueda Binaria - Integer") = forAll(generarEnteros){
    (list) => {
      val listaOrdenada = list.sorted
      val elemento = Gen.choose(0, MAXIMO).sample.getOrElse(0)
      val indice = listaOrdenada.indexOf(elemento)

      indice == BusquedaSaltos.busquedaSaltos[Int](listaOrdenada.toArray, elemento, COMPARADOR_INT)
    }
  }

}