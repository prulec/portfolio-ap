package com.argprograma.portfolio.controller;

import com.argprograma.portfolio.dto.PortfolioData;
import com.argprograma.portfolio.dto.UserData;
import com.argprograma.portfolio.model.SocialType;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    
    /* User */
    
    @PostMapping ("adduser")
    public String addUser (@RequestBody UserData data) {
        // Agrega usuario, pasando 'null' en 'id'
        return "User added";
    }
    
    @GetMapping ("listusers")
    public List<String> getUsers () {
        // Lista con los username existentes
        return null;
    }
    
    @GetMapping ("user/{username}")
    public UserData getUserByUsername (@PathVariable String username) {
        // Muestra datos de usuario SIN la lista de portfolios
        return null;
    }
    
    @PatchMapping ("updateuser")
    public String updateUser (@RequestBody UserData data) {
        // Actualiza datos de usuario que corresponda con id recibida
        return "User updated";
    }
    
    @DeleteMapping ("deleteuser/{username}")
    public String deleteUserByUsername (@PathVariable String username) {
        // Borra usuario y todos los portfolios de su lista
        return "User deleted";
    }
    
    
    /* Portfolio */
    
    @PostMapping ("addportfolio/{username}")
    public String addPortfolio (@PathVariable String username,
                                @RequestBody PortfolioData data) {
        // Agrega portfolio recibiendo id, name,
        // y asignando: visible=false, user buscando por username 
        return "Portfolio added";
    }
    
    @GetMapping ("listportfolios/{username}")
    public List<PortfolioData> getPortfoliosByUsername 
        (@PathVariable String username) {
        // Devuelve lista de portfolios del usuario (sólo id y name)
        return null;
    }
    
    @PatchMapping ("updateportfolioname")
    public String updatePortfolioName (@RequestBody PortfolioData data) {
        // Actualiza name del portfolio que corresponde al id recibido
        return "Portfolio's name updated";
    }
    
    @DeleteMapping ("deleteportfolio/{portfolio_id}")
    public String deletePortfolio (@PathVariable Long portfolio_id) {
        // Elimina portfolio que corresponde al id recibido
        // actualizando lista del usuario correspondiente
        return "Portfolio deleted";
    }
    
    
    /* Portfolio --> SocialType */
    
    @PostMapping ("addsocialtype")
    public String addSocialType (@RequestBody SocialType data) {
        // Agrega un tipo de red social, asignando null a id
        return "Social type added";
    }
    
    @PutMapping ("updatesocialtype")
    public String updateSocialType (@RequestBody SocialType data) {
        // Actualiza SocialType que corresponde al id recibido
        return "Social type updated";
    }
    
    @DeleteMapping ("deletesocialtype/{socialtype_id}")
    public String deleteSocialType (@PathVariable Long socialtype_id) {
        // Elimina SocialType correspondiente al id de la ruta
        return "Social type deleted";
    }
    
    @GetMapping ("socialtypes")
    public List<SocialType> getSocialTypes () {
        // Devuelve todos los tipos de redes sociales registradas
        return null;
    }
    
}
