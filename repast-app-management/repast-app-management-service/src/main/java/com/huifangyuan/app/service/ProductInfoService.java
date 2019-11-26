package com.huifangyuan.app.service;

import com.huifangyuan.app.base.BaseService;
import com.huifangyuan.app.domain.Product;
import com.huifangyuan.app.mapper.ProductInfoMapper;
import com.huifangyuan.app.mapper.ShopInfoMapper;
import com.huifangyuan.app.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductInfoService extends BaseService<Product> {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
        通用mapper方法
     **/
    public Mapper<Product> getMapper() {

        return null;

    }


    /**
     * 通过店铺id查询当前店铺的所有上线状态商品
     * @param shopId
     * @return
     */
    public List<ProductVo> getAllProductByShopId(Long shopId){
        List<ProductVo> allProductByShopId = productInfoMapper.getAllProductByShopId(shopId);
        if (allProductByShopId.size()>0){
            return allProductByShopId;
        }
        return null;
    }

    /**
     * 根据商铺的ID查询当前店铺所推荐的商品信息
     * @param shopId
     * @return
     */
    public List<Product> getAllShopRecommendProductByShopId(Long shopId){
        List<Product> recommendProductList = productInfoMapper.getAllShopRecommendProductByShopId(shopId);
        if (recommendProductList.size()>0){
            return recommendProductList;
        }
        return null;
    }















}
