package middle.school.question.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2022-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("middle_question")
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("问题ID")
    private Integer id;

    /**
     * 问题反馈
     */
    @ApiModelProperty("问题反馈")
    private String questionAsk;

    /**
     * 问题回复
     */
    @ApiModelProperty("问题回复")
    private String questionAnswer;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    /**
     * 父母id
     */
    @ApiModelProperty("父母ID")
    private Integer parentId;

    /**
     * 老师id
     */
    @ApiModelProperty("老师ID")
    private Integer teacherId;

    /**
     * 反馈处理状态 0未处理 1已处理
     */
    @ApiModelProperty("反馈状态 0未处理 1已处理")
    private Boolean status;


}
