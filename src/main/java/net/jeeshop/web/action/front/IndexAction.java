package net.jeeshop.web.action.front;

import net.jeeshop.services.front.indexImg.IndexImgService;
import net.jeeshop.services.front.indexPage.IndexPageService;
import net.jeeshop.services.front.indexPage.bean.IndexPage;
import net.jeeshop.services.front.product.ProductService;
import net.jeeshop.services.front.product.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 前端首页
 */
@Controller
@RequestMapping("/")
public class IndexAction {

    @Autowired
    private IndexPageService indexPageService;
    @Autowired
    private ProductService productService;


  /*  @RequestMapping({"/","/index-new"})
    public String index(Model model) {
        IndexPage SearchBean = new IndexPage();
        List<IndexPage> list = indexPageService.selectList(SearchBean);
        IndexPage indexPage = list.get(0);
        Product product = new Product();
        List<Product> productList1 = new ArrayList();
        List<Product> productList2 = new ArrayList();
        List<Product> productList3 = new ArrayList();
        List<Product> productList4 = new ArrayList();
        if (indexPage.getCommodityAreaStr1() != null && indexPage.getCommodityAreaStr1() != "") {
            product.setProductIds(Arrays.asList(indexPage.getCommodityAreaStr1().split(",")));
            productList1 = productService.selectProductListByIds(product);
        }
        if (indexPage.getCommodityAreaStr2() != null && indexPage.getCommodityAreaStr2() != "") {
            product.setProductIds(Arrays.asList(indexPage.getCommodityAreaStr2().split(",")));
            productList2 = productService.selectProductListByIds(product);
        }
        if (indexPage.getCommodityAreaStr3() != null && indexPage.getCommodityAreaStr3() != "") {
            product.setProductIds(Arrays.asList(indexPage.getCommodityAreaStr3().split(",")));
            productList3 = productService.selectProductListByIds(product);
        }
        if (indexPage.getCommodityAreaStr4() != null && indexPage.getCommodityAreaStr4() != "") {
            product.setProductIds(Arrays.asList(indexPage.getCommodityAreaStr4().split(",")));
            productList4 = productService.selectProductListByIds(product);
        }
        model.addAttribute("indexPage", indexPage);
        model.addAttribute("productList1", productList1);
        model.addAttribute("productList2", productList2);
        model.addAttribute("productList3", productList3);
        model.addAttribute("productList4", productList4);
        return "index-new";
    }
*/

    @RequestMapping({"/","/index"})
    public String indexOld() {
        return "index";
    }

}
