public class Main {
    public static void main(String[] args){
        Registro registroStudenti= new Registro();
        Studente studente1= new Studente(1, "Giorgio Russo", 96.14);
        Studente studente2= new Studente(2, "Giovanni Pascoli", 87.66);
        Studente studente3= new Studente(3, "Arnaldo Ponzi", 76.33);

        registroStudenti.aggiungiStudente(studente1);
        registroStudenti.aggiungiStudente(studente2);
        registroStudenti.aggiungiStudente(studente3);

        registroStudenti.accessoRegistro();

    }
}