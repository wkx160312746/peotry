package io.renren.modules.po_area.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.po_area.entity.PoAreaEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-01 22:00:33
 */
public interface PoAreaService extends IService<PoAreaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

