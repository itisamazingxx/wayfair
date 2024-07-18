package com.itisamazing.wayfair.test;

import com.itisamazing.wayfair.dao.impl.AdminDAO;
import com.itisamazing.wayfair.dao.impl.AdminDAOImpl;
import com.itisamazing.wayfair.entity.Admin;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class AdminDAOImplTest {

    private AdminDAO adminDAO = new AdminDAOImpl();

    @Test
    public void queryAdminByUsernameAndPasswordTest() {
        Admin admin = adminDAO.queryAdminByUsernameAndPassword("admin", "123456");
        assertNotNull("The admin should not be null", admin);
    }
}
