package com.huifangyuan.app.mapper;

import com.huifangyuan.app.domain.Product;
import com.huifangyuan.app.vo.ProductVo;
import com.huifangyuan.app.vo.ShopInfoVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface ProductInfoMapper extends Mapper<Product> {

    List<Product> getProductByShopId(Long shopId);

    List<ProductVo> getAllProductByShopId(Long shopId);

    List<Product> getAllShopRecommendProductByShopId(Long shopId);

}
