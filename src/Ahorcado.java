package src;

import javax.swing.JOptionPane;
import java.util.*;

public class Ahorcado {

    
    public static void main(String[] args) {
    
        System.out.println("------------------------------------------");
        System.out.println("|                Ahorcado                |");
        System.out.println("------------------------------------------");
        System.out.println("");
        
        String palabra = JOptionPane.showInputDialog("Introduce la palabra a adivinar");
        
        int letrae = 0;
        
        int cont = 0;
        
        int contador = 1;
        
        int fallos = 0;
        
        ArrayList elecciones = new ArrayList();
        
        for (int h = 0; h < palabra.length(); h++) { /*bucle que se encarga de imprimir todos los huecos de letras que hay en la palabra. 
                                                        Logicamente nunca aparecerá ninguna letra aqui puesto que solo se muestran los espacios*/
            if (palabra.charAt(h)==(' ')) {
                
                System.out.print("   ");
            
            }else{
                
                System.out.print(" _ ");
            
            }
            
        } 
        
        for (int j = 0; fallos < 6; j++) {
            
            cont=0;
            
            if(contador>0){ //evalua si has ganado o no
                
                contador = 0; //contador que leerá el numero de guiones en la última vuelta de bucle
                
                String eleccion = JOptionPane.showInputDialog("Escribe una letra para adivinar o escribe la palabra entera si la sabes");
                
                if(eleccion.equals(palabra)){ //Si sabe la palabra entera puede escribirla
                    
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Enhorabuena, has ganado");
                    System.out.println("");
                    System.exit(0);
                    
                }
                
                System.out.println("");
                
                char eleccion2 = eleccion.charAt(0); //tengo que crear otra variable a proposito para comparar 
                
                for (int p = 0; p < palabra.length(); p++) {
                    
                    if (eleccion2!=(palabra.charAt(p))) {
                        cont = cont + 1;
                    }    
                } /*tanto este for como el if siguiente comprueban si la letra introducida es correcta. Si lo es, se rellenan los los espacios con guiones, si no, se suma uno al contador de fallos
                    y el dibujo avanza con una extremidad más. Sin este for, cada vuelta de bucle del juego se pintaria una extremidad mas, independientemente de si la palabra es correcta o no*/ 
                
                if (cont==palabra.length()) {
                    fallos = fallos + 1;
                } 

                elecciones.add(eleccion); //las elecciones tambien incluyen las letras no correctas y puede poner guiones bajos contando las elecciones fallidas

                System.out.println(moneco(fallos)); //dibujamos el muneco en cada vuelta de bucle

                System.out.println("");

                for (int i = 0; i < palabra.length(); i++) {

                    char letra = palabra.charAt(i); //separa la palabra en letras

                    String letraf = Character.toString(letra); //Pasar a String para operar bien

                    if (letraf.equals(" ")) {
                        
                        System.out.print("   "); //espacio ampliado

                    }else{

                        for (int k = 0; k < elecciones.size(); k++) {

                            if (elecciones.get(k).equals(letraf)) {

                                letrae = k; //este junto con el if que viene inmediatamente despues evalua si la letra es correcta o si debe poner un guión

                            }

                        }

                        if (elecciones.get(letrae).equals(letraf)) {

                                System.out.print(" " + elecciones.get(letrae) + " "); //se escribe la letra correspondiente.

                        }else{

                            System.out.print(" _ "); //se escribe un guion para cada letra no adivinada
                            contador = contador + 1; /*este contador solo sirve para la ultima vuelta del bucle, para ver si el jugador ha perdido. Suma uno si queda un guion en la ultima vuelta,
                                                        ya que significa que al jugador le ha quedado una letra por adivinar y por lo tanto ha perdido*/
                        }

                    }
                
                }
            
                    System.out.println(""); 
            
            }else{
                System.out.println("");
                System.out.println("Enhorabuena, has ganado");
                System.out.println("");
                System.exit(0);
            }
        }
        
        if (contador>0) {
            System.out.println("");
            System.out.println("Has perdido, la palabra era: " + palabra); /* si el contador da mas de uno significa que hay un guion bajo, es decir 
                                                                                una letra no adivinada por lo tanto ha perdido.*/
            System.out.println("");
        }
        
    }
    
    /*
    --------------------------------------------------------------------------------------------------------------------------------------------
    Zona de Dibujitos jeje
    --------------------------------------------------------------------------------------------------------------------------------------------
    */
    
