import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

import scala.util.Random

object ListaCheck extends Properties("Test de la Clase Lista") {

  val numberGen: Gen[List[Int]] = Gen.listOf(Gen.choose(0, 10))

  /**
   * Comprueba que la Longitud Obtenida es Igual que la Longitud Obtenida por List
   */
  property("Metodo Longitud") = forAll(numberGen) {
    list => Lista.longitud(Lista(list: _*)) == list.length
  }

  /**
   * Comprueba que se Suma Correctamente la Lista comparando con el metodo de List
   * (Como Podia Alcanzar Valores Altos, he Tenido que Convertir los Valores a Double)
   */
  property("Metodo SumaEnteros") = forAll(numberGen) {
    list => Lista.sumaEnteros(Lista(list: _*)) == list.map(_.toDouble).sum
  }

  /**
   * Comprueba que se Multiplica Correctamente la Lista comparando con el metodo de List
   * (Como alcanza Valores Altos, he Tenido que Convertir los Valores a Double)
   */
  property("Metodo ProductoEnteros") = forAll(numberGen) {
    list => Lista.productoEnteros(Lista(list: _*)) == list.map(_.toDouble).product
  }

  /**
   * Comprueba la Concatenacion Comparando con el Operador de Concatenacion de List
   */
  property("Metodo Concatenar") = forAll(numberGen) {
    list => Lista.toList(Lista.concatenar(Lista(list: _*), Lista(list: _*))) == list ::: list
  }

  /**
   * Comprueba el Metodo FoldRight con la Resta, ya que la Suma y la Multiplicacion estan
   * Implementadas
   */
  property("Metodo FoldRight") = forAll(numberGen) {
    list => Lista.foldRight(Lista(list: _*), 0)((x, y) => x - y) == list.foldRight(0)((x, y) => x - y)
  }

  /**
   * Comprueba el Metodo FoldRight con la Suma
   */
  property("Metodo SumaFoldRight") = forAll(numberGen) {
    list => Lista.sumaFoldRight(Lista(list: _*)) == list.foldRight(0)((x, y) => x + y)
  }

  /**
   * Comprueba el Metodo FoldRight con la Multiplicacion
   */
  property("Metodo ProductoFoldRight") = forAll(numberGen) {
    list => Lista.productoFoldRight(Lista(list: _*)) == list.foldRight(0)((x, y) => x * y)
  }

  /**
   * Compara el Metodo Updated de List para Comprobar que Asigna Correctamente el Nuevo Valor
   * Para la Cabeza
   */
  property("Metodo AsignarCabeza") = forAll(numberGen) {
    list => {
      val cabeza = Gen.choose(0, 10)

      if (list.nonEmpty) {
        Lista.toList(Lista.asignarCabeza(Lista(list: _*), cabeza)) == list.updated(0, cabeza)
      } else {
        true
      }
    }
  }

  /**
   * Devuelve el Valor que Esta en la Cabeza
   */
  property("Metodo ObtenerCabeza") = forAll(numberGen) {
    list => {
      if (list.nonEmpty) {
        Lista.obtenerCabeza(Lista(list: _*)) == list.head
      } else {
        true
      }
    }
  }

  /**
   * Comprueba que se Elimina un Valor de la Lista Correctamente
   */
  property("Metodo Eliminar") = forAll(numberGen) {
    list => {
      if (list.nonEmpty) {
        val elemento = Random.nextInt(list.size)

        Lista.toList(Lista.eliminar(Lista(list: _*), elemento)) == list.drop(elemento)
      } else {
        true
      }
    }
  }

  /**
   * Elimina los Valores de la Lista Mientras se Cumpla la Condicion (Criterio) Dada
   * Se comprara con el Metodo DropWhile de List
   */
  property("Metodo EliminarMientras") = forAll(numberGen) {
    list => {
      if (list.nonEmpty) {
        val criterio = (a: Int) => 3 < a && a < 7

        Lista.toList(Lista.eliminarMientras(Lista(list: _*), criterio)) == list.dropWhile(criterio)
      } else {
        true
      }
    }
  }

  /**
   * Elimina el Ultimo Valor de la Lista
   * Se Compara con el Metodo DropRight que Elimina el Valor de la Posicion Dada
   * Empezando a Contar por la Derecha
   */
  property("Metodo EliminarUltimo") = forAll(numberGen) {
    list => Lista.toList(Lista.eliminarUltimo(Lista(list: _*))) == list.dropRight(1)
  }

  /**
   * Comprueba el Metodo FoldLeft con Recursividad Tail para la Resta
   */
  property("Metodo FoldLeft (Tail)") = forAll(numberGen) {
    list => Lista.foldLeft(Lista(list: _*), 0)((x, y) => x - y) == list.foldLeft(0)((x, y) => x - y)
  }

  /**
   * Comprueba que el Metodo SumaFoldLeft realiza la Operacion Correctamente
   */
  property("Metodo SumaFoldLeft") = forAll(numberGen) {
    list => Lista.sumaFoldLeft(Lista(list: _*)) == list.foldLeft(0)((x, y) => x + y)
  }

  /**
   * Comprueba que el Metodo ProductoFoldLeft realiza la Operacion Correctamente
   * Comparando con el Metodo FoldLeft de List que recibe la Operacion a Realizar
   */
  property("Metodo ProductoFoldLeft") = forAll(numberGen) {
    list => Lista.productoFoldLeft(Lista(list: _*)) == list.foldLeft(0)((x, y) => x * y)
  }

}