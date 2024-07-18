package com.itisamazing.wayfair.test;

import com.itisamazing.wayfair.service.AdminService;
import com.itisamazing.wayfair.service.AdminServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class AdminServiceImplTest {

    private AdminService adminService = new AdminServiceImpl();

    @Test
    public void isAdminExist() {
        boolean result = adminService.isAdminExist("admin", "123456");
        assertNotNull("The admin should not be null", result);
    }
}
