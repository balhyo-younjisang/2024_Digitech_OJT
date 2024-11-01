package kr.hs.sdh.workbook2.repository;

import kr.hs.sdh.workbook2.entity.Hamburger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LotteriaHamburgerRepositoryTest {
    private Set<Hamburger> hamburgers = new HashSet<>();
    private List<Integer> numbers = new ArrayList<>();

    @Test
    void deleteHamburger() {
        Hamburger appleHamburger = new Hamburger(
                "사과 햄버거",
                100,
                "/none",
                true,
                true
        );

        if(this.hamburgers.contains(appleHamburger)) {
            this.hamburgers.remove(appleHamburger);
        }
    }

    @Test
    void saveHamburger() {
//        Hamburger compareHamburger = new Hamburger(
//                "테스트 햄버거",
//                100,
//                "/none",
//                true,
//                true
//        );
//
//        int hamburgerIdx = hamburgers.indexOf(compareHamburger);
//
//        assertEquals(hamburgerIdx, 0,"Test succeeded");
        Hamburger appleHamburger = new Hamburger(
                "사과 햄버거",
                100,
                "/none",
                true,
                true
        );

        this.hamburgers.add(appleHamburger);
    }

    @BeforeEach
    void beforeTest() {
        Hamburger testHamburger = new Hamburger(
                "테스트 햄버거",
                100,
                "/none",
                true,
                true
        );

        this.hamburgers.add(testHamburger);
    }
}