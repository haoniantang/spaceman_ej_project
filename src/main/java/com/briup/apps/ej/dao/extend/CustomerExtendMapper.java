package com.briup.apps.ej.dao.extend;


import com.briup.apps.ej.bean.vm.CustomerVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerExtendMapper {
    List<CustomerVM> queryBasic(
            @Param("customerId") Long customerId
    );
}
