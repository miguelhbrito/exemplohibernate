package com.mkyong.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="assinante_cliente")
@Table
public class Assinante {
	
	@GeneratedValue
	@Id
	@Column(name="idAssinante")
	private int id;
	
	private String nome, sexo;
	
	private Date nascimento;
	
	@Column(name="dataCadastro")
	private Date dataRegistro;
	
	
	public Date getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Assinante [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", nascimento=");
		builder.append(nascimento);
		builder.append(", dataRegistro=");
		builder.append(dataRegistro);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
