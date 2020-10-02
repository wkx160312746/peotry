package io.renren.modules.po_collection.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
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

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("po_collection:pocollection:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = poCollectionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("po_collection:pocollection:info")
    public R info(@PathVariable("id") Long id){
        PoCollectionEntity poCollection = poCollectionService.getById(id);

        return R.ok().put("poCollection", poCollection);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("po_collection:pocollection:save")
    public R save(@RequestBody PoCollectionEntity poCollection){
        poCollectionService.save(poCollection);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("po_collection:pocollection:update")
    public R update(@RequestBody PoCollectionEntity poCollection){
        ValidatorUtils.validateEntity(poCollection);
        poCollectionService.updateById(poCollection);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("po_collection:pocollection:delete")
    public R delete(@RequestBody Long[] ids){
        poCollectionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
