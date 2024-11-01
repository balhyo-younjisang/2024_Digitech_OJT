package kr.hs.sdh.workbook2.repository;

import kr.hs.sdh.workbook2.entity.Hamburger;

import java.util.List;
import java.util.Set;

public interface HamburgerRepository {

    // 햄버거 데이터 전체 조회
    Set<Hamburger> findHamburgers();

    // 햄버거 데이터 삭제
    void deleteHamburger(Hamburger hamburger);

    // 햄버거 데이터 추가/수정
    void saveHamburger(Hamburger hamburger);


}