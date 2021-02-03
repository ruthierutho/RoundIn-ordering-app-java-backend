package com.example.finalproject.controllers;

import com.example.finalproject.models.Menu;
import com.example.finalproject.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MenuController {
    @Autowired
    MenuRepository menuRepository;

    @GetMapping(value= "/menus")
    public ResponseEntity<List<Menu>> getAllMenusAndFilters(
            @RequestParam(required = false, name = "name") String name
    ) {
        if (name != null){
            return new ResponseEntity<>(menuRepository.findAllByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(menuRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/menus/{id}")
    public ResponseEntity getMenu(@PathVariable Long id) {
        return new ResponseEntity<>(menuRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/menus/venue/{id}")
    public ResponseEntity getMenus(@PathVariable Long id) {
        return new ResponseEntity<>(menuRepository.findAllByVenuesId(id), HttpStatus.OK);
    }

    @PostMapping(value = "/menus")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        menuRepository.save(menu);
        return new ResponseEntity<> (menu, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/menus/{id}")
    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu){
        menuRepository.save(menu);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @DeleteMapping(value = "/menus/delete/{id}")
    public ResponseEntity deleteMenu(@PathVariable Long id) {
        Menu deletedMenu = menuRepository.getOne(id);
        menuRepository.deleteById(id);
        return new ResponseEntity<>(deletedMenu, HttpStatus.OK);
    }
}
