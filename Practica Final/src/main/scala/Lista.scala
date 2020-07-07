import java.security.InvalidParameterException

/**
 * Clase Lista
 * La Representacion de Listas, Similares a las Proporcionadas por Scala, pero Implementada por Nosotros.
 * En este Caso se Define la Estructura de Clases a Usar
 */

/**
 * Interfaz Generica para la Lista
 * @tparam A
 */
sealed trait Lista[+A]

/**
 * Objeto para Definir Lista Vacia
 */
case object Nil extends Lista[Nothing]

/**
 * Clase para Definir la Lista como Compuesta por Elemento Inicial (Cabeza) y Resto (Cola)
 * @param cabeza
 * @param cola
 * @tparam A
 */
case class Cons[+A](cabeza : A, cola : Lista[A]) extends Lista[A]

/**
 * Objeto que Contiene las Funciones de la Lista
 */
object Lista {

  /**
   * Metodo para Permitir Crear Listas sin Usar New
   * @param elementos Secuencia de Elementos a Incluir en la Lista
   * @tparam A
   * @return
   */
  def apply[A](elementos : A*) : Lista[A] = {
    if (elementos.isEmpty) {
      Nil
    } else {
      Cons(elementos.head, apply(elementos.tail: _*))
    }
  }

  /**
   * Obtiene la Longitud de una Lista
   * @param lista
   * @tparam A
   * @return
   */
  def longitud[A](lista : Lista[A]) : Int = {
    lista match {
      case Nil => 0
      case Cons(_, cola) => longitud(cola) + 1
    }
  }

  /**
   * Metodo para Sumar los Valores de una Lista de Enteros
   * @param enteros
   * @return
   */
  def sumaEnteros(enteros : Lista[Int]) : Double = {
    enteros match {
      case Nil => 0
      case Cons(cabeza, cola) => cabeza.toDouble + sumaEnteros(cola)
    }
  }

  /**
   * Metodo para Multiplicar los Valores de una Lista de Enteros
   * @param enteros
   * @return
   */
  def productoEnteros(enteros : Lista[Int]) : Double = {
    enteros match {
      case Nil => 1
      case Cons(cabeza, cola) => cabeza.toDouble * productoEnteros(cola)
    }
  }

  /**
   * Metodo para Agregar el Contenido de Dos Listas
   * @param lista1
   * @param lista2
   * @tparam A
   * @return
   */
  def concatenar[A](lista1: Lista[A], lista2: Lista[A]): Lista[A] = {
    lista1 match {
      case Nil => lista2
      case Cons(cabeza, cola) => Cons(cabeza, concatenar(cola, lista2))
    }
  }

  /**
   * Funcion de Utilidad para Aplicar una Funcion de Forma Sucesiva a los Elementos de la Lista
   * @param lista
   * @param neutro
   * @param funcion
   * @tparam A
   * @tparam B
   * @return
   */
  def foldRight[A, B](lista : Lista[A], neutro : B)(funcion : (A, B) => B): B = {
    lista match {
      case Nil => neutro
      case Cons(cabeza, cola) => funcion(cabeza, foldRight(cola, neutro)(funcion))
    }
  }

  /**
   * Suma Mediante foldRight
   * @param listaEnteros
   * @return
   */
  def sumaFoldRight(listaEnteros : Lista[Int]) : Double = {
    foldRight(listaEnteros, 0)((x, y) => x + y)
  }

  /**
   * Producto Mediante foldRight
   * @param listaEnteros
   * @return
   */
  def productoFoldRight(listaEnteros : Lista[Int]) : Double = {
    foldRight(listaEnteros, 0)((x, y) => x * y)
  }

  /**
   * Reemplaza la Cabeza por Nuevo Valor. Se Asume que si la Lista esta Vacia se Devuelve una Lista con el Nuevo Elemento
   * @param lista
   * @param cabezaNueva
   * @tparam A
   * @return
   */
  def asignarCabeza[A](lista : Lista[A], cabezaNueva : A) : Lista[A] = {
    lista match {
      case Nil => Cons(cabezaNueva, Nil)
      case Cons(_, cola) => Cons(cabezaNueva, cola)
    }
  }

  /**
   * Obtiene el Elemento que Ocupa la Cabeza de la Lista
   *
   * @param lista
   * @tparam A
   * @return
   */
  def obtenerCabeza[A](lista : Lista[A]): A = lista match {
    case Nil => throw new InvalidParameterException
    case Cons(cabeza, _) => cabeza
  }

