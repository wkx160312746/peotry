package io.renren.modules.po_plan.controller;

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

import io.renren.modules.po_plan.entity.PoPlanEntity;
import io.renren.modules.po_plan.service.PoPlanService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:39:04
 */
@RestController
@RequestMapping("po_plan/poplan")
public class PoPlanController {
    @Autowired
    private PoPlanService poPlanService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = poPlanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PoPlanEntity poPlan = poPlanService.getById(id);

        return R.ok().put("poPlan", poPlan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PoPlanEntity poPlan){
        poPlanService.save(poPlan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("po_plan:poplan:update")
    public R update(@RequestBody PoPlanEntity poPlan){
        ValidatorUtils.validateEntity(poPlan);
        poPlanService.updateById(poPlan);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("po_plan:poplan:delete")
    public R delete(@RequestBody Long[] ids){
        poPlanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
