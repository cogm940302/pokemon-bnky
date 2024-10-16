package com.bankaya.pokemon.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InfoRepositoryTest {

    @Autowired
    private InfoRepository infoRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsertDataInfo() {
        ReflectionTestUtils.setField(infoRepository, "jdbcTemplate", jdbcTemplate);
        Mockito.when(jdbcTemplate.update("INSERT INTO BNKY.POKE01_RQST (TX_IP, TX_METHOD, NU_TIME_REQUEST, TX_REQUEST, TX_RESPONSE) "
                        + "VALUES (\"127.0.0.1\", \"metodo\", 200, \"pikachu\", \"success\")", Integer.class))
                .thenReturn(1);
        assertDoesNotThrow(() -> {
            infoRepository.insertDataInfo("127.0.0.1", "metodo", 200, "pikachu", "success");
        });
    }
}