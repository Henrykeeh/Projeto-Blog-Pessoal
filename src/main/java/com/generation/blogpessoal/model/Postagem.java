package com.generation.blogpessoal.model;

import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity //@Entity transforma a classe em tabela através do JPA
@Table(name = "tb_postagens") //@Table define o nome para a tabela, caso não coloque o table ele criará com um nome genérico
public class Postagem {
	
	//Variáveis que se transformarão em colunas no MySQL
	@Id // Anotação para indicar a PK - primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação para regra de auto increment no ID
	private Long id; // o Long se transformará em BIGINT no MySQL
	
	@NotBlank // Anotação para não nulo e não vazio (ou seja, não aceita nem mesmo apenas espaços, diferente do NotNull
	@Size(min = 3, max = 100) // Anotação para o VARCHAR, define o tamanho necessário, minimo e máximo da String
	private String titulo;
	
	@NotBlank
	@Size(min = 10, max = 1000)
	private String texto;
	
	@UpdateTimestamp // Toda postagem criada pegarao automaticamente a data e hora atual do usuário
	private LocalDate data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema; //Foreign Key, do tipo "Tema" que é a outra tabela, pegará automaticamente o PK id
	
	//Getters e Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
	
}
