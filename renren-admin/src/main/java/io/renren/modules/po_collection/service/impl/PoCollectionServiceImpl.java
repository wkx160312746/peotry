package io.renren.modules.po_collection.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.po_collection.dao.PoCollectionDao;
import io.renren.modules.po_collection.entity.PoCollectionEntity;
import io.renren.modules.po_collection.service.PoCollectionService;


@Service("poCollectionService")
public class PoCollectionServiceImpl extends ServiceImpl<PoCollectionDao, PoCollectionEntity> implements PoCollectionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PoCollectionEntity> page = this.page(
                new Query<PoCollectionEntity>().getPage(params),
                new QueryWrapper<PoCollectionEntity>()
        );

        return new PageUtils(page);
    }

}
