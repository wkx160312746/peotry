package io.renren.modules.po_article.controller;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.po_area.entity.PoAreaEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.po_article.entity.PoArticleEntity;
import io.renren.modules.po_article.service.PoArticleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:08:56
 */
@RestController
@RequestMapping("po_article/poarticle")
public class PoArticleController {

    @Autowired
    private PoArticleService poArticleService;


    @RequestMapping("/getHomePage")
    public R homePageList(){
        List<PoArticleEntity> hot =
                poArticleService.list(new QueryWrapper<PoArticleEntity>().orderByDesc("evaluate").last("limit 5"));
        Map<String, Object> map = new HashMap<>();
        map.put("title", "热门景点");
        map.put("content", hot);

        List<PoArticleEntity> cold =
                poArticleService.list(new QueryWrapper<PoArticleEntity>().orderByAsc("evaluate").last("limit 5"));
        Map<String, Object> map1 = new HashMap<>();
        map1.put("title", "冷门景点");
        map1.put("content", cold);
        List<Object> list = new ArrayList<>();
        list.add(map);
        list.add(map1);

        return R.ok().put("page", list);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = poArticleService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PoArticleEntity poArticle = poArticleService.getById(id);

        return R.ok().put("poArticle", poArticle);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PoArticleEntity poArticle){
        poArticleService.save(poArticle);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PoArticleEntity poArticle){
        ValidatorUtils.validateEntity(poArticle);
        poArticleService.updateById(poArticle);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        poArticleService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}
