package trabajofichero;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;

public class TrabajoFichero {
    
    public static void main(String[] args) throws IOException{
       
        System.out.println("Teclee uno para mostrar los datos de todos aquellos restaurantes cuyo código postal empiece por el dígito indicado.");
        System.out.println("Teclee dos para añadir datos nuevos al fichero");
        System.out.println("Teclee tres para crear una copia del fichero que contenga los mismos datos excepto aquellos correspondientes a los restaurantes del Estado (State) indicados.");
        System.out.println("Teclee cuatro para borrar un fichero");
        Scanner sc = new Scanner(System.in);
        String menu = sc.nextLine();
        switch(menu)
        {
            case "uno":
                System.out.println("uno");
                break;
            case "dos":
                System.out.print("Nombre del fichero:");
                String archivo = sc.nextLine();

                try (FileWriter fich = new FileWriter (archivo,true)) {
                    System.out.print("Restaurante: ");
                    archivo = sc.nextLine();
                    fich.write(archivo);

                    System.out.print("Dirección:");
                    archivo = sc.nextLine();
                    fich.write(','+archivo);

                    System.out.print("Ciudad:");
                    archivo = sc.nextLine();
                    fich.write(','+archivo);

                    System.out.print("Estado:");
                    archivo = sc.nextLine();
                    fich.write(','+archivo);
                    
                    System.out.print("Código:");
                    archivo = sc.nextLine();
                    fich.write(','+archivo);

                    //cambio de línea
                    fich.write("\n");
                    fich.close();
                }
                
                break;
            case "tres":
                System.out.println("tres");
                break;
            case "cuatro":
                System.out.println("Introduzca el fichero");
                String file = sc.nextLine();
                File fichero = new File(file);
                
                if (fichero.delete()){
                    System.out.println("El fichero ha sido borrado satisfactoriamente");
                }
                else{
                    System.out.println("El fichero no puede ser borrado");
                }
                break;
            default:
                System.out.println("Programa finalizado");
        }
    }
    
}
