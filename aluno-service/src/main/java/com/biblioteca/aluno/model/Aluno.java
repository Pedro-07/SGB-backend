package com.biblioteca.aluno.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
@Table(name= "aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@Past(message = "Data deve ser no passado")
	private LocalDate dataNasc;
	
	@Column(nullable=false)
	@Email
	@NotBlank
	private String email;
	
	@NotNull(message = "Curso é obrigatório")
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "curso_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Curso curso;

	
	@NotBlank(message = "Turno é obrigatório")
	private String turno;
	
    @Column(unique = true)
	private Integer matricula;
	
    
    @PrePersist
    @PreUpdate
    public void prepararDados() {
        // Coloca o nome em caixa alta
        if (this.nome != null) {
            this.nome = this.nome.toUpperCase();
        }

        // Gera matrícula apenas no momento de persistência
        if (this.matricula == null) {
            this.matricula = (int) (Math.random() * 9000) + 1000;
        }
    }
	public Aluno() {}

	public Aluno(String nome, LocalDate dataNasc, Curso curso, String turno, Integer matricula, Long id_aluno) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.curso = curso;
		this.turno = turno;
		this.matricula = matricula;
		this.id = id_aluno;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	//to-do
	public Object map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
