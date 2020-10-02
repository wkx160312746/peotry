package io.renren.modules.po_plan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.po_plan.entity.PoPlanEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:39:04
 */
public interface PoPlanService extends IService<PoPlanEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

