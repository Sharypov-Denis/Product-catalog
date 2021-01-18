package den.product.repository;

import den.product.model.Products;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/InitDB_HSQL.sql", config = @SqlConfig(encoding = "UTF-8"))
public class ProductsRepositoryTest {

    public final static Integer ID_11= 11;
    public final static Products PRODUCTS11 = new Products("TestName11", "TestDescription11");

    public final static Integer ID_200 = 200;
    public final static Products PRODUCTS200 = new Products("TestName2", "TestDescription2");

    public final static Integer ID_300 = 300;
    public final static Products PRODUCTS300 = new Products("TestName3", "TestDescription3");

    public final static Integer ID_1 = 1;
    public final static Products PRODUCTS1 = new Products(1,"Молоко", "описание продукта");

    public final static Integer ID_7 = 7;
    public final static Products PRODUCTS7 = new Products(7,"Сок", "описание продукта");

    @Autowired
    ProductsRepository repository;

    @Test
    public void save() {
    repository.save(PRODUCTS11);
    assertEquals(repository.findOneProductsByName("TestName11"), PRODUCTS11);
    }

    @Test
    public void update() {
    }

    @Test
    public void get() {
        //repository.save(PRODUCTS200);
        assertEquals(repository.get(1), PRODUCTS1);
    }

    @Test
    public void delete() {
        repository.delete(ID_1);
        assertNull(repository.findOneProductsByName("Молоко"));
    }

    @Test
    public void findOneProductsByName() {
        assertEquals(repository.findOneProductsByName("Сок"), PRODUCTS7);
    }
}