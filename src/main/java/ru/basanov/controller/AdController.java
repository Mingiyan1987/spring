package ru.basanov.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.basanov.model.Ad;
import ru.basanov.service.AdService;

@Controller
@URLMapping(
        id = "dateBean",
        pattern = "/Ad",
        viewId = "/WEB-INF/views/Ad.xhtml"
)
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping("ad-list")
    public String adList(final Model model) {
        final Iterable<Ad> ads = adService.findAll();
        model.addAttribute("ads", ads);
        return "ad-list";
    }


}
