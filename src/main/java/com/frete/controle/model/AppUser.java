package com.frete.controle.model;

import java.util.Date;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Representa a entidade de usuário no sistema de controle de frete.
 * Essa classe utiliza JPA para persistência e mapeamento de dados.
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))// Define o nome da tabela no banco de dados
public class AppUser {

    // Identificador único do usuário (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática de IDs
    private Long id;

    // Primeiro nome do usuário
    @Column(name = "first_name", nullable = false, length = 50) // Não pode ser nulo, limite de 50 caracteres
    private String firstName;

    // Último nome do usuário
    @Column(name = "last_name", nullable = false, length = 50) // Não pode ser nulo, limite de 50 caracteres
    private String lastName;

    // Email do usuário, deve ser único
    
    @Column(name = "email", nullable = false, unique = true, length = 100) // Único e obrigatório
    private String email;

    // Telefone de contato do usuário
    @Column(name = "phone", length = 15) // Limite de caracteres para telefone
    private String phone;

    // Endereço do usuário
    @Column(name = "address", length = 255) // Limite de caracteres para endereços
    private String address;

    // Papel do usuário no sistema (ex.: ADMIN, USER)
    @Column(name = "role", nullable = false, length = 20) // Obrigatório
    private String role;

    // Data e hora de criação do registro
    @CreationTimestamp // Preenchido automaticamente no momento da criação
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false) // Não pode ser atualizado
    private Date createdAt;

    // Data e hora da última atualização do registro
    @UpdateTimestamp // Atualizado automaticamente em cada modificação
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    // Senha do usuário (armazenada em formato seguro, como hash)
    @Column(name = "password", nullable = false) // Obrigatório
    private String password;

    /**
     * Construtor vazio - necessário para o funcionamento do JPA.
     */
    public AppUser() {
    }

    /**
     * Construtor parametrizado para inicialização de valores.
     * 
     * @param firstName Nome do usuário
     * @param lastName  Sobrenome do usuário
     * @param email     Email do usuário
     * @param phone     Telefone do usuário
     * @param address   Endereço do usuário
     * @param role      Papel do usuário
     * @param password  Senha do usuário
     */
    public AppUser(String firstName, String lastName, String email, String phone, String address, String role,
                   String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.password = password;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
