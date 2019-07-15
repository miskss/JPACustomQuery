package com.example.demo.repository;

import com.example.demo.entity.TestEntity;
import com.example.demo.model.CustomQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author peter
 * date: 2019-07-02 11:24
 **/
@SuppressWarnings("ALL")
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {

    @Query(value = "select " +
            " e.id as id , " +
            " e.username as name," +
            " e.nick_name as nick," +
            " e.age as age," +
            " e.gender as sex," +
            " e.enable as enable," +
            " e.create_time as time" +
            " from test_entity e ", countQuery = "select count(*) from test_entity ", nativeQuery = true)
    Page<CustomQuery> getPage(Pageable pageable);
}
