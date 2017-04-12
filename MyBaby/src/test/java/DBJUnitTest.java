/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.MyBaby.bean.Baby;
import com.MyBaby.dao.BabyDao;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author satwa
 */
public class DBJUnitTest {

    private Connection connection;

    @Before
    public void setUp() {
        connection = (Connection) BabyDao.getCon();
    }

    @After
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void addNewBaby() {
        Baby baby = new Baby();
        baby.setName("Ahmed");
        baby.setReligion("Muslims");
        baby.setSex("Male");
        baby.setMeaning("OFFFFF");
        int value  = BabyDao.save(baby);
        assertEquals(1, value);
    }

    @Test
    public void deleteBaby() {
        int value=BabyDao.delete(8);
        assertEquals(1, value);
    }

    @Test
    public void allBabies() {
//        assertEquals(9, BabyDao.getAllRecords().size()); 
    }

}
