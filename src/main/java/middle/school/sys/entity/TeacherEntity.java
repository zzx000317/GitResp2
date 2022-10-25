package middle.school.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@TableName("middle_teacher")
@ApiModel("老师")
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TeacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 工号
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty("工号ID")
	private Integer id;
	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String username;
	/**
	 * 性别 0男 1女
	 */
	@ApiModelProperty("性别 0男 1女")
	private Integer sex;
	/**
	 * 地址
	 */
	@ApiModelProperty("地址")
	private String address;
	/**
	 * 手机号码
	 */
	@ApiModelProperty("手机号码")
	private String phone;
	/**
	 * 年龄
	 */
	@ApiModelProperty("年龄")
	private Integer age;
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
	/**
	 * 密码
	 */
	@ApiModelProperty("密码")
	private String password;

	/**
	 * 班级ID
	 */
//	@TableField(exist = false)
	@ApiModelProperty("班级ID")
	private Integer classId;

	/**
	 * 班级名称
	 */
	@TableField(exist = false)
	@ApiModelProperty("班级名称")
	private String className;

	/**
	 * 用户token
	 */
	@TableField(exist = false)
	private String token;
}
