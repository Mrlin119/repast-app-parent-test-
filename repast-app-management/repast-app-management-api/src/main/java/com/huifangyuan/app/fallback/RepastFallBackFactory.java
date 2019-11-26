package com.huifangyuan.app.fallback;


import com.huifangyuan.app.domain.Product;
import com.huifangyuan.app.domain.ProductCat;
import com.huifangyuan.app.service.IRepastService;
import com.huifangyuan.app.vo.MemberProduct;
import com.huifangyuan.app.vo.ProductVo;
import com.huifangyuan.app.vo.ShopInfoVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:41
 * @Description
 **/
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {

    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService() {

            @Override
            public ShopInfoVo getShopInfoByPrimaryKey(Long ShopId) {
                System.out.println("进入根据主键查询商铺信息熔断方法");
                return null;
            }

            @Override
            public ShopInfoVo getShopAllInfoByShopId(Long shopId) {
                System.out.println("测试店铺信息熔断数据");
                return null;
            }

            @Override
            public List<ProductVo> getAllProductByShopId(Long shopId) {
                System.out.println("测试商品信息熔断数据");
                return null;
            }

            @Override
            public List<Product> getAllShopRecommendProductByShopId(Long shopId) {
                System.out.println("测试店铺推荐商品信息熔断数据");
                return null;
            }
        };
        return repastService;
    }
}
