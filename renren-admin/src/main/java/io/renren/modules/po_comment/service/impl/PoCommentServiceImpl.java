package io.renren.modules.po_comment.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.po_comment.dao.PoCommentDao;
import io.renren.modules.po_comment.entity.PoCommentEntity;
import io.renren.modules.po_comment.service.PoCommentService;


@Service("poCommentService")
public class PoCommentServiceImpl extends ServiceImpl<PoCommentDao, PoCommentEntity> implements PoCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PoCommentEntity> page = this.page(
                new Query<PoCommentEntity>().getPage(params),
                new QueryWrapper<PoCommentEntity>()
        );

        return new PageUtils(page);
    }

}
