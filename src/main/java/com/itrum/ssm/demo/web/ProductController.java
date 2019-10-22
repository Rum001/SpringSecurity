package com.itrum.ssm.demo.web;

import com.github.pagehelper.PageInfo;
import com.itrum.ssm.demo.domain.Product;
import com.itrum.ssm.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    //    @RequestMapping("list.do")
//    @ResponseBody
//    public List<Product> list() throws Exception{
//        return iProductService.findAll();
//    }
    @RequestMapping("findAll.do")
    @RolesAllowed("ADMIN")
    public String findAll(BindingAwareModelMap model, @RequestParam(name = "pageNum",required = true,defaultValue = "1")Integer pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize) throws Exception {
        List<Product> productList = iProductService.findAll(pageNum,pageSize);
//        products.forEach(product -> product.setDepartureTimeStr(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
//                .format(product.getDepartureTime())));
//        products.forEach(product -> product.setProductStatusStr(product.getProductStatus().toString()));
//        model.addAttribute("productList", products);
        PageInfo pageInfo=new PageInfo(productList);
        model.addAttribute("pageInfo",pageInfo);
        return "product-list";
    }


    @RequestMapping("save.do")
    public String save(Product product)  throws Exception{
        iProductService.save(product);
        return "redirect:findAll.do";
    }
}
