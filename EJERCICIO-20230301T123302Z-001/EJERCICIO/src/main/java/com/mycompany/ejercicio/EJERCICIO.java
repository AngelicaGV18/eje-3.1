/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio;

/**
 *
 * @author PC
 */
import java.util.Scanner;

public class EJERCICIO {
    static double moda; 
    static double media; 
    static double varianza;
    static double desviacion;
    static double mediana;
    static double aux;
    static int n,c,c1, mitad;
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t BIENVENIDO ");
        System.out.print("\n  - Digite la cantidad de números a calcular: ");
        n = sc.nextInt();
        System.out.print("\n");
        //Crear el arreglo que me almacene los números//
        
        double numeros [] = new double[n];
        for ( int i = 0; i < n; i ++)
        {
            System.out.print("\t Ingrese el número " + (i+1) + ": ");
            numeros [i] = sc.nextDouble();
        }
        
        //Calculamos la media//
        double suma = 0;
        for (double i : numeros)
        {
            suma += i;
        }
        media = suma / n;
        double redondeo1 = Math.rint(media *100)/100;
        
        //ORDENO//

        for( int i = 0; i < (n-1); i ++)
        {
           for(int j = 0; j < (n-1); j++)
           {
               if(numeros[j]>numeros[j+1])
               {
                   aux = numeros[j];
                   numeros[j] = numeros[j+1];
                   numeros[j+1] = aux;
               }
           }
        }
       
        //Calculamos mediana //
        mitad = n /2;
        if( n % 2 == 0)
        {
            mediana = (numeros[mitad -1]+ numeros[mitad])/2;
        }
        else
        {
            mediana = numeros[mitad];
        }
        
        //Calculamos Moda//
        c1 = -1;
        for( int i = 0; i < n; i ++)
        {
            c = 0;
           for(int j = 0; j < n; j++)
           {
               if ( numeros[i] == numeros[j])
               {
                   c += 1;
               }
           }
           if( c > c1)
           {
               moda =numeros[i];
               c1 = c;
           }
        }
        
        //Calculamos la desviación estandar, la dividimos en dos partes, para mayor facilidad//
        double sumatoria;
        for (int i = 0; i < n; i ++)
        {
            sumatoria = Math.pow( numeros[i]-media,2);
            varianza = varianza + sumatoria;
        }
        
        varianza = varianza / (n-1);
        
        desviacion = Math.sqrt(varianza);
        double redondeo2 = Math.rint(desviacion *100)/100;
        
        System.out.println("   ----------------------------------------- \n");
        System.out.println("\t\tINFORME FINAL       ");
        System.out.println("  - El ordenamiento en orden ascendente quedaría: ");
        for( int i = 0; i < (n-1); i ++)
        {
            System.out.println("\t\t\t"+ numeros[i]);
        }
        System.out.print("\n");
        System.out.println("  - La moda es: " + moda);
        System.out.println("  - La media es: " + redondeo1);
        System.out.println("  - La mediana es: " + mediana);
        System.out.println("  - La desviación estandar es: " + redondeo2);
    }
}
