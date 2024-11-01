package kr.hs.sdh.workbook2.controller;

import kr.hs.sdh.workbook2.entity.Hamburger;
import kr.hs.sdh.workbook2.service.HamburgerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public final class HamburgerController {
    private final HamburgerService hamburgerService;

    public HamburgerController(HamburgerService hamburgerService) {
        this.hamburgerService = hamburgerService;
    }

    @GetMapping(value = "/lotteria")
    private String lotteria(final Model model) {
        return "lotteria";
    }

    @GetMapping(value = "/lotteria-example")
    private ModelAndView lotteriaExample() {
        ModelAndView mav = new ModelAndView("lotteria-example");
        List<Hamburger> hamburgerList = hamburgerService.getHamburgers();
        mav.addObject("hamburgerList", hamburgerList);

        return mav;
    }

}
