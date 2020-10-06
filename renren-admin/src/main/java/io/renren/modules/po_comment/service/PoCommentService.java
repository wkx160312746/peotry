package io.renren.modules.po_comment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.po_comment.entity.PoCommentEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:35:35
 */
public interface PoCommentService extends IService<PoCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R getListByArticleId(Long id);
}

