package T10;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Adivinator {
	    private int numeroSecreto;
	    private int intentos;

	    public Adivinator() {
	        Random rand = new Random();
	        this.numeroSecreto = rand.nextInt(500) + 1;
	        this.intentos = 0;
	    }

	    public void jugar() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("¡Bienvenido al juego de adivinar el número!");
	        System.out.println("He generado un número entre 1 y 500. ¿Puedes adivinar cuál es?");
	        
	        while (true) {
	            try {
	                System.out.print("Introduce tu intento: ");
	                int intento = scanner.nextInt();
	                intentos++;
	                
	                if (intento < numeroSecreto) {
	                    System.out.println("El número que buscas es mayor.");
	                } else if (intento > numeroSecreto) {
	                    System.out.println("El número que buscas es menor.");
	                } else {
	                    System.out.println("¡Felicidades! Has adivinado el número en " + intentos + " intentos.");
	                    break;
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Eso no es un número válido. Cuenta como un intento fallido.");
	                intentos++;
	                scanner.next(); 
	            }
	        }

	        scanner.close();
	    }

	    public static void main(String[] args) {
	        Adivinator juego = new Adivinator();
	        juego.jugar();
	    }
	}
