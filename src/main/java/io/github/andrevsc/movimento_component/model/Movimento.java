package io.github.andrevsc.movimento_component.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimento")
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
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
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Construtores
    public Movimento() {
        this.createdAt = LocalDateTime.now();
    }
    
    public Movimento(String nome, String tipo, String categoria, Integer poder, Integer precisao, Integer ppMax) {
        this();
        this.nome = nome;
        this.tipo = tipo;
        this.categoria = categoria;
        this.poder = poder;
        this.precisao = precisao;
        this.ppMax = ppMax;
    }
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
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
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    @Override
    public String toString() {
        return "Movimento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", poder=" + poder +
                ", precisao=" + precisao +
                ", ppMax=" + ppMax +
                '}';
    }
}