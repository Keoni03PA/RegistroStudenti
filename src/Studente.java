public class Studente {
    private Integer id;
    private String nome;
    private Double voto;

    public Studente(Integer id, String nome, Double voto) {
        this.id = id;
        this.nome = nome;
        this.voto = voto;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getVoto() {
        return voto;
    }
    public void setVoto(double voto) {
        this.voto = voto;
    }
}