    public static String moneco(int dibujo){
        
        switch (dibujo) {
            
            case 0:
                System.out.println(" - - - - - - - - - - - - - - -       ");
                System.out.println("|                             |      ");
                System.out.println("|                             |      ");
                System.out.println("|                                    ");
                System.out.println("|                                    ");
                System.out.println("|                                    ");
                System.out.println("|                                    ");
                System.out.println("|                                    ");
                System.out.println("|                                    ");
                System.out.println("|                                    ");
                System.out.println("|                                    ");
                break;
                
            case 1:
                System.out.println(" - - - - - - - - - - - - - - -       ");
                System.out.println("|                             |      ");
                System.out.println("|                             |      ");
                System.out.println("|                         | - - - |  ");
                System.out.println("|                         |  '  ' |  ");
                System.out.println("|                         |   u   |  ");
                System.out.println("|                         | - - - |  ");
                System.out.println("|                                    ");
                System.out.println("|                                    ");
                System.out.println("|                                    ");
                System.out.println("|                                    ");
                break;
                
            case 2:
                System.out.println(" - - - - - - - - - - - - - - -        ");
                System.out.println("|                             |       ");
                System.out.println("|                             |       ");
                System.out.println("|                         | - - - |   ");
                System.out.println("|                         |  '  ' |   ");
                System.out.println("|                         |   u   |   ");
                System.out.println("|                         | - - - |   ");
                System.out.println("|                             |       ");
                System.out.println("|                             |       ");
                System.out.println("|                             |       ");
                System.out.println("|                             |       ");
                System.out.println("|                             |       ");
                System.out.println("|                             |       ");
                break;
                
            case 3:
                System.out.println(" - - - - - - - - - - - - - - -        ");
                System.out.println("|                             |       ");
                System.out.println("|                             |       ");
                System.out.println("|                         | - - - |   ");
                System.out.println("|                         |  '  ' |   ");
                System.out.println("|                         |   u   |   ");
                System.out.println("|                         | - - - |   ");
                System.out.println("|                             |     / ");
                System.out.println("|                             |   /   ");
                System.out.println("|                             | /     ");
                System.out.println("|                             |       ");
                System.out.println("|                             |       ");
                System.out.println("|                             |       ");
                break;
                
            case 4:
                System.out.println(" - - - - - - - - - - - - - - -         ");
                System.out.println("|                             |        ");
                System.out.println("|                             |        ");
                System.out.println("|                         | - - - |    ");
                System.out.println("|                         |  '  ' |    ");
                System.out.println("|                         |   u   |    ");
                System.out.println("|                         | - - - |    ");
                System.out.println("|                      \\     |     /  ");
                System.out.println("|                        \\   |   /    ");
                System.out.println("|                          \\ | /      ");
                System.out.println("|                            |         ");
                System.out.println("|                            |         ");
                System.out.println("|                            |         ");
                break;
                
            case 5:
                System.out.println(" - - - - - - - - - - - - - - -         ");
                System.out.println("|                             |        ");
                System.out.println("|                             |        ");
                System.out.println("|                         | - - - |    ");
                System.out.println("|                         |  '  ' |    ");
                System.out.println("|                         |   u   |    ");
                System.out.println("|                         | - - - |    ");
                System.out.println("|                      \\     |     /  ");
                System.out.println("|                        \\   |   /    ");
                System.out.println("|                          \\ | /      ");
                System.out.println("|                            |         ");
                System.out.println("|                           /          ");
                System.out.println("|                          /           ");
                System.out.println("|                         /            ");
                break;
                
            case 6:
                System.out.println(" - - - - - - - - - - - - - - -         ");
                System.out.println("|                             |        ");
                System.out.println("|                             |        ");
                System.out.println("|                         | - - - |    ");
                System.out.println("|                         |  '  ' |    ");
                System.out.println("|                         |   u   |    ");
                System.out.println("|                         | - - - |    ");
                System.out.println("|                      \\     |     /  ");
                System.out.println("|                        \\   |   /    ");
                System.out.println("|                          \\ | /      ");
                System.out.println("|                            |         ");
                System.out.println("|                           / \\       ");
                System.out.println("|                          /   \\      ");
                System.out.println("|                         /     \\     ");
                break;
                
        }
        
        return ""; 
        
    }
    
}
