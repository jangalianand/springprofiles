package com.profiles.springprofile;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
public class SpringprofileApplicationDevTest {
    @Autowired
    private DataSource dataSource;

    @Test
    void whenProdProfile_thenProdDbProperties() {
        assertThat(dataSource).isInstanceOf(BasicDataSource.class);
        BasicDataSource basicDataSource = (BasicDataSource) dataSource;
        assertThat(basicDataSource.getUrl()).isEqualTo("jdbc:mysql://prodserver:3306/proddb");
        assertThat(basicDataSource.getUsername()).isEqualTo("produser");
        assertThat(basicDataSource.getPassword()).isEqualTo("prodpassword");
    }
}
