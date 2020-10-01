package io.renren.modules.po_area.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.po_area.dao.PoAreaDao;
import io.renren.modules.po_area.entity.PoAreaEntity;
import io.renren.modules.po_area.service.PoAreaService;


@Service("poAreaService")
public class PoAreaServiceImpl extends ServiceImpl<PoAreaDao, PoAreaEntity> implements PoAreaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PoAreaEntity> page = this.page(
                new Query<PoAreaEntity>().getPage(params),
                new QueryWrapper<PoAreaEntity>()
        );

        return new PageUtils(page);
    }

}
