package kr.hs.sdh.workbook2.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.hs.sdh.workbook2.entity.Hamburger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public final class LotteriaHamburgerRepository implements HamburgerRepository, InitializingBean {

    private final ObjectMapper objectMapper;

    @Value(value = "classpath:static/lotteria-menu.json")
    private Resource lotteriaMenuResource;

    private Set<Hamburger> hamburgers;

    public LotteriaHamburgerRepository(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try (var inputStream = lotteriaMenuResource.getInputStream()) {
            final var hamburgerTypeReference = new TypeReference<Set<Hamburger>>() {
            };

            this.hamburgers = this.objectMapper.readValue(inputStream, hamburgerTypeReference);
        }
    }

//    public Set<String> stringSet = new HashSet<>();
//
//    void test() {
//        stringSet.add("가");
//        stringSet.add("나");
//        stringSet.add("다");
//        stringSet.contains("가");
//    }


    @Override
    public Set<Hamburger> findHamburgers() {
        return this.hamburgers;
    }

    @Override
    public void deleteHamburger(Hamburger hamburger) {
        // 1번
        this.hamburgers.removeIf(beforeHamburger -> beforeHamburger.equals(hamburger));

        // 2번
        if(this.hamburgers.contains(hamburger)) {
            this.hamburgers.remove(hamburger);
        }
    }

    @Override
    public void saveHamburger(Hamburger hamburger) {
//        int hamburgerIdx = hamburgers.indexOf(hamburger);
//
//        if (hamburgerIdx != -1) {
//            hamburgers.set(hamburgerIdx, hamburger);
//        } else {
//            hamburgers.add(hamburger);
//        }
        this.deleteHamburger(hamburger);
        this.hamburgers.add(hamburger);
    }

}