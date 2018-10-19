package com.ifast.api.pojo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年4月26日 | Aron</small>
 */
@Data
public class UserLoginDTO {
    @NotBlank(message = "用户名不允许为空")
    private String uname;
    @NotBlank(message = "密码不允许为空")
    private String passwd;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
