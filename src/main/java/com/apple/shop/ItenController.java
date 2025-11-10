package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor // 롬북 문법
public class ItenController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    public String itemList(Model model){
        List<Item> result = itemRepository.findAll();
        System.out.println(result);
        model.addAttribute("name","홍길동");
        return "list.html";
    }
}
