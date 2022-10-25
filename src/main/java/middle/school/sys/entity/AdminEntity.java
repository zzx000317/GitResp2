package middle.school.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("middle_admin")
@ApiModel("管理员")
public class AdminEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 学号
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty("ID")
	private Integer id;
	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String username;

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
	 * 手机号码
	 */
	@ApiModelProperty("手机号码")
	private String phone;



	/**
	 * 用户token
	 */
	@TableField(exist = false)
	private String token;
}
