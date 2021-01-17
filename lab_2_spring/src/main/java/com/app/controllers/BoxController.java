package com.app.controllers;

import com.app.entities.Box;
import com.app.entities.Gift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.app.repositories.BoxRepository;
import com.app.repositories.GiftRepository;

import java.util.List;

@RestController
public class BoxController {

    private final BoxRepository boxRepository;

    private final GiftRepository giftRepository;

    @Autowired
    public BoxController(BoxRepository boxRepository, GiftRepository giftRepository) {
        this.boxRepository = boxRepository;
        this.giftRepository = giftRepository;
    }

    @GetMapping(path = "/boxes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Iterable<Box> findAll(){
        return boxRepository.findAll();
    }

    @PostMapping(path = "/boxes/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Iterable<Box> add(@RequestBody Box newBox){
        System.out.println(newBox.getGift().getId());
        //Gift gift = giftRepository.findById(newBox.getGift().getId()).orElse(null);
//        if (gift == null){
//            giftRepository.save(newBox.getGift());
//        }
        giftRepository.save(newBox.getGift());
//        Box box = boxRepository.findById(newBox.getId()).orElse(null);
//        if (box == null){
//            boxRepository.save(newBox);
//        }
        boxRepository.save(newBox);
        return boxRepository.findAll();
    }

    @DeleteMapping(path = "boxes/delete/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Iterable<Box> delete(@PathVariable Long id){
        Box box = boxRepository.findById(id).orElse(null);
        if (box == null){
            return boxRepository.findAll();
        }
        boxRepository.delete(box);
        Gift gift = giftRepository.findById(box.getGift().getId()).orElse(null);
        if (gift != null){
            try{
                giftRepository.delete(gift);
            } catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return boxRepository.findAll();
    }
}
