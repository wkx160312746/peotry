package io.renren.modules.po_article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.po_article.entity.PoArticleEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:08:56
 */
public interface PoArticleService extends IService<PoArticleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getHomePage();
}