  /**
   * Elimina el Elemento Cabeza de la Lista y Devuelve la Lista con el Resto de Elementos
   * @param lista
   * @tparam A
   * @return
   */
  def obtenerCola[A](lista : Lista[A]): Lista[A] = lista match {
    case Nil => Nil
    case Cons(_, cola) => cola
  }

  /**
   * Elimina los N Primeros Elementos de una Lista
   * @param lista Lista con la que Trabajar
   * @param n numero de elementos a eliminar
   * @tparam A tipo de datos
   * @return
   */
  def eliminar[A](lista : Lista[A], n: Int) : Lista[A] =  {
    if (0 == n) {
      return lista
    }

    lista match {
      case Nil => Nil
      case Cons(_, cola) => eliminar(cola, n - 1)
      case _ => lista
    }
  }

  /**
   * Elimina Elementos Mientras se Cumple la Condicion Pasada Como Argumento
   * @param lista lista con la que trabajar
   * @param criterio predicado a considerar para continuar con el borrado
   * @tparam A tipo de datos a usar
   * @return
   */
  def eliminarMientras[A](lista : Lista[A], criterio: A => Boolean) : Lista[A] = {
    lista match {
      case Nil => Nil
      case Cons(cabeza, cola) =>
        if (criterio(cabeza)) {
          eliminarMientras(cola, criterio)
        } else {
          lista
        }
    }
  }

  /**
   * Elimina el Ultimo Elemento de la Lista. Aqui no se Pueden Compartir Datos en los Objetos y Hay que Generar una
   * Nueva Lista Copiando Datos
   * @param lista lista con la que trabajar
   * @tparam A tipo de datos de la lista
   * @return
   */
  def eliminarUltimo[A](lista : Lista[A]) : Lista[A] = {
    if (1 == longitud(lista)) {
      return Nil
    }

    lista match {
      case Nil => Nil
      case Cons(cabeza, cola) => Cons(cabeza, eliminarUltimo(cola))
    }
  }

  /**
   * foldLeft con Recursividad Tipo Tail
   * @param lista Lista con la que Trabajar
   * @param neutro Elemento Neutro
   * @param funcion Funcion a Aplicar
   * @tparam A Parametros de Tipo de Elementos de la Lista
   * @tparam B Parametro de Tipo del Elemento Neutro
   * @return
   */
  @annotation.tailrec
  def foldLeft[A, B](lista : Lista[A], neutro: B)(funcion : (B, A) => B): B = {
    lista match {
      case Nil => neutro
      case Cons(cabeza, cola) => foldLeft(cola, funcion(neutro, cabeza))(funcion)
    }
  }

  /** Suma Via foldLeft
   * @param lista
   * @return
   */
  def sumaFoldLeft(lista : Lista[Int]): Int = {
    foldLeft(lista, 0)((x, y) => x + y)
  }

  /** Producto Via foldLeft
   * @param lista
   * @return
   */
  def productoFoldLeft(lista : Lista[Int]): Int = {
    foldLeft(lista, 0)((x, y) => x * y)
  }

  /**
   * Metodo de Filtrado para Quedarnos con los Elementos que Cumplen una Determinada Condicion
   * @param lista
   * @param criterio
   */
  def filtrar(lista:Lista[Int])(criterio : (Int) => Boolean): Lista[Int] = {
    lista match {
      case Nil => Nil
      case Cons(cabeza, cola) =>
        if (criterio(cabeza)) {
          Cons(cabeza, filtrar(cola)(criterio))
        } else {
          filtrar(cola)(criterio)
        }
    }
  }

  /**
   * Metodo para Mostrar el Contenido de la Lista
   * @param lista
   * @return
   */
  def mostrar(lista : Lista[Int]) : Unit = {
    lista match {
      case Nil => Nil
      case Cons(cabeza, cola) => {
        print("\"" + cabeza + "\" ")
        mostrar(cola)
      }
    }
  }

  /**
   * Convierte un elemento de tipo Lista a tipo List
   * @param list - elemento que se quiere convertir
   * @tparam A - tipo de valores que contiene la lista
   * @return lista de tipo List
   */
  def toList[A](list : Lista[A]): List[A] = {
    list match {
      case Nil => List()
      case Cons(cabeza, cola) => cabeza::toList(cola)
    }
  }
}