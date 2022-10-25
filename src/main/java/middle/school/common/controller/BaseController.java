package middle.school.common.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunnoc
 */
public class BaseController {
    protected Map<String, Object> getDataTable(IPage<?> pageInfo) {
        Map<String, Object> data = new HashMap<>(7);
        data.put("page", pageInfo.getCurrent());
        data.put("per_page", pageInfo.getSize());
        data.put("list", pageInfo.getRecords());
        data.put("total", pageInfo.getTotal());
        return data;
    }

    protected Map<String, Object> getDataTable(List<?> list) {
        Map<String, Object> data = new HashMap<>(4);
        data.put("rows", list);
        data.put("total", list.size());
        return data;
    }
}
