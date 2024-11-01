package kr.hs.sdh.workbook2.controller;

import kr.hs.sdh.workbook2.entity.Hamburger;
import kr.hs.sdh.workbook2.service.HamburgerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

@RestController
public class HamburgerRestController {
    private final HamburgerService hamburgerService;

    public HamburgerRestController(HamburgerService hamburgerService) {
        this.hamburgerService = hamburgerService;
    }

    @GetMapping("/lotteria-menus")
    private List<Hamburger> lotteriaMenus(@RequestParam(required = false) String name) {
        List<Hamburger> hamburgers = this.hamburgerService.getHamburgers();
        if(name == null || name.isEmpty()) {
            return hamburgers;
        }

        return hamburgers.stream().filter(hamburger -> hamburger.getName().contains(name)).toList();
    }
}
