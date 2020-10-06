package io.renren.modules.po_comment.service.impl;

import io.renren.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    @Autowired
    PoCommentDao poCommentDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PoCommentEntity> page = this.page(
                new Query<PoCommentEntity>().getPage(params),
                new QueryWrapper<PoCommentEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R getListByArticleId(Long id) {
        Map<String,Object> param = new HashMap<>();
        param.put("articleId",id);
        List<Map> list = poCommentDao.getListByArticleId(param);
        return R.ok().put("list",list);
    }

}
