package com.frete.controle.controller;

import java.util.Date;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.frete.controle.dto.RegisterDTO;
import com.frete.controle.model.AppUser;
import com.frete.controle.repository.AppUserRepository;



@Controller
public class AccountController {

    @Autowired
    private AppUserRepository appUserRepository; // Injeção do repositório

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDTO registerDTO = new RegisterDTO();
        model.addAttribute("registerDTO", registerDTO);
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(
        Model model,
        @Valid @ModelAttribute RegisterDTO registerDTO,
        BindingResult result
    ) {
        // Verifica se as senhas coincidem
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            result.addError(
                new FieldError("registerDTO", "confirmPassword", "As senhas não são iguais")
            );
        }

        // Verifica se o email já está cadastrado
        AppUser appUser = appUserRepository.findByEmail(registerDTO.getEmail());
        if (appUser != null) {
            result.addError(
                new FieldError("registerDTO", "email", "Email já cadastrado")
            );
        }

        // Retorna erros para a view
        if (result.hasErrors()) {
            return "register";
        }

        try {
            // Criação de uma nova conta
            BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

            AppUser newUser = new AppUser();
            newUser.setFirstName(registerDTO.getFirstName());
            newUser.setLastName(registerDTO.getLastName());
            newUser.setEmail(registerDTO.getEmail());
            newUser.setPhone(registerDTO.getPhone());
            newUser.setAddress(registerDTO.getAddress());
            newUser.setRole(registerDTO.getRole());
            newUser.setCreatedAt(new Date());
            newUser.setPassword(bcryptEncoder.encode(registerDTO.getPassword()));
            
            appUserRepository.save(newUser);

            model.addAttribute("registerDTO", new RegisterDTO());
            model.addAttribute("success", true);
            // Redireciona para uma página de sucesso
            return "register";

        } catch (Exception ex) {
            result.addError(
                new FieldError("registerDTO", "firstName", "Erro ao criar conta: " + ex.getMessage())
            );
            return "register";
        }
    }
}
