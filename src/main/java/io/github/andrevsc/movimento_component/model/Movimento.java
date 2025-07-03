package io.github.andrevsc.movimento_component.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movimento")
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimento")
    private Long idMovimento;
    
    @Column(nullable = false, unique = true, length = 50)
    private String nome;
    
    @Column(nullable = false, length = 20)
    private String tipo;
    
    @Column(nullable = false, length = 15)
    private String categoria;
    
    private Integer poder;
    
    @Column(nullable = false)
    private Integer precisao;
    
    @Column(name = "pp_max", nullable = false)
    private Integer ppMax;
    
    public Movimento() {}
    
    public Movimento(String nome, String tipo, String categoria, Integer poder, Integer precisao, Integer ppMax) {
        this.nome = nome;
        this.tipo = tipo;
        this.categoria = categoria;
        this.poder = poder;
        this.precisao = precisao;
        this.ppMax = ppMax;
    }
    
    public Long getIdMovimento() { return idMovimento; }
    public void setIdMovimento(Long idMovimento) { this.idMovimento = idMovimento; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    
    public Integer getPoder() { return poder; }
    public void setPoder(Integer poder) { this.poder = poder; }
    
    public Integer getPrecisao() { return precisao; }
    public void setPrecisao(Integer precisao) { this.precisao = precisao; }
    
    public Integer getPpMax() { return ppMax; }
    public void setPpMax(Integer ppMax) { this.ppMax = ppMax; }
}