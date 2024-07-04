package br.csi.model;

public class Avaliacao {
    public Integer idavaliacao;
    public Integer idUsuario;
    public Integer idfilme;
    public Float nota;




    public Avaliacao(Integer idavaliacao, Integer idfilme, Float nota) {
        this.idavaliacao = idavaliacao;
        this.idfilme = idfilme;
        this.nota = nota;
    }

    public Avaliacao(Integer idUsuario, Integer idfilme) {
        this.idUsuario = idUsuario;
        this.idfilme = idfilme;

    }

    public Avaliacao(Integer idfilme, Float nota) {
        this.idfilme = idfilme;
        this.nota = nota;
    }

    public Integer getIdavaliacao() {
        return idavaliacao;
    }

    public void setIdavaliacao(Integer idavaliacao) {
        this.idavaliacao = idavaliacao;
    }

    public Integer getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(Integer idfilme) {
        this.idfilme = idfilme;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Integer getUsuarioId() {
        return idUsuario;
    }

    public void setUsuarioId(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
