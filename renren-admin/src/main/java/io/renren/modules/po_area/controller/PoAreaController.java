package io.renren.modules.po_area.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.validator.ValidatorUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.po_area.entity.PoAreaEntity;
import io.renren.modules.po_area.service.PoAreaService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-01 22:00:33
 */
@RestController
@RequestMapping("po_area/poarea")
public class PoAreaController {
    @Autowired
    private PoAreaService poAreaService;

    /**
     * 获取可选省份
     *
     * @return
     */
    @RequestMapping("/getProvinceList")
    public R getProvinceList() {
        List<PoAreaEntity> provinceList = poAreaService.list(new QueryWrapper<PoAreaEntity>().eq("level", "1"));
        return R.ok().put("list", provinceList);
    }

    /**
     * 通过省份id获取获取可选市
     *
     * @return
     */
    @RequestMapping("/getCityListByProvinceId")
    public R getProvinceList(@RequestParam Map<String, Object> params) {
        String provinceId = String.valueOf(params.get("provinceId"));
        if (StringUtils.isBlank(provinceId) || "null".equals(provinceId)) {
            return R.error("参数为空");
        }
        List<PoAreaEntity> cityList = poAreaService.list(new QueryWrapper<PoAreaEntity>()
                .eq( "parent_id", Integer.valueOf(provinceId)));
        return R.ok().put("list", cityList);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = poAreaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id) {
        PoAreaEntity poArea = poAreaService.getById(id);

        return R.ok().put("poArea", poArea);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PoAreaEntity poArea) {
        poAreaService.save(poArea);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PoAreaEntity poArea) {
        ValidatorUtils.validateEntity(poArea);
        poAreaService.updateById(poArea);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids) {
        poAreaService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
