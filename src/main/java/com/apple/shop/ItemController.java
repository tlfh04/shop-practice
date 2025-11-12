package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor // 롬북 문법
public class ItemController {

    // 룸북 문법 사용으로 인해 생성자를 따로 만들지 않아도 됌
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    public String itemList(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items",result);
        var a = new Item();

        return "list.html";
    }
    @GetMapping("/write")
    String Write(){
        return "write.html";
    }
    @PostMapping("/add")
    String addPost(String title,Integer price){

        itemService.saveItem(title,price);
        return "redirect:/list";
    }
    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {

        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()){
            Item item = result.get();
            model.addAttribute("item",item);
            return "detail.html";
        }else{
            return "redirect:/list";
        }
    }

}
