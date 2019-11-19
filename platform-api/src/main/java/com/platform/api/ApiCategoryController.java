package com.platform.api;
import com.platform.entity.CategoryVo;
import com.platform.service.ApiCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunset
 * @date 2019-11-17 19:38
 */
@RestController
@RequestMapping("api/category")
public class ApiCategoryController {
    @Autowired
    private ApiCategoryService categoryService;

    @RequestMapping("/findCategory")
    public List<CategoryVo> findCategory(){
        Map<String, Object> map = new HashMap<>();
        List<CategoryVo> categoryVos = categoryService.queryList(map);
        return categoryVos;
    }
}
