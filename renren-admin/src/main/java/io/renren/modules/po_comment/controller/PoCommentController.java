package io.renren.modules.po_comment.controller;

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

import io.renren.modules.po_comment.entity.PoCommentEntity;
import io.renren.modules.po_comment.service.PoCommentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:35:35
 */
@RestController
@RequestMapping("po_comment/pocomment")
public class PoCommentController {
    @Autowired
    private PoCommentService poCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = poCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("po_comment:pocomment:info")
    public R info(@PathVariable("id") Long id){
        PoCommentEntity poComment = poCommentService.getById(id);

        return R.ok().put("poComment", poComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("po_comment:pocomment:save")
    public R save(@RequestBody PoCommentEntity poComment){
        poCommentService.save(poComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("po_comment:pocomment:update")
    public R update(@RequestBody PoCommentEntity poComment){
        ValidatorUtils.validateEntity(poComment);
        poCommentService.updateById(poComment);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("po_comment:pocomment:delete")
    public R delete(@RequestBody Long[] ids){
        poCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
