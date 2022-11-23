package com.firstWebRestAPI.controller;

import com.firstWebRestAPI.model.Usuario;
import com.firstWebRestAPI.repository.UsearioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsearioRepository usearioRepository;

    @GetMapping
    public List<Usuario> getUsers(){
        return usearioRepository.listAll();
    }

    @GetMapping("/{username}")
    public Usuario getOneUser(@PathVariable("username") String username){
        return usearioRepository.finByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        usearioRepository.remove(id);
    }

    @PostMapping
    public void postUser(@RequestBody Usuario usuario){
        usearioRepository.save(usuario);
    }
    @PutMapping
    public void putUser(@RequestBody Usuario usuario){
        usearioRepository.save(usuario);
    }

}
