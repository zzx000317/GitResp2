package middle.school.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
@Data
@TableName("middle_course")
@ApiModel("课程")
public class CourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty("课程ID")
	private Integer id;
	/**
	 * 课程名字
	 */
	@ApiModelProperty("课程名称")
	private String courseName;

}
