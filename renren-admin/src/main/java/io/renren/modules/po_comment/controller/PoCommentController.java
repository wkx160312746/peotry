package io.renren.modules.po_comment.controller;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.po_area.entity.PoAreaEntity;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
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

    @Autowired
    private SysUserService sysUserService;

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
    public R info(@PathVariable("id") Long id){

        List<PoCommentEntity> commentEntityList = poCommentService.list(new QueryWrapper<PoCommentEntity>()
                .eq("article_id", id).eq("stutas","1"));
        List<Object> list = new ArrayList<>();

        for (PoCommentEntity poCommentEntity : commentEntityList) {
            Map<Object, Object> map = new HashMap<>();
            map.put("commentInfo",poCommentEntity);
            SysUserEntity sysUserEntity = sysUserService.getById(poCommentEntity.getUserId());
            System.out.println(sysUserEntity);
            map.put("username",sysUserEntity.getUsername());
            list.add(map);
        }
        return R.ok().put("content", commentEntityList);
    }

    @RequestMapping("/getListByArticleId/{id}")
    public R getListByArticleId(@PathVariable("id") Long id){
        return poCommentService.getListByArticleId(id);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PoCommentEntity poComment){
        poCommentService.save(poComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PoCommentEntity poComment){
        ValidatorUtils.validateEntity(poComment);
        poCommentService.updateById(poComment);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Map map){
        try {
            poCommentService.removeByMap(map);
        } catch (Exception e) {
            return R.error("未知异常,请联系管理员(评论)");
        }

        return R.ok();
    }

}
