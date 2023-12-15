import java.util.ArrayList;
import java.util.Scanner;


public class Registro {
    private ArrayList<Studente> registroArrayList= new ArrayList<>();
    public Registro(){}
    public Registro(ArrayList<Studente> registroArrayList) {
        this.registroArrayList = registroArrayList;
    }

    public ArrayList<Studente> getRegistroArrayList() {
        return registroArrayList;
    }
    public void elencoStudenti() {
        System.out.println("Elenco Studenti: ");
        for (Studente studente : registroArrayList) {
            System.out.println("-ID- " + studente.getId() + ", -NOME- " + studente.getNome() + ", -VOTO- " + studente.getVoto());
        }
        System.out.println(" ");
    }
    public void cercaStudenti(Integer id){
        try {
            boolean isContenuta = false;
            for (Studente studente : registroArrayList) {
                if (studente.getId().equals(id)) {
                    isContenuta= true;
                    System.out.println("-ID- " + studente.getId() + ", -NOME- " + studente.getNome() + ", -VOTO- " + studente.getVoto());
                }
            }
            if(!isContenuta){
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("\u001b[31mThere was a mistake! \nID\u001b[0m non presente! ");

        }
    }
    public void aggiungiStudente(Studente studente) {
        try{
            for (Studente studenteVar : registroArrayList) {
                if (studenteVar.getId().equals(studente.getId())) {
                    throw new Exception();
                }
            }
            registroArrayList.add(studente);
            System.out.println("Lo studente \""+ studente.getNome()+"\" è stato aggiunto con successo al registro");
        }catch (Exception e){
            System.out.println("There was an error");
        }
    }
    public void rimuoviStudente(Integer id) {
        try{
            boolean isContenuta = false;
            for (Studente studente : registroArrayList) {
                if (studente.getId().equals(id)) {
                    isContenuta= true;
                    System.out.println("Studente/esse rimosso con successo");
                }
            }
            if(!isContenuta){
                throw new Exception();
            }

        }catch (Exception e){
            System.out.println("\u001b[31m-ID non valido!-\u001b[0m");
        }
    }
    public void modificaStudente(Integer id){
        try{
            boolean isContenuta= false;
            if(id == null || id < 0){
                throw new Exception();
            } else{
                for (Studente studente : registroArrayList) {
                    if (studente.getId().equals(id)) {
                        isContenuta = true;
                        break;
                    }
                }
            }
            if(!isContenuta){
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("\u001b[31m-ID non valido-\u001b[0m");
        }
        System.out.println("Scegliere quale informazione modificare:");
        System.out.println("-ID");
        System.out.println("-NOME");
        System.out.println("-VOTO");
        Scanner scanner= new Scanner(System.in);
        String opzModificaIns= scanner.next();
        switch (opzModificaIns){
            case "ID":
                try{
                    System.out.println("Scegliere nuovo ID");
                    int idIns= scanner.nextInt();

                    boolean isContenuta= false;
                    if(idIns < 0){
                        throw new Exception();
                    } else{
                        for (Studente studente : registroArrayList) {
                            if (studente.getId().equals(idIns)) {
                                isContenuta = true;
                                break;
                            }
                        }
                    }
                    if(isContenuta){
                        throw new Exception();
                    }
                    for(Studente studente : registroArrayList) {
                        if (studente.getId().equals(id)) {
                            studente.setId(idIns);
                            break;
                        }
                    }
                }catch (Exception e){
                    System.out.println("\u001b[31m-ID non valido-\u001b[0m");
                }
                break;
            case "NOME":
                for(Studente studente : registroArrayList) {
                    if (studente.getId().equals(id)) {
                        System.out.println("Scegliere Nuovo NOME Studente");
                        studente.setNome(scanner.next());
                        break;
                    }
                }
            case "VOTO":
                try{
                    for (Studente studente : registroArrayList) {
                        if (studente.getId().equals(id)) {
                            double votoIns= scanner.nextDouble();
                            if(votoIns < 0.0 || votoIns > 110.0 ){
                                throw new Exception();
                            }else {
                                studente.setVoto(votoIns);
                                break;
                            }
                        }
                    }
                }catch (Exception e){
                    System.out.println("\u001b[31m-ID/VOTO non valido-\u001b[0m");
                }
                break;
            default:
                System.out.println("Errore, opzione inserita non valida");
                break;
        }
    }
    public void accessoRegistro() {
        System.out.println("\n-Benvenuto nel Registro Studenti \n ");
        System.out.println("\u001b[31m-- Operazioni Disponibili --\u001b[0m");
        System.out.println("\u001b[31m1\u001b[0m. Aggiungi uno Studente");
        System.out.println("\u001b[31m2\u001b[0m. Rimuovi uno Studente");
        System.out.println("\u001b[31m3\u001b[0m. Modifica Studente");
        System.out.println("\u001b[31m4\u001b[0m. Visualizza Elenco Studenti");
        System.out.println("\u001b[31m5\u001b[0m. Cerca Studente");
        System.out.println("\u001b[31m6\u001b[0m. Esci dal Registro\n ");

        System.out.println("Scegli il numero dell'operazione da effettuare:\n ");
        Scanner scanner = new Scanner(System.in);
        int opzRegistro= scanner.nextInt();

        switch (opzRegistro) {
            case 1:
                try{
                    boolean isDisponibile = true;
                    if(!isDisponibile) {
                        throw new Exception();
                    }
                }catch (Exception e){
                    System.out.println("\u001b[31mAccesso Negato! Maintanance in Progress \u001b[0m \nRiavvio del registro \n ");
                    accessoRegistro();
                    break;
                }

                System.out.println("Inserire ID Nuovo Studente");
                int idIns= scanner.nextInt();

                System.out.println("Inserire NOME Nuovo Studente");
                String nomeIns= scanner.next();

                System.out.println("Inserire VOTO Nuovo Studente");
                double votoIns= scanner.nextDouble();

                aggiungiStudente(new Studente(idIns, nomeIns, votoIns));

                accessoRegistro();
                break;
            case 2:
                try{
                    boolean isDisponibile = true;
                    if(!isDisponibile) {
                        throw new Exception();
                    }
                }catch (Exception e){
                    System.out.println("\u001b[31mAccesso Negato! Maintanance in Progress \u001b[0m \nRiavvio del registro \n ");
                    accessoRegistro();
                    break;
                }

                System.out.println("Inserire ID Studente\n ");
                int opzRegistro2= scanner.nextInt();

                rimuoviStudente(opzRegistro2);

                accessoRegistro();
                break;
            case 3:
                try{
                    boolean isDisponibile = true;
                    if(!isDisponibile) {
                        throw new Exception();
                    }
                }catch (Exception e){
                    System.out.println("\u001b[31mAccesso Negato! Maintanance in Progress \u001b[0m \nRiavvio del registro \n ");
                    accessoRegistro();
                    break;
                }

                System.out.println("Inserire ID Studente\n ");
                int opzRegistro3= scanner.nextInt();

                modificaStudente(opzRegistro3);

                accessoRegistro();
                break;
            case 4:
                try{
                    boolean isDisponibile = true;
                    if(!isDisponibile) {
                        throw new Exception();
                    }
                }catch (Exception e){
                    System.out.println("\u001b[31mAccesso Negato! Maintanance in Progress \u001b[0m \nRiavvio del registro \n ");
                    accessoRegistro();
                    break;
                }

                elencoStudenti();

                accessoRegistro();
                break;
            case 5:
                try{
                    boolean isDisponibile = true;
                    if(!isDisponibile) {
                        throw new Exception();
                    }
                }catch (Exception e){
                    System.out.println("\u001b[31mAccesso Negato! Maintanance in Progress \u001b[0m \nRiavvio del registro \n ");
                    accessoRegistro();
                    break;
                }

                System.out.println("Inserire ID Studente\n ");
                int opzRegistro5= scanner.nextInt();

                cercaStudenti(opzRegistro5);

                accessoRegistro();
                break;
            case 6:
                try{
                    boolean isDisponibile = true;
                    if(!isDisponibile) {
                        throw new Exception();
                    }
                }catch (Exception e){
                    System.out.println("\u001b[31mAccesso Negato! Maintanance in Progress \u001b[0m \nRiavvio del registro \n ");
                    accessoRegistro();
                    break;
                }

                System.out.println("Uscita dal Registro in corso...");
                break;
            default:
                System.out.println("Operazione selezionata non valida \nRiavvio registro\n");
                accessoRegistro();
                break;
        }
    }
}



































/*
[31m(Work in Progress)[0m

                try{
                    boolean isDisponibile = false;
                    if(!isDisponibile) {
                        throw new Exception();
                    }
                }catch (Exception e){
                    System.out.println("\u001b[31mAccesso Negato! Maintanance in Progress \u001b[0m \nRiavvio del registro \n ");
                    accessoRegistro();
                }
 */