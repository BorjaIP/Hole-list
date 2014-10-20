package HoleList;

import java.io.IOException;
import java.io.FileNotFoundException;
 

/** Esta clase se debera encargar de probar y validar el funcionamiento completo de las clases implementadas.
  * En este caso concreto debera trabajarse con un objeto de tipo ArchivoLH que maneje registros de tipo RegistroBiblioteca.
  * Deberan probarse TODOS y cada uno de los metodos implementados en la clase ArchivoLH en TODAS las posibles
  * condiciones de ejecucion de los mismos, con el fin de validar a traves de los volcados por pantalla que el
  * funcionamiento de la practica es totalmente correcto.
  */

   public class PruebasBibliotecasLH {


	 /**
	   * Permite probar las clases ArchivoLH y RegistroBiblioteca implementadas por los alumnos.
	   */
	   public PruebasBibliotecasLH(){
		    
		    /**
		     * Deberan probarse los siguientes metodos en las situaciones indicadas
		     * 
		     * 	- constructor de ArchivoLH que CREA el fichero. Situaciones:
		     * 		- el fichero no existe. Validar que lo crea y que el archivo contiene el registro 0 completo (con todos los
		     *        campos de un registro de tipo RegistroBiblioteca) y con el campo control a -1.
		     *        //DONE.
		     *        
		     *      - el fichero existe. Validar que borra su contenido y que el archivo contiene el registro 0 completo (con todos los
		     *        campos de un registro de tipo RegistroBiblioteca) y con el campo control a -1.
		     *        //DONE.
		     *        
		     *  - constructor de ArchivoLH que ABRE el fichero. Situaciones:
		     *  	- El fichero de registros existe. Validar que su contenido es exactamente el mismo que la ultima vez que 
		     *        se trabajo con el.
		     *        //DONE
		     *        
		     *      - El fichero de registros no existe. Debe saltar la excepcion FileNotFoundException que debera capturarse e
		     *        indicar por la consola esta situacion mediante un mensaje de error.
		     *        //DONE
		     *        
		     *  - escribirRegistro. Situaciones:
		     *      - La lista de huecos esta vacia. Validar que el registro se ha incluido como ultimo registro del fichero y que
		     *        el valor devuelto por el metodo es correcto.
		     *        //DONE
		     *        
		     *      - La lista de huecos NO esta vacia. Validar que el registro se ha incluido en la posicion indicada por la
		     *        cabecera de la lista de huecos y que esta se ha actualizado convenientemente. Ademas, debera comprobarse que 
		     *        el valor devuelto por el metodo es correcto.
		     *        //DONE
		     *        
		     *  - leerRegistro. Situaciones:
		     *  	- leer el registro 0. Validar que los datos que devuelve son del ultimo registro del fichero.
		     *        //DONE
		     *  
		     *      - leer un registro que se encuentre en una posicion superior al numero de registros del fichero. Validar que 
		     *        los datos que devuelve son del ultimo registro del fichero.
		     *        //DONE
		     *        
		     *      - leer un registro que se encuentre en una posicion valida.  Validar que los datos que devuelve son los asociados
		     *        al registro almacenado en la posicion indicada.
		     *        //DONE
		     *        
		     *  - borrarRegistro. Situaciones:
		     *      - borrar el registro 0. Validar que no tiene ningun efecto sobre el fichero.
		     *        //DONE
		     *      
		     *      - borrar un registro que se encuentre en una posicion superior al numero de registros del fichero.Validar que no 
		     *        tiene ningun efecto sobre el fichero.
		     *        //ODNE
		     *        
		     *      - borrar un registro que se encuentre en la lista de huecos. Validar que no tiene ningun efecto sobre el fichero.
		     *        //DONE
		     *      
		     *      - borrar un registro que se encuentre en una posicion valida y que contenga informacion util (que no esta en la
		     *        lista de huecos).
		     *        //DONE
		     *         
		     */
		    
		   try{
			   //Creamos el fichero en blanco, sin registros.
			   RegistroBiblioteca R = new RegistroBiblioteca();
			   ArchivoLH archivoBibliotecas= new ArchivoLH(R,"bibliotecas.dat");
			   //Creamos un archivo sin modificarlo.
			   //ArchivoLH archivoBibliotecas= new ArchivoLH(R,"bibliotecas.dat","r");
			   System.out.println("Intento de leer el primer registro: ");
			   archivoBibliotecas.volcar();
			   System.out.println("**********************************************************");
			   
			   //Creamos el primer registro para escribir.
			   RegistroBiblioteca registro1 = new RegistroBiblioteca(10,"Vallecas",28030,100);
			   registro1.setControl(RegistroLH.REGISTRO_OCUPADO);
			   archivoBibliotecas.setRegistro(registro1);
			   archivoBibliotecas.escribirRegistro();
			   System.out.println("Volcado, añadiendo primer registro: ");
			   archivoBibliotecas.volcar();
			   System.out.println("**********************************************************");
			   
			   //Creamos otros dos registros para probar que la lista no está vacia.
			   RegistroBiblioteca registro2 = new RegistroBiblioteca(40,"Ciudad Lineal",28015,175);
			   registro2.setControl(RegistroLH.REGISTRO_OCUPADO);
			   archivoBibliotecas.setRegistro(registro2);
			   archivoBibliotecas.escribirRegistro();
			   System.out.println("Volcado, añadiendo otro registro: ");
			   archivoBibliotecas.volcar();
			   System.out.println("**********************************************************");
			   
			   RegistroBiblioteca registro6 = new RegistroBiblioteca(20,"Goya",28001,250);
			   registro2.setControl(RegistroLH.REGISTRO_OCUPADO);
			   archivoBibliotecas.setRegistro(registro6);
			   archivoBibliotecas.escribirRegistro();
			   System.out.println("Volcado, añadiendo otro registro: ");
			   archivoBibliotecas.volcar();
			   System.out.println("**********************************************************");
			   
			   //Leemos el registro 0.
			   archivoBibliotecas.leerRegistro(0);
			   RegistroBiblioteca registro3 = (RegistroBiblioteca)archivoBibliotecas.getRegistro();
			   System.out.println("Datos registro 0: ");
			   System.out.println(registro3.toString());
			   System.out.println("**********************************************************");
			   System.out.println();
			   
			   //Leemos un numero de registro que es superior al maximo de registros.
			   archivoBibliotecas.leerRegistro(100);
			   RegistroBiblioteca registro4 = (RegistroBiblioteca)archivoBibliotecas.getRegistro();
			   System.out.println("Datos registro 100: ");
			   System.out.println(registro4.toString());
			   System.out.println("**********************************************************");
			   System.out.println();
			   
			   //Leemos un numero de registro que tenga posicion valida.
			   archivoBibliotecas.leerRegistro(1);
			   RegistroBiblioteca registro5 = (RegistroBiblioteca)archivoBibliotecas.getRegistro();
			   System.out.println("Datos registro 1: ");
			   System.out.println(registro5.toString());
			   System.out.println("**********************************************************");
			   System.out.println();
			   
			   //Borramos el registro 0.
			   archivoBibliotecas.borrarRegistro(0);
			   System.out.println("Volcado despues de borrar el registro 0: ");
			   archivoBibliotecas.volcar();
			   System.out.println("**********************************************************");
			   System.out.println();
			   
			   //Borrar un registro que no exista.
			   archivoBibliotecas.borrarRegistro(100);
			   System.out.println("Volcado despues de borrar el registro 100: ");
			   archivoBibliotecas.volcar();
			   System.out.println("**********************************************************");
			   System.out.println();
			   
			   //Borrar el registro 2.
			   archivoBibliotecas.borrarRegistro(2);
			   System.out.println("Volcado despues de borrar el registro 2: ");
			   archivoBibliotecas.volcar();
			   System.out.println("**********************************************************");
			   System.out.println();
			   
			   //Borra de nuevo el registro 2 que estaba ya previamente borrado.
			   archivoBibliotecas.borrarRegistro(2);
			   System.out.println("Volcado despues de borrar de nuevo el registro 2: ");
			   archivoBibliotecas.volcar();
			   System.out.println("**********************************************************");
			   System.out.println();
			   
			   //Borramos el registro3.
			   archivoBibliotecas.borrarRegistro(3);
			   System.out.println("Volcado despues de borrar el registro 3: ");
			   archivoBibliotecas.volcar();
			   System.out.println("**********************************************************");
			   System.out.println();
			    
			   
		   }catch (IOException ioe){
				System.out.println("Error de entrada/salida sobre archivoLibros: "+ioe.getMessage());
			}
	   }
	
	public static void main(String[] args) {
		new PruebasBibliotecasLH();
	}

}
