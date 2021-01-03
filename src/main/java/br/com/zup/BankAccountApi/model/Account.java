package br.com.zup.BankAccountApi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.BankAccountApi.service.AccountService;
import br.com.zup.BankAccountApi.validation.constraints.Unique;

/**
 * 
 * Classe modelo representativa da entidade Conta.
 * 
 * @author Mateus A
 */
@Entity
public class Account {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "BIGINT UNSIGNED")
	private Integer id;

	@Column(nullable = false)
	@NotBlank
	private String name;
	
	@Column(unique = true, nullable = false, length = 125)
	@Email
	@NotBlank
    @Unique(service = AccountService.class, fieldName = "email", message = "Email duplicado")
	private String email;
	
	@Column(unique = true, nullable = false, length = 125)
	@CPF(message = "Número do CPF inválido")
	@NotBlank
	@Unique(service = AccountService.class, fieldName = "cpf", message = "CPF duplicado")
	private String cpf;
	
	@Column(name = "dateOfBirth", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Não pode estar vazia")
	@Past
	private Date dateOfBirth;

	
	// Getters e Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}