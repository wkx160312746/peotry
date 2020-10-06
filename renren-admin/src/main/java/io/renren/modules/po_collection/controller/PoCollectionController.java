package io.renren.modules.po_collection.controller;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.po_area.entity.PoAreaEntity;
import io.renren.modules.po_article.entity.PoArticleEntity;
import io.renren.modules.po_article.service.PoArticleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.po_collection.entity.PoCollectionEntity;
import io.renren.modules.po_collection.service.PoCollectionService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:33:55
 */
@RestController
@RequestMapping("po_collection/pocollection")
public class PoCollectionController {
    @Autowired
    private PoCollectionService poCollectionService;

    @Autowired
    private PoArticleService poArticleService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = poCollectionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 根据用户id 查询收藏信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        List<PoCollectionEntity> List = poCollectionService.list(new QueryWrapper<PoCollectionEntity>().eq(
                "user_id", id));
        List<Long> acticleIdList = new ArrayList<Long>();

        for (PoCollectionEntity poCollectionEntity : List) {
            acticleIdList.add(poCollectionEntity.getArticleId());
        }
        Collection<PoArticleEntity> poArticleEntities = poArticleService.listByIds(acticleIdList);

        return R.ok().put("content", poArticleEntities);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PoCollectionEntity poCollection){
        poCollectionService.save(poCollection);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PoCollectionEntity poCollection){
        ValidatorUtils.validateEntity(poCollection);
        poCollectionService.updateById(poCollection);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Map map){
        poCollectionService.removeByMap(map);

        return R.ok();
    }

}
