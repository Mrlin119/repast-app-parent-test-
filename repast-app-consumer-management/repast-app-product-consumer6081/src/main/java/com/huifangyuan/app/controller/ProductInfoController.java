package com.huifangyuan.app.controller;

import com.huifangyuan.app.base.BaseController;
import com.huifangyuan.app.base.ResultData;
import com.huifangyuan.app.domain.Product;
import com.huifangyuan.app.service.IRepastService;
import com.huifangyuan.app.vo.ProductVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 10:55
 * @Description
 *      商家controller
 **/
@RestController
@Api(value = "商品信息", tags = "商品信息接口")
public class ProductInfoController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 根据店铺ID查询所有商品的信息
     * @param shopId
     * @return
     */
    @GetMapping("/getAllProductByShopId")
    @ApiOperation(value = "商品信息", notes = "通过店铺主键查询商品信息")
    public ResultData getAllProductByShopId(Long shopId){
        List<ProductVo> allProductByShopId = repastService.getAllProductByShopId(shopId);
        if (null != allProductByShopId){
            return success(allProductByShopId);
        }else{
            return failed();
        }
    }

    /**
     * 根据商铺的ID查询当前店铺所推荐的商品信息
     * @param shopId
     * @return
     */
    @GetMapping("/getAllShopRecommendProductByShopId")
    @ApiOperation(value = "店铺推荐商品信息", notes = "通过店铺主键查询店铺推荐商品的详细信息")
    public ResultData getAllShopRecommendProductByShopId(Long shopId){
        List<Product> recommendProductList = repastService.getAllShopRecommendProductByShopId(shopId);
        if (recommendProductList.size()>0){
            return success(recommendProductList);
        }else{
            return failed();
        }
    }



}
