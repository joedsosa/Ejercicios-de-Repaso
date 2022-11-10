/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tareajoedsosa3;

import java.util.Scanner;

/**
 *
 * @author joeds
 */
public class TareaJoedSosa3 {

    static int[] arreglo1=new int[10];
    public static void main(String[] args) {
        String resp = "";
        
        do {
            System.out.println("1) Veamos si podemos armar una palabra");
            System.out.println("2) Numeros Primero");
            System.out.println("3) Ordenar Alfabeticamente");
            System.out.println("4) Codificar Cadenas");
            System.out.println("5) Jugando con Arreglos");
            Scanner sc = new Scanner(System.in);
            int opciones = sc.nextInt();
            switch (opciones) {

                case 1: {
                    System.out.println("INGRESE PALABRA 1");
                    String p1 = sc.next();
                    System.out.println("INGRESE PALABRA 2");
                    Scanner sc1 = new Scanner(System.in);
                    String p2 = sc1.nextLine();
                    if (p1.length() != p2.length()) {
                        String cadenaLarga = (p1.length() > p2.length()) ? p1 : p2;
                        String cadenaCorta = (p1.length() < p2.length()) ? p1 : p2;
                        int countEncontradas = 0;
                        for (int i = 0; i < cadenaCorta.length(); i++) {
                            String letraCadenaCorta = String.valueOf(cadenaCorta.charAt(i));
                            for (int j = 0; j < cadenaLarga.length(); j++) {
                                String letraCadenaLarga = String.valueOf(cadenaLarga.charAt(j));
                                if (letraCadenaCorta.equalsIgnoreCase(letraCadenaLarga)) {
                                    countEncontradas++;
                                    break;
                                }
                            }
                        }
                        if (countEncontradas == cadenaCorta.length()) {
                            System.out.println("Si se puede armar -> " + cadenaCorta);
                        } else {
                            System.out.println("No se puede armar -> " + cadenaCorta);
                        }
                    } else {
                        System.out.println("Error las cadenas de texto tienen la misma longitud");
                    }
                    break;
                }

                case 2: {
                    System.out.println("INGRESE PALABRA 1");
                    String p1 = sc.nextLine();
                    String patronNumeros = "1234567890";
                    String patronLetras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz";
                    String letrasEncontradas = "";
                    String numerosEncontrados = "";
                    for (int i = 0; i < p1.length(); i++) {
                        String caracter = String.valueOf(p1.charAt(i));
                        if (patronLetras.contains(caracter)) {
                            letrasEncontradas += caracter;
                        }
                        if (patronNumeros.contains(caracter)) {
                            numerosEncontrados += caracter;
                        }
                    }
                    System.out.println("Input: " + p1);
                    System.out.println("Output: " + numerosEncontrados + letrasEncontradas);
                    break;
                }
                case 3: {
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("INGRESE PALABRA 1");
                    String p1 = sc2.nextLine().toLowerCase();
                    int countNumeros = ordenarCaracteres(p1);
                    System.out.println("Valor entero retornado: " + countNumeros);
                    break;
                }

                case 4: {
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("INGRESE PALABRA 1");
                    String p1 = sc3.nextLine().toLowerCase();
                    codificar(p1);
                    break;
                }
                case 5: {
                    setArray();
                    getArray();
                }

            }
            System.out.println("Desea continuar S para continuar, cualquier otra tecla para salir!");
            Scanner sc4 = new Scanner(System.in);
            resp = sc4.nextLine();
        } while ("s".equalsIgnoreCase(resp) || "S".equalsIgnoreCase(resp));

    }

    public static int ordenarCaracteres(String cadena) {
        String patronNumeros = "1234567890";
        String letrasEncontradas = "";
        int countNumbers = 0;
        for (int k = 97; k <= 122; k++) {
            String caracterAbeceario = Character.toString((char) k);
            for (int j = 0; j < cadena.length(); j++) {
                String caracterPalabra = String.valueOf(cadena.charAt(j));
                if (caracterPalabra.equalsIgnoreCase(caracterAbeceario)) {
                    letrasEncontradas += caracterPalabra;
                }
            }
        }
        // ENCONTRAR LOS NUMEROS EXISTENTES
        for (int k = 0; k < cadena.length(); k++) {
            String posibleNumero = String.valueOf(cadena.charAt(k));
            if (patronNumeros.contains(posibleNumero)) {
                countNumbers++;
            }
        }
        System.out.println("Input: " + cadena);
        System.out.println("Output: " + letrasEncontradas);
        return countNumbers;

    }

    public static void codificar(String cadena) {
        String letrasANumeros = "ABCDEFGHI";
        String resultado = "";
        for (int k = 0; k < cadena.length(); k++) {
            char caracter = cadena.charAt(k);
            int codAscii = (int) caracter;
            if (codAscii != 32) {
                if (codAscii > 47 && codAscii < 58) {
                    // ES UN NUMERO
                    String num = Character.toString((char) codAscii);
                    for (int i = 0; i < letrasANumeros.length(); i++) {
                        String letra = String.valueOf(letrasANumeros.charAt(i));
                        if (num.equals(String.valueOf(i + 1))) {
                            resultado += letra + "-";
                            break;
                        }
                    }
                }
                if (codAscii > 96 && codAscii < 123) {
                    // ES UNA LETRA
                    resultado += String.valueOf(codAscii - 96) + "-";
                }
            } else if (codAscii == 32) {
                if (resultado.endsWith("-")) {
                    resultado = resultado.substring(0, resultado.length() - 1);
                }
                resultado += " ";
            }

        }
        if (resultado.endsWith("-")) {
            resultado = resultado.substring(0, resultado.length() - 1);
        }

        System.out.println("Entrada: " + cadena);
        System.out.println("Salida: " + resultado);
    }
    
    public static void setArray(){
        Scanner sc = new Scanner(System.in); 
        for (int i = 0; i < 10; i++) {
            System.out.println("Ingrese posicion "+(i+1)+" del arreglo");
            int num = sc.nextInt();
            arreglo1[i]=num;
        }
    }
    
   public static void getArray(){ 
        for (int i = 0; i < arreglo1.length; i++) {
            System.out.println("Valor posicion "+(i+1)+"-->"+arreglo1[i]);
        }
    }         
}

/*Crea un array de 10 posiciones de números con valores pedidos al usuario. Y luego muéstrelo en
consola. Para esto cree dos métodos, uno para rellenar valores el arreglo y otro para imprimirlo*/