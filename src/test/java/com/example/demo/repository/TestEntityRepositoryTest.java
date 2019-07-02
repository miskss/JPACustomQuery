package com.example.demo.repository;

import com.example.demo.entity.TestEntity;
import com.example.demo.model.CustomQuery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestEntityRepositoryTest {

    List<TestEntity> testEntities;

    @Autowired
    private TestEntityRepository testEntityRepository;
    @Before
    public void setUp() throws Exception {

        testEntities = new ArrayList<>();

        testEntities.add(new TestEntity("i","系","男",20));
        testEntities.add(new TestEntity("ii","细","女",21));
        testEntities.add(new TestEntity("iii","系","男",22));
        testEntities.add(new TestEntity("iiii","系","女",23));
        testEntities.add(new TestEntity("iiiii","系","女",24));
        testEntities.add(new TestEntity("iiiiii","系","男",25));
        testEntityRepository.saveAll(testEntities);

    }

    @Test
    public void getPageTest(){
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.Direction.DESC, "create_time");
        Page<CustomQuery> page = testEntityRepository.getPage(pageRequest);

        assertEquals(3,page.getTotalPages());

        assertEquals(6,page.getTotalElements());

        page.get().map(CustomQuery::getString).forEach(System.out::println);
    }

}