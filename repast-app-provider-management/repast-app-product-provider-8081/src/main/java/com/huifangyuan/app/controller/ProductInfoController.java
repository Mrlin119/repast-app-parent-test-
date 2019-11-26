package com.huifangyuan.app.controller;

import com.huifangyuan.app.domain.Product;
import com.huifangyuan.app.service.ProductInfoService;
import com.huifangyuan.app.service.ShopInfoService;
import com.huifangyuan.app.vo.ProductVo;
import com.huifangyuan.app.vo.ShopInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 11:00
 * @Description
 **/
@RestController
public class ProductInfoController {

    @Autowired
    ProductInfoService productInfoService;

    /**
     * 根据店铺ID查询所有商品部分信息
     * <>霍晨亮</>
     * @param shopId
     * @return
     */
    @GetMapping("/getAllProduct")
    public List<ProductVo> getAllProductByShopId(Long shopId){
        List<ProductVo> allProductByShopId = productInfoService.getAllProductByShopId(shopId);
        if (allProductByShopId.size()>0){
            return allProductByShopId;
        }
        return null;
    }

    /**
     * 根据商铺的ID查询当前店铺所推荐的商品部分信息
     * <>霍晨亮</>
     * @param shopId
     * @return
     */
    @GetMapping("/getAllShopRecommendProductByShopId")
    public List<Product> getAllShopRecommendProductByShopId(Long shopId) {
        List<Product> allShopRecommendProductByShopId = productInfoService.getAllShopRecommendProductByShopId(shopId);
        if (allShopRecommendProductByShopId.size()>0){
            return allShopRecommendProductByShopId;
        }
        return null;
    }

}
