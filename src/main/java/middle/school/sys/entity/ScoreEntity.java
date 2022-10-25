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
@TableName("middle_score")
@ApiModel("成绩")
public class ScoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty("成绩ID")
	private Integer id;
	/**
	 * 学生id
	 */
	@ApiModelProperty("学号")
	private Integer studentId;

	@ApiModelProperty("学生姓名")
	private String studentName;

	@ApiModelProperty("考试名称")
	private String exam;

	@ApiModelProperty("classID")
	private Integer classId;
	
	@ApiModelProperty("老师ID")
	private Integer teacherId;

	@ApiModelProperty("语文")
	private Double chineseScore;
	@ApiModelProperty("数学")
	private Double mathScore;
	@ApiModelProperty("英语")
	private Double englishScore;
	@ApiModelProperty("物理")
	private Double physicsScore;
	@ApiModelProperty("化学")
	private Double chemistryScore;
	@ApiModelProperty("生物")
	private Double biologyScore;
	@ApiModelProperty("政治")
	private Double politicsScore;
	@ApiModelProperty("历史")
	private Double historyScore;
	@ApiModelProperty("地理")
	private Double geographyScore;
	@ApiModelProperty("美术")
	private Double paintingScore;
	@ApiModelProperty("体育")
	private Double sportsScore;
	@ApiModelProperty("音乐")
	private Double musicScore;

	/*chineseScore
  mathScore 
  englistScore 
  physicsScore 
  chemistryScore 
  biologyScore 
  politicsScore 
  historyScore 
  geographyScore 
  paintingScore 
  sportsScore 
  musicScore */

}
