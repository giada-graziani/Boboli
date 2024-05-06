package giardino;

public class Ingressi {
    private int ingressoA=0;
    private int ingressoB=0;
    private char entrata;

    //entra()
    //try
    public synchronized int entra(){
        String nome= Thread.currentThread().getName();
        int tempo=0;

        try{
            while(ingressoA>4 && ingressoB>9){
                System.out.println(nome+" è in attesa");
                wait();
            }

            //entra
            if(ingressoA<5){
                ingressoA++;
               entrata='A'; 
               tempo=3000;
               System.out.println(nome+" è entrato nell'ingresso:"+ entrata);
               System.out.println(nome+ " si trattiene nel giardino per "+ ((tempo/1000)+ "secondi"));
            }
            else if(ingressoB<10){
                ingressoB++;
                entrata='B';
                tempo= 1000+(int)(Math.random()*5001);
                System.out.println(nome+" è entrato nell'ingresso:"+ entrata);
                System.out.println(nome+ " si trattiene nel giardino per "+ ((tempo/1000)+ "secondi"));
                
            }
            
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        
        return tempo;
    }

    //esci()
    public synchronized void esci(){
        String nome= Thread.currentThread().getName();
        if(entrata == 'A'){
            ingressoA--;
        }
        else if(entrata =='B'){
            ingressoB--;
        }
        System.out.println(nome+" è uscito dall'ingresso:"+ entrata);
        notify();
    }


}
