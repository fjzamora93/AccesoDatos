import java.io.File;
import java.io.IOException;

/*
* 1. Para poder ejecutar el proyecto, hay que estar dentro de la carpeta Fichero -con mayúsculas.
*
* */
public class Entrada {

    public static void main(String[] args) {
        // FILE -> fichero logico -> fisico
        // fichero logico
        // File ficheroSinPuntero = new File("/Users/borja/Documents/GitHub/ClaseAD-UNIR/T1/Fichero/src/resources/directorio/ejemplo_fichero.md");
        File ficheroSinPuntero = new File("src/resources/directorio");
        System.out.println(ficheroSinPuntero.getName());
        System.out.println(ficheroSinPuntero.getParent());
        System.out.println(ficheroSinPuntero.length());
        System.out.println(ficheroSinPuntero.exists());

        System.out.println("Es un archivo o un directorio: " + ficheroSinPuntero.isDirectory());

        // File[] -> todos los FICHEROS que estan dentro del directorio
        ficheroSinPuntero.listFiles();

        // String[] -> todas las rutas de los FICHEROS que estan dentro del directorio
        ficheroSinPuntero.list();
        System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir"));

        // 1 -> Obtener todos los nombre de los ficheros del directorio llamado directorio

        System.out.println("Listado de los nombres de los ficheros: " + ficheroSinPuntero.list());
        for (String archivo: ficheroSinPuntero.list()){
            System.out.println(".- " + archivo);
        }


        // 2 -> Crear una subcarpeta en el directorio llamado directorio y crear en ella un fichero

        File nuevaSubcarpeta = new File(ficheroSinPuntero, "NuevoSubdirectorio");
        if (!nuevaSubcarpeta.exists()){
            nuevaSubcarpeta.mkdir();
            System.out.println("Directorio creado con éxito");
        } else {
            System.out.println("El directorio ya existe \n");
        }

        //NOTA: CreateNewFile() te obliga a lanzar un try/catch
        File nuevoFichero = new File(nuevaSubcarpeta, "fichero.txt");
        if (!nuevoFichero.exists()){
            try{
                nuevoFichero.createNewFile();
            } catch (IOException e){
                System.out.println("Fallo en la creacion del fichero");
            }

        } else {
            System.out.println("El fichero.txt ya existe \n");
        }

        //   -> Obtener todos los nombre de los ficheros del directorio llamado directorio y el subdirectorio creado

       for (File archivo: ficheroSinPuntero.listFiles()){
           System.out.println(" - " + archivo.getName());
           if (archivo.isDirectory()){
               for (File subArchivo: archivo.listFiles()){
                   System.out.println(" -- " + subArchivo.getName());
               }
           }
       }



        // 3 -> Listar el nombre de todos los ficheros del SISTEMA ( C:/User o /Users )


        // RECURSIVIDAD
        File system = new File("C:/Users/Javier");
        listadoRecursivo(system);


    }

    public static void listadoRecursivo(File directorio) {
        if (directorio != null  && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();

            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo != null) {
                        if (archivo.isDirectory()) {
                            System.out.println(archivo.getName().toUpperCase());
                            listadoRecursivo(archivo);
                        } else {
                            System.out.println("    |______" + archivo.getName());
                        }
                    }
                }
            }
        }}

    }