package com.huifangyuan.app.service;


import com.huifangyuan.app.domain.Product;
import com.huifangyuan.app.domain.ProductCat;
import com.huifangyuan.app.fallback.RepastFallBackFactory;
import com.huifangyuan.app.vo.MemberProduct;
import com.huifangyuan.app.vo.ProductVo;
import com.huifangyuan.app.vo.ShopInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:40
 * @Description
 *      当使用feign进行传参的时候，如果是对象,包装类型,实体类...必须要使用@RequestBody，并且这个@RequestBody只能在该方法中出现一次
 *          ResultData selectUsersCondition(@RequestBody User user, @RequestBody UserInfo userInfo);---->错误
 *      当传递的参数是简单类型(String, Integer....8种基本类型+String)，必须要使用@RequestParam("")，这个@RequestPara注解可以出现多个
 *          ResultData selectUsersCondition(@RquestPara("username") String username, @RequestParam("age") Integer age);---->正确
 *
 **/
@FeignClient(value = "product-interface-provider", fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {

    /*-------------------------------------shopController-----------------------------------------------------*/
    @GetMapping("/getShopInfoByPrimaryKey")
    ShopInfoVo getShopInfoByPrimaryKey(@RequestParam("ShopId") Long ShopId);




    /**
     * 根据店铺的ID查询店铺的所有信息
     * Mrlin119
     * @param shopId
     * @return
     */
    @GetMapping("/getShopAllInfo")
    ShopInfoVo getShopAllInfoByShopId(@RequestParam("shopId") Long shopId);













    /*-------------------------------------shopController-----------------------------------------------------*/
    /*------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------productController-----------------------------------------------------*/


    /**
     * 根据店铺ID查询所有的商品
     * Mrlin119
     * @param shopId
     * @return
     */
    @GetMapping("/getAllProduct")
    List<ProductVo> getAllProductByShopId(@RequestParam("shopId") Long shopId);


    /**
     * 根据商铺的ID查询当前店铺所推荐的商品信息
     * Mrlin119
     * @param shopId
     * @return
     */
    @GetMapping("/getAllShopRecommendProductByShopId")
    List<Product> getAllShopRecommendProductByShopId(@RequestParam("shopId") Long shopId);









    /*-------------------------------------productController-----------------------------------------------------*/
    /*------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------searchController-----------------------------------------------------*/






















    /*-------------------------------------searchController-----------------------------------------------------*/












}
