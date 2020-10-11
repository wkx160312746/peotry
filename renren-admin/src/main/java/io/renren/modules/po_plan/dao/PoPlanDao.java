package io.renren.modules.po_plan.dao;

import io.renren.modules.po_plan.entity.PoPlanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:39:04
 */
@Mapper
public interface PoPlanDao extends BaseMapper<PoPlanEntity> {
    List<Map> getList();
}
