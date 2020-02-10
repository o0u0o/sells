package com.o0u0o.sell.converter;

import com.o0u0o.sell.dataobject.OrderMaster;
import com.o0u0o.sell.dto.OrderDTO;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author aiuiot
 * @Date 2020/2/10 5:22 下午
 * @Descripton: 转换器 OrderMaster to OrderDTO
 **/
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
       OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
    }
}
