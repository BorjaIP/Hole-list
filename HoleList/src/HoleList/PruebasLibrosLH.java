package HoleList;

import java.io.IOException;

 
/** Esta clase se debera encargar de probar y validar el funcionamiento completo de las clases implementadas.
  * En este caso concreto debera trabajarse con un objeto de tipo ArchivoLH que maneje registros de tipo RegistroLibro.
  * Deberan probarse TODOS y cada uno de los metodos implementados en la clase ArchivoLH en TODAS las posibles
  * condiciones de ejecucion de los mismos, con el fin de validar a traves de los volcados por pantalla que el
  * funcionamiento de la practica es totalmente correcto.
  */

   public class PruebasLibrosLH {


	 /**
	   * Permite probar las clases ArchivoLH y RegistroLibro implementadas por los alumnos.
	   */
	   public PruebasLibrosLH(){

		try{
			//Creamos el fichero en blanco, sin registros.
			RegistroLibro R = new RegistroLibro();
			ArchivoLH archivoLibros= new ArchivoLH(R,"libros.dat");
			//Creamos y abrimos el fichero sin modificarlo.
			//ArchivoLH archivoLibros= new ArchivoLH(R,"libros.dat","r");
			System.out.println("\t\tVolcando el contenido del archivo");
			System.out.println();
			archivoLibros.volcar();
			System.out.println();
		    
			//Creamos el primer registro.
		    RegistroLibro registro1 = new RegistroLibro(40, "Nivel 5", "novela negra", 496);
            registro1.setControl(RegistroLH.REGISTRO_OCUPADO);
		    archivoLibros.setRegistro(registro1);
		    archivoLibros.escribirRegistro();		    
		    System.out.println("\t\tVolcando registro 1");
			System.out.println();
			archivoLibros.volcar();
			System.out.println();
   
            //Creamos otros dos registros para probar que la lista no está vacia.		    
		    RegistroLibro registro2 = new RegistroLibro(10, "Viaje en el tiempo 5", "infantil", 400);
            registro2.setControl(RegistroLH.REGISTRO_OCUPADO);
		    archivoLibros.setRegistro(registro2);
		    archivoLibros.escribirRegistro();		    
		    
		    RegistroLibro registro3 = new RegistroLibro(30, "El invierno del mundo", "novela historica", 960);
            registro3.setControl(RegistroLH.REGISTRO_OCUPADO);
		    archivoLibros.setRegistro(registro3);
		    archivoLibros.escribirRegistro();	
		    System.out.println("\t\tVolcando los tres registros");
			System.out.println();
			archivoLibros.volcar();
			System.out.println();
			
		    //Leemos el registro 0.
		    archivoLibros.leerRegistro(0);
		    RegistroLibro registro4 = (RegistroLibro)archivoLibros.getRegistro();
		    System.out.println("Datos del registro 0: ");
		    System.out.println(registro4.toString());			   
			System.out.println();
			   
		    //Leemos un numero de registro que es superior al maximo de registros.
		    archivoLibros.leerRegistro(100);
		    RegistroLibro registro5 = (RegistroLibro)archivoLibros.getRegistro();
		    System.out.println("Datos del registro 100: ");
		    System.out.println(registro5.toString());			   
			System.out.println();
		    
			//Leemos un numero de registro que tenga posicion válida.
		    archivoLibros.leerRegistro(1);
		    RegistroLibro registro6 = (RegistroLibro)archivoLibros.getRegistro();
		    System.out.println("Datos del registro 100: ");
		    System.out.println(registro6.toString());			   
			System.out.println();
		      
		    //Borrado registro 0.
		    archivoLibros.borrarRegistro(0);
		    System.out.println("\t\tVolcado despues de borrar el registro 0");
		    System.out.println();
			archivoLibros.volcar();
			System.out.println();
		    
		    //Borrado registro registro que no existe.
		    archivoLibros.borrarRegistro(100);
		    System.out.println("\t\tVolcado despues de borrar el registro 100");
		    System.out.println();
			archivoLibros.volcar();
			System.out.println();
		    
			//Borrar el registro 2 para añadirlo a la lista de huecos.
		    archivoLibros.borrarRegistro(2);
		    System.out.println("\t\tVolcado despues de borrar el registro 2");
		    System.out.println();
			archivoLibros.volcar();
			System.out.println();
		    
			//Borrando un registro que se encuentra ya en la lista de huecos.
		    archivoLibros.borrarRegistro(2);
		    System.out.println("\tVolcado despues borrar un registro que está en la lista de huecos");
		    System.out.println();
			archivoLibros.volcar();
			System.out.println();

		    //Borrado registro 3.
		    archivoLibros.borrarRegistro(3);
		    System.out.println("\t\tVolcado despues de borrar el registro 3");
		    System.out.println();
			archivoLibros.volcar();
			System.out.println();
		    
			//Cerrar el fichero.
		    archivoLibros.cerrarArchivo();

		    /**
		     * Deberan probarse los siguientes metodos en las situaciones indicadas
		     * 	- constructor de ArchivoLH que CREA el fichero. Situaciones:
		     * 		- el fichero no existe. Validar que lo crea y que el archivo contiene el registro 0 completo (con todos los
		     *        campos de un registro de tipo RegistroLibro) y con el campo control a -1.
		     *        //DONE
		     *        
		     *      - el fichero existe. Validar que borra su contenido y que el archivo contiene el registro 0 completo (con todos los
		     *        campos de un registro de tipo RegistroLibro) y con el campo control a -1.
		     *        //DONE
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
		     *  	  //DONE
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
		     *        //DONE
		     *        
		     *      - borrar un registro que se encuentre en la lista de huecos. Validar que no tiene ningun efecto sobre el fichero.
		     *        //DONE
		     *      
		     *      - borrar un registro que se encuentre en una posicion valida y que contenga informacion util (que no esta en la
		     *        lista de huecos).
		     *        //DONE 
		     */
		    
		}catch (IOException ioe){
		 	System.out.println("Error de entrada/salida sobre archivoLibros: "+ioe.getMessage());
		 }
	   }
	
	public static void main(String[] args) {
		new PruebasLibrosLH();
	}

}


