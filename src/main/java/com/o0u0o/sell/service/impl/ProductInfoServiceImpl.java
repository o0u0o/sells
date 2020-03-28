package com.o0u0o.sell.service.impl;

import com.o0u0o.sell.config.UpYunConfig;
import com.o0u0o.sell.dataobject.ProductInfo;
import com.o0u0o.sell.dto.CartDTO;
import com.o0u0o.sell.enums.ProductStatusEnum;
import com.o0u0o.sell.enums.ResultEnum;
import com.o0u0o.sell.exception.SellException;
import com.o0u0o.sell.repository.ProductInfoRepository;
import com.o0u0o.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author aiuiot
 * @Date 2020/2/4 6:22 下午
 * @Descripton:
 **/
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository repository;

    @Autowired
    private UpYunConfig upYunConfig;

    @Override
    public ProductInfo findOne(String productId) {
        Optional<ProductInfo> productInfoOptional = repository.findById(productId);
        //如果查询出又内容
        productInfoOptional.ifPresent(e-> e.addImageHost(upYunConfig.getImageHost()));
        return productInfoOptional.orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode()).stream()
                .map(e -> e.addImageHost(upYunConfig.getImageHost()))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    /**
     * 增加库存
     * @param cartDTOList
     */
    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            //商品不存在
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //增加库存
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }

    /**
     * 减库存
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }
}
