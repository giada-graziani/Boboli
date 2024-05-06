package giardino;

public class Persona extends Thread {
    Ingressi ing= new Ingressi();

    public Persona(Ingressi ing, String nome){
        super(nome);
        this.ing=ing;
    }

    //run
    //try
    //entra tempo di attesa ed esce
    public void run(){
        
        
        try{
            int tempo=ing.entra();
            Thread.sleep(tempo);
            ing.esci();
            }
            catch(InterruptedException e){
                e.printStackTrace(); 
            }
    }


}
