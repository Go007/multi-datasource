package com.hong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 签约人信息
 * </p>
 *
 * @author wanghong
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("app_signer_info")
public class SignerInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 签约人名称
     */
    private String signerName;

    /**
     * 签约人类型:1-企业法人代表 2-企业实控人 3-企业实控人配偶 4-个人
     */
    private String signerType;

    /**
     * 签约人证件类型:1-身份证
     */
    private String signerCert;

    /**
     * 签约人证件号
     */
    private String signerIden;

    /**
     * 签约人手机号
     */
    private String signerPhone;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
