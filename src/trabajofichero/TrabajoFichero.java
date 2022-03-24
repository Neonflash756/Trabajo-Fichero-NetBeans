package trabajofichero;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.Reader;
import java.util.InputMismatchException;
import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeArray;
import jdk.nashorn.internal.objects.NativeString;

public class TrabajoFichero {
    
    public static void main(String[] args) throws IOException{
       
        System.out.println("Teclee uno para mostrar los datos de todos aquellos restaurantes cuyo código postal empiece por el dígito indicado.");
        System.out.println("Teclee dos para añadir datos nuevos al fichero");
        System.out.println("Teclee tres para crear una copia del fichero que contenga los mismos datos excepto aquellos correspondientes a los restaurantes del Estado (State) indicados.");
        System.out.println("Teclee cuatro para borrar un fichero");
        System.out.println("Si deseea salir pulse enter");
        Scanner sc = new Scanner(System.in);
        String menu = sc.nextLine();
        switch(menu)
        {
            case "uno":
                System.out.println("Indique el dígito");
                String dígito = sc.nextLine();
                char digito = dígito.charAt(0);
                FileReader fr = new FileReader("Restaurants.csv");
                BufferedReader br = new BufferedReader(fr);
                String linea = br.readLine();
                try {
                    while (linea != null) {
                        int contador = linea.lastIndexOf(',');
                        contador++;
                        if(linea.charAt(contador) == digito){
                            System.out.println(linea);
                            linea = br.readLine();
                        }
                        else{
                            linea = br.readLine();
                        }
                    }
                } 
                catch (InputMismatchException e) {
                    System.out.println("error");
                }
                
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
                fr = new FileReader("Restaurants.csv");
                br = new BufferedReader(fr);
                System.out.println("Escriba el nombre del nuevo fichero: ");
                String nombreFichero = sc.nextLine();
                nombreFichero= nombreFichero +".csv";
                System.out.println("Escriba el nombre del estado: ");
                String estado = sc.nextLine();
                FileWriter fw = new FileWriter(nombreFichero, true);
                BufferedWriter bw = new BufferedWriter(fw);
                linea = br.readLine();

                try {
                    while (linea != null) {
                        String [] lineaSeparada = linea.split(",");
                        if (!lineaSeparada[3].equals(estado) ){
                            System.out.println(linea);
                            bw.write(linea);
                            bw.write("\n");
                            
                            linea = br.readLine();
                        }
                        else{
                            linea = br.readLine();
                        }
                    }
                    bw.close();
                } 
                catch (InputMismatchException e) {
                    System.out.println("error");
                }
                
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
