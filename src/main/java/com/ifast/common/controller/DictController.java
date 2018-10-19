package com.ifast.common.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.annotation.Log;
import com.ifast.common.base.AdminBaseController;
import com.ifast.common.domain.DictDO;
import com.ifast.common.service.DictService;
import com.ifast.common.utils.Result;
import com.ifast.common.utils.ValidUtil;
import com.ifast.sys.filter.XssFilter;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 数据字典
 * </pre>
 *
 * <small> 2018年3月23日 | Aron</small>
 */
@Controller
@RequestMapping("/common/sysDict")
public class DictController extends AdminBaseController {
    @Autowired
    private DictService sysDictService;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(XssFilter.class);

    @GetMapping()
    @RequiresPermissions("common:sysDict:sysDict")
    String sysDict() {
        return "common/sysDict/sysDict";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("common:sysDict:sysDict")
    public Result<Page<DictDO>> list(DictDO dictDTO) {
        Page<DictDO> page = sysDictService.selectPage(getPage(DictDO.class), sysDictService.convertToEntityWrapper("name", dictDTO.getName(), "type", dictDTO.getType()));
        return Result.ok(page);
    }

    @GetMapping("/add")
    @RequiresPermissions("common:sysDict:add")
    String add() {
        return "common/sysDict/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("common:sysDict:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        DictDO sysDict = sysDictService.selectById(id);
        model.addAttribute("sysDict", sysDict);
        return "common/sysDict/edit";
    }

    /**
     * 保存
     */
    @Log("添加数据字典")
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("common:sysDict:add")
    public Result<String> save(@Valid DictDO sysDict, BindingResult result) {
        if(result.hasErrors()){
            //如果没有通过,跳转提示
            Map<String, String> map = ValidUtil.getErrors(result);
            return Result.failMap(map);
        }else{
            //继续业务逻辑
            sysDictService.insert(sysDict);
            return Result.ok();
        }
    }
    /**
     * 修改
     */
    @Log("更新数据字典")
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("common:sysDict:edit")
    public Result<String> update(DictDO sysDict) {
        sysDictService.updateById(sysDict);
        return Result.ok();
    }

    /**
     * 删除
     */
    @Log("删除数据字典")
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("common:sysDict:remove")
    public Result<String> remove(Long id) {
        sysDictService.deleteById(id);
        return Result.ok();
    }

    /**
     * 删除
     */
    @Log("删除数据字典")
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("common:sysDict:batchRemove")
    public Result<String> remove(@RequestParam("ids[]") Long[] ids) {
        sysDictService.deleteBatchIds(Arrays.asList(ids));
        return Result.ok();
    }

    @GetMapping("/type")
    @ResponseBody
    public List<DictDO> listType() {
        return sysDictService.listType();
    }

    ;

    // 类别已经指定增加
    @GetMapping("/add/{type}/{description}")
    @RequiresPermissions("common:sysDict:add")
    String addD(Model model, @PathVariable("type") String type, @PathVariable("description") String description) {
        model.addAttribute("type", type);
        model.addAttribute("description", description);
        return "common/sysDict/add";
    }

    @ResponseBody
    @GetMapping("/list/{type}")
    public List<DictDO> listByType(@PathVariable("type") String type) {
        // 查询列表数据
        Map<String, Object> map = new HashMap<>(16);
        map.put("type", type);
        List<DictDO> dictList = sysDictService.selectByMap(map);
        return dictList;
    }
}
