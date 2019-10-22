package com.itrum.ssm.demo.test;


import com.itrum.ssm.demo.dao.IRole;
import com.itrum.ssm.demo.domain.Role;
import com.itrum.ssm.demo.web.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import java.lang.reflect.Method;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:spring-security.xml"})
public class RoleTest {

    @Autowired
    private IRole iRole;

    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    @Test
    public void  test() throws Exception{
        for (Role role : iRole.findRoleByUserId("1")) {
            System.out.println("role = " + role);
        }
    }
    @Test
    public void test2(){
        System.out.println(bCryptPasswordEncoder.encode("123"));
    }


    @Test
    public void test3() throws NoSuchMethodException {
        ProductController productController = new ProductController();
        Class clazz = productController.getClass();
        Class [] classes =new Class[3];
        classes[0]= Model.class;
        classes[1]= Integer.class;
        classes[2]= Integer.class;
        for (int i = 0; i < classes.length; i++) {
            System.out.println(classes[i]);
        }
        Method method = clazz.getDeclaredMethod("findAll", classes);
        System.out.println(method.getName());
    }

}
