package giardino;

public class Main {
    public static void main(String[] args) {
       Ingressi ing= new Ingressi();
        
        for(int i=0; i<20; i++){
            Persona p= new Persona(ing,"Turista "+(i+1));
            p.start();
        }
    }
}