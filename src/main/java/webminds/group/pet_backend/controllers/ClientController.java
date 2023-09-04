package webminds.group.pet_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.models.Client;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private List<Client> listClients = new ArrayList<>();

    @GetMapping
    public List<Client> get(){
        return listClients;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable int id){
        if (id >= 0 && id < listClients.size()){
            return ResponseEntity.status(200).body(listClients.get(id));
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody Client client){
        int id = -1;
        for (int i = 0; i < listClients.size(); i++){
            if(listClients.get(i).getEmail().equals(client.getEmail())){
                id = i;
            }
        }
        if(id != -1){
            if (listClients.get(id).getSenha().equals(client.getSenha())){
                return ResponseEntity.status(200).body("Bem vindo!");
            }else{
                return ResponseEntity.status(404).body("Email ou senha incorreta");
            }
        }
        else{
            return ResponseEntity.status(400).body("Email ou senha incorreta");
        }

    }

    @PostMapping
    public ResponseEntity<Client> post(@RequestBody Client client){
        if (client.getEmail().isBlank() || client.getEmail() == null || client.getEmail().length() < 5 || !client.getEmail().contains("@")){
            return ResponseEntity.status(400).build();
        }else if(client.getSenha().isBlank() || client.getSenha() == null || client.getSenha().length() < 3){
            return ResponseEntity.status(400).build();
        }
        listClients.add(client);
        return ResponseEntity.status(201).body(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> put(@RequestBody Client updateClient, @PathVariable int id){
        if (id >= 0 && id < listClients.size()){
            if (updateClient.getEmail().isBlank() || updateClient.getEmail() == null || updateClient.getEmail().length() < 5 || !updateClient.getEmail().contains("@")){
                return ResponseEntity.status(400).build();
            }else if(updateClient.getSenha().isBlank() || updateClient.getSenha() == null || updateClient.getSenha().length() < 3) {
                return ResponseEntity.status(400).build();
            }
            listClients.set(id, updateClient);
            return ResponseEntity.status(200).body(updateClient);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if (id >= 0 && id < listClients.size()){
            listClients.remove(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

}
