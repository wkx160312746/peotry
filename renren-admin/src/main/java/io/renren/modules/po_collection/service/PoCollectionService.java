package io.renren.modules.po_collection.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.po_collection.entity.PoCollectionEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:33:55
 */
public interface PoCollectionService extends IService<PoCollectionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

