package com.packt.cardatabase;

import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class OwnerRepositoryTest {
    @Autowired
    private OwnerRepository repository;

    @Test
    @DisplayName("첫 번 째 테스트 : ")
    void saveOwner() {
            repository.save(new Owner("일", "김"));
            assertThat(
                    repository.findByFirstname("일").isPresent()
            ).isTrue();

    }
    @Test
    @DisplayName("테스트 # 2 : Owner 객체가 올바르게 삭제되는지 확인")
    void  dleleteOwner() {
        repository.save(new Owner("이", "김"));       // 객체를 생성해서 OwnerRepository에 저장
        repository.deleteAll();                     // 전체 삭제하는 메서드 생성
        assertThat(repository.count()).isEqualTo(0);
    }
}












