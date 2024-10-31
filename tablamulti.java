import java.util.Scanner;

public class tablamulti {
    
    public static void main(String[] args) {
         
       int Multiplicando ;
       System.out.println("¿ingresa el numero que quieres multiplicar?");
       Scanner teclado = new Scanner(System.in);
       Multiplicando = teclado.nextInt();
    
       int multiplicador;
       for(multiplicador = 1; multiplicador <=20; multiplicador++){
       System.out.println(Multiplicando + " X " + multiplicador +         " = " + Multiplicando * multiplicador );

         }  
         
    }
         
}