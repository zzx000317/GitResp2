package middle.school.notice.entity;

import com.baomidou.mybatisplus.annotation.*;
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
/*@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)*/
@TableName("middle_notice")
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 通知/作业
     */
    private String notice;

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
     * 父母ID
     */
    private Integer parentId;

    /**
     * 老师ID
     */
    private Integer teacherId;


    private Integer classId;


}
