package io.renren.modules.po_article.controller;

import java.io.File;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.po_area.entity.PoAreaEntity;
import net.bytebuddy.description.type.TypeList;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.po_article.entity.PoArticleEntity;
import io.renren.modules.po_article.service.PoArticleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;


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

    @Value("${upImgUrl}")
    private String upImgUrl;


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

        return R.ok().put("content", poArticle);
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
    @RequestMapping("/ed1")
    public Object ed1(@RequestParam("file") MultipartFile file) {
        System.out.println(11);
        return 22;
    }

     @RequestMapping("/editor")
    public Object editor(@RequestParam("file") MultipartFile file) {
        System.out.println("jinru");
        String fileName ;
        String saveFileName ;
        // 自定义返回信息
        Map<String,String> map = new HashMap<>();
        if (!file.isEmpty()) {
            //返回的是字节长度,1M=1024k=1048576字节 也就是if(fileSize<5*1048576)
            if (file.getSize() > (1048576 * 5)) {
                map.put("msg","文件太大，请上传小于5MB的");
                map.put("error","0");
                return map;
            }
            // 重新定义文件名 时间戳.xx格式
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            fileName = System.currentTimeMillis() + suffix;
            // 文件保存路径
            saveFileName = upImgUrl + "/article/" + fileName;
            File dest = new File(saveFileName);

            System.out.println(dest.getParentFile().getPath());
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
                map.put("success","1");
                map.put("url"," http://localhost:8080/poetry/img/article/" + fileName);
                return map;
            } catch (Exception e) {
                e.printStackTrace();
                map.put("error","0");
                map.put("msg", "上传错误");
                return map;
                //return ApiReturnUtil.error("上传失败"+e.getMessage());
            }
        }
        map.put("error","0");
        map.put("msg", "上传错误");
        return map;
    }

    /**
     * 获取分类的文章
     * @return
     */
    @RequestMapping("/getClassify")
    public R getClassify(){
        String[] name = {"","访名人","探画家","诗中景","画中游"};
        List<Object> list = new ArrayList<>();

        for (int i = 1; i <=4;i++){
            Map<Object, Object> map = new HashMap<>();
            List<PoArticleEntity> typeList = poArticleService.list(new QueryWrapper<PoArticleEntity>().eq("type",i));
            map.put("title", name[i]);
            map.put("content",typeList);
            list.add(map);
        }

        return R.ok().put("pageList",list);
    }

    /**
     * 获取分类的排行榜
     * @param params
     * @return
     */
    @RequestMapping("/getRankingList")
    public R getRankingList(@RequestBody Map<String, Object> params){
        String[] name = {"","访名人","探画家","诗中景","画中游"};
        Integer type = (Integer) params.get("type");
        System.out.println(type);
        List<PoArticleEntity> list =
                poArticleService.list(new QueryWrapper<PoArticleEntity>()
                        .eq("type", type).orderByDesc("evaluate").last("limit 10"));

        return R.ok().put("title",name[type]).put("content",list);
    }

    @RequestMapping("/upArticle")
    public R upHtml(@RequestBody Map<String,String> map){
        // 获取token
        String html = map.get("html");
        String title = map.get("title");
        String typeArticle = map.get("typeArticle");

//        // 富文本
//        PoArticleEntity article = new PoArticleEntity();
//        article.set
//        article.setArticle(html);
//        article.setPublishTime( new java.sql.Date(new java.util.Date().getTime()));
//        article.setTypeId(2);
//        int i = contentService.upArticle(article);
//        if(i > 0){
//            return new ResultUtil().setData("发布成功");
//        }
//        return new ResultUtil().setData("发布失败");
        return R.ok();
    }
}
