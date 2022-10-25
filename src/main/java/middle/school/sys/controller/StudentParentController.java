package middle.school.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import middle.school.sys.entity.StudentParentEntity;
import middle.school.sys.service.StudentParentService;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.R;



/**
 * 
 *
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
@RestController
@RequestMapping("sys/studentparent")
public class StudentParentController {
    @Autowired
    private StudentParentService studentParentService;



}
