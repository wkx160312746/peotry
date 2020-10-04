package io.renren.modules.po_article.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.po_article.dao.PoArticleDao;
import io.renren.modules.po_article.entity.PoArticleEntity;
import io.renren.modules.po_article.service.PoArticleService;


@Service("poArticleService")
public class PoArticleServiceImpl extends ServiceImpl<PoArticleDao, PoArticleEntity> implements PoArticleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PoArticleEntity> page = this.page(
                new Query<PoArticleEntity>().getPage(params),
                new QueryWrapper<PoArticleEntity>()
        );

        return new PageUtils(page);
    }


}
