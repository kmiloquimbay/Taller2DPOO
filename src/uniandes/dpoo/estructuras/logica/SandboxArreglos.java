package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;
    
    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
        
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
        int copia_enteros[] = new int[arregloEnteros.length];
        for (int i = 0; i < arregloEnteros.length; i++) {
        	copia_enteros[i] = arregloEnteros[i];
        }
  
        return copia_enteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {	
    	String copia_cadenas[] = new String[arregloCadenas.length];
        for (int i = 0; i < arregloCadenas.length; i++) {
        	copia_cadenas[i] = arregloCadenas[i];
        }
  
        return copia_cadenas;
    }
    
    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {	
    	int cantidad_enteros = arregloEnteros.length;
        return cantidad_enteros;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int cantidad_cadenas = arregloCadenas.length;
        return cantidad_cadenas;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int total = getCantidadEnteros();
    	int nuevoArreglo[]= new int[total + 1];
    	for (int i = 0; i < arregloEnteros.length; i++ ) {
    		nuevoArreglo[i] = arregloEnteros[i];
    	}
    	nuevoArreglo[total] = entero;
    	arregloEnteros = nuevoArreglo;
    	
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {	
    	int total = getCantidadCadenas();
    	String nuevoArreglo[]= new String[total + 1];
    	for (int i = 0; i < arregloCadenas.length; i++ ) {
    		nuevoArreglo[i] = arregloCadenas[i];
    	}
    	nuevoArreglo[total] = cadena;
    	arregloCadenas = nuevoArreglo;
    }
    
    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {	
    	int contador = 0;
    	for (int i = 0; i < arregloEnteros.length; i++ ) {
    		if (arregloEnteros[i] == valor) {
    			arregloEnteros[i] = 0;
    			contador++;
    		}
    	}
    	int nuevoEnteros[]= new int[arregloEnteros.length - contador];
        int indice = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != 0) {
            	nuevoEnteros[indice] = arregloEnteros[i];
            	indice++;
            			}
            }
        arregloEnteros = nuevoEnteros;
        
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {	
    	int contador = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i].equals(cadena)) {
            	arregloCadenas[i] = null;
            	contador++;}
        }
        String nuevaCadena[]= new String[arregloCadenas.length - contador];
        int indice = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i] != null) {
            	nuevaCadena[indice] = arregloCadenas[i];
            	indice++;
            			}
            }
        arregloCadenas = nuevaCadena;
        
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {    	
        if (posicion < 0) {
            posicion = 0; 
        }
        
        else if (posicion > arregloEnteros.length) {
            posicion = arregloEnteros.length;
        }
        
        int[] nuevoArreglo = new int[arregloEnteros.length + 1];
        
        for (int i = 0; i < posicion; i++) {
            nuevoArreglo[i] = arregloEnteros[i];
        }
        nuevoArreglo[posicion] = entero;

        for (int i = posicion + 1; i < nuevoArreglo.length; i++) {
            nuevoArreglo[i] = arregloEnteros[i - 1];
        }
        arregloEnteros = nuevoArreglo;
    }

    

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if (posicion >= 0 && posicion < arregloEnteros.length) {
            int[] nuevoArreglo = new int[arregloEnteros.length - 1]; 
            
            
            for (int i = 0, j = 0; i < arregloEnteros.length; i++) {
                if (i != posicion) {
                    nuevoArreglo[j] = arregloEnteros[i];
                    j++;
                }
            }

            arregloEnteros = nuevoArreglo; 
        }
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	arregloEnteros = new int[valores.length]; 
        
        
        for (int i = 0; i < valores.length; i++) {
            arregloEnteros[i] = (int) valores[i];
        }
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	arregloCadenas = new String[objetos.length]; // Crear un nuevo arreglo de cadenas con la misma longitud que el arreglo de objetos
        
        // Convertir los objetos a cadenas utilizando el método toString() y asignar al arreglo de cadenas
        for (int i = 0; i < objetos.length; i++) {
            arregloCadenas[i] = objetos[i].toString();
        }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < 0) {
                arregloEnteros[i] *= -1; 
            }
        }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	int n = arregloEnteros.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arregloEnteros[j] > arregloEnteros[j + 1]) {
                    
                    int temp = arregloEnteros[j];
                    arregloEnteros[j] = arregloEnteros[j + 1];
                    arregloEnteros[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int contador = 0;
        for (int elemento : arregloEnteros) {
            if (elemento == valor) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int contador = 0;
        for (String elemento : arregloCadenas) {
            if (elemento.equalsIgnoreCase(cadena)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	ArrayList<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                posiciones.add(i);
            }
        }
        
        int[] resultado = new int[posiciones.size()];
        for (int i = 0; i < posiciones.size(); i++) {
            resultado[i] = posiciones.get(i);
        }
        return resultado;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	if (arregloEnteros.length == 0) {
            return new int[0];
        }

        int min = arregloEnteros[0]; 
        int max = arregloEnteros[0]; 

        
        for (int i = 1; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < min) {
                min = arregloEnteros[i];
            }
            if (arregloEnteros[i] > max) {
                max = arregloEnteros[i];
            }
        }

        return new int[]{min, max};
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> histograma = new HashMap<>();
        
 
        for (int valor : arregloEnteros) {
            histograma.put(valor, histograma.getOrDefault(valor, 0) + 1);
        }
        
        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int contadorRepetidos = 0;
        
        for (int i = 0; i < arregloEnteros.length; i++) {
            int valorActual = arregloEnteros[i];
            boolean repetido = false;
            
            for (int j = 0; j < i; j++) {
                if (arregloEnteros[j] == valorActual) {
                    repetido = true;
                    break;
                }
            }
            
            if (!repetido) {
                for (int k = i + 1; k < arregloEnteros.length; k++) {
                    if (arregloEnteros[k] == valorActual) {
                        contadorRepetidos++;
                        break;
                    }
                }
            }
        }
        return contadorRepetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	
        if (arregloEnteros.length != otroArreglo.length) {
            return false;
        }
        
        
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != otroArreglo[i]) {
                return false; 
            }
        }
        
        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	
        if (arregloEnteros.length != otroArreglo.length) {
            return false;
        }
        
        
        HashMap<Integer, Integer> frecuencia = new HashMap<>();
        for (int elemento : arregloEnteros) {
            frecuencia.put(elemento, frecuencia.getOrDefault(elemento, 0) + 1);
        }
    
        for (int elemento : otroArreglo) {
            if (!frecuencia.containsKey(elemento) || frecuencia.get(elemento) == 0) {
                return false; 
            }
            frecuencia.put(elemento, frecuencia.get(elemento) - 1);
        }
        
        return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int[] nuevosEnteros = new int[cantidad];
        Random rand = new Random();

        for (int i = 0; i < cantidad; i++) {
            nuevosEnteros[i] = rand.nextInt(maximo - minimo + 1) + minimo;
        }

        arregloEnteros = nuevosEnteros;
    }


	
}