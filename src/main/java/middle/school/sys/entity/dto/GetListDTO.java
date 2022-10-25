package middle.school.sys.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查询对象")
public class GetListDTO {

    @ApiModelProperty("当前页")
    private int page = 1;

    @ApiModelProperty("页面数量")
    private int per_page = 10;

    @ApiModelProperty("用户名称")
    private String username;

}
