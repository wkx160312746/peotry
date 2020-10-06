package io.renren.modules.po_comment.dao;

import io.renren.modules.po_comment.entity.PoCommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:35:35
 */
@Mapper
public interface PoCommentDao extends BaseMapper<PoCommentEntity> {

    List<Map> getListByArticleId(Map<String,Object> id);
}
