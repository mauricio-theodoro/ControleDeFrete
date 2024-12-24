package com.frete.controle.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) para registrar novos usuários.
 * 
 * Este DTO é utilizado para encapsular os dados necessários para a criação
 * de um novo usuário no sistema, separando as preocupações entre a camada de
 * entrada de dados (controller) e a entidade do modelo (AppUser).
 */
public class RegisterDTO {

    @NotBlank(message = "O primeiro nome é obrigatório.")
    private String firstName;

    @NotBlank(message = "O último nome é obrigatório.")
    private String lastName;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    private String phone;

    @NotBlank(message = "O endereço é obrigatório.")
    private String address;

    @NotBlank(message = "O papel do usuário é obrigatório.")
    private String role;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres.")
    private String password;

    @NotBlank(message = "A confirmação da senha é obrigatória.")
    private String confirmPassword;

    @AssertTrue(message = "As senhas devem coincidir.")
    public boolean isPasswordMatching() {
        return password != null && password.equals(confirmPassword);
    }

    /**
     * Construtor vazio - necessário para frameworks de serialização/deserialização.
     */
    public RegisterDTO() {
    }

    /**
     * Construtor parametrizado para inicialização de valores.
     * 
     * @param firstName Primeiro nome do usuário
     * @param lastName  Último nome do usuário
     * @param email     Email do usuário
     * @param phone     Telefone de contato do usuário
     * @param address   Endereço do usuário
     * @param role      Papel do usuário no sistema
     * @param password  Senha do usuário
     * @param confirmPassword Confirmação da senha do usuário
     */
    public RegisterDTO(String firstName, String lastName, String email, String phone, String address, String role,
                       String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    // Getters e Setters

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
