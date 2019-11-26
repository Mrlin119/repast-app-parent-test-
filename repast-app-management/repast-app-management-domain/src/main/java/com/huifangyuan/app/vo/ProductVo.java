package com.huifangyuan.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.io.Serializable;

/**

/**
 * @PackageName:com.aaa.lee.app.vo
 * @ClassName:ProductVo
 * @Description:
 * @author: Mr.Lin
 * @Date 2019/11/22 9:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductVo implements Serializable {
    private Long id;
    private String pic;
    private String name;
    private String price;
    @Column(name = "promotion_price")
    private String promotionPrice;
    private String sale;
    private String description;
}
