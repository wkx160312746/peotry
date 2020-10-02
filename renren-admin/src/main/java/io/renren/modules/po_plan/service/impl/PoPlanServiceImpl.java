package io.renren.modules.po_plan.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.po_plan.dao.PoPlanDao;
import io.renren.modules.po_plan.entity.PoPlanEntity;
import io.renren.modules.po_plan.service.PoPlanService;


@Service("poPlanService")
public class PoPlanServiceImpl extends ServiceImpl<PoPlanDao, PoPlanEntity> implements PoPlanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PoPlanEntity> page = this.page(
                new Query<PoPlanEntity>().getPage(params),
                new QueryWrapper<PoPlanEntity>()
        );

        return new PageUtils(page);
    }

}
