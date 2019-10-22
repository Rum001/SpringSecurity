package com.itrum.ssm.demo.web;

import com.github.pagehelper.PageInfo;
import com.itrum.ssm.demo.domain.Orders;
import com.itrum.ssm.demo.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService iOrdersService;

    //    @RequestMapping("findAll.do")
//    public String findAll(Model model) throws Exception{
//        List<Orders> ordersList = iOrdersService.findAll();
//        model.addAttribute("ordersList",ordersList);
//        return "orders-list";
//    }
    @RequestMapping("findAll.do")
    @Secured("ROLE_ADMIN")
    public String findAll(BindingAwareModelMap model, @RequestParam(name = "pageNum",required = true,defaultValue = "1")Integer pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize) throws Exception {
        List<Orders> ordersList = iOrdersService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo<>(ordersList);
        model.addAttribute("pageInfo",pageInfo);
        return "orders-list";
    }

    @RequestMapping("findById.do")
    public String findById(@RequestParam(name = "id",required = true)Integer id,BindingAwareModelMap model) throws Exception{
        Orders orders= iOrdersService.findById(id);
        model.addAttribute("orders",orders);
        return "orders-show";
    }


}
