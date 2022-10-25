package middle.school.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("middle_parent")
@ApiModel("家长")
public class ParentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 学号
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty("家长ID")
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
	 * 住址
	 */
	@ApiModelProperty("住址")
	private String address;
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
	 * 年龄
	 */
	@ApiModelProperty("年龄")
	private Integer age;
	/**
	 * 密码
	 */
	@ApiModelProperty("密码")
	private String password;
	/**
	 * 手机号码
	 */
	@ApiModelProperty("手机号码")
	private String phone;

	/**
	 * 学生学号
	 */
	@ApiModelProperty("学生学号")
	private Integer studentId;

	@ApiModelProperty("学生姓名")
	@TableField(exist = false)
	private String studentName;
	/**
	 * 用户token
	 */
	@TableField(exist = false)
	private String token;
}
