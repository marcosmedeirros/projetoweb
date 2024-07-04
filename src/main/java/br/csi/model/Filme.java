package br.csi.model;

public class Filme {
    public Integer idfilme;
    public String nomefilme;
    public Float notamedia;
    public String ano;
    public String categoria;
    public String descricao;
    public String imagem;


    public Filme(String nomefilme, String imagem) {
        this.nomefilme = nomefilme;
        this.imagem = imagem;
    }

    public Filme(Integer idfilme, String nomefilme, float notamedia, String imagem) {
        this.idfilme = idfilme;
        this.nomefilme = nomefilme;
        this.notamedia = notamedia;
        this.imagem = imagem;
    }

    public Filme( String nomefilme, String ano, String categoria, String descricao, String imagem) {
        this.nomefilme = nomefilme;
        this.ano = ano;
        this.categoria = categoria;
        this.descricao = descricao;
        this.imagem = imagem;

    }

    public Filme(Integer idfilme, String nomefilme, String ano, String categoria, String descricao, String imagem) {
        this.idfilme = idfilme;
        this.nomefilme = nomefilme;
        this.ano = ano;
        this.categoria = categoria;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public Filme(Integer idfilme, String nomefilme, String ano, String categoria, String descricao, String imagem, Float notamedia) {
        this.idfilme = idfilme;
        this.nomefilme = nomefilme;
        this.ano = ano;
        this.categoria = categoria;
        this.descricao = descricao;
        this.imagem = imagem;
        this.notamedia = notamedia;
    }





    public Filme(String nomefilme) {
        this.nomefilme = nomefilme;
    }

    public Integer getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(Integer idfilme) {
        this.idfilme = idfilme;
    }

    public String getNomefilme() {
        return nomefilme;
    }

    public void setNomefilme(String nomefilme) {
        this.nomefilme = nomefilme;
    }

    public Float getNotamedia() {
        return notamedia;
    }

    public void setNotamedia(Float notamedia) {
        this.notamedia = notamedia;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
