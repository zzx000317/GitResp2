package middle.school.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
@Data
@TableName("middle_question")
@ApiModel("问题反馈")
public class QuestionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty("ID")
	private Integer id;
	/**
	 *
	 */
	@ApiModelProperty("教师号")
	private Integer teacherId;
	/**
	 *
	 */
	@ApiModelProperty("课程ID")
	private Integer courseId;
	/**
	 *
	 */
	@ApiModelProperty("提问")
	private Integer question_ask;

	@ApiModelProperty("反馈")
	private Integer question_answer;

	@ApiModelProperty("家长ID")
	private Integer parentId;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date gmtModified;

}
