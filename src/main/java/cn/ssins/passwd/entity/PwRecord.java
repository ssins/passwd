package cn.ssins.passwd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

@TableName("pw_record")
public class PwRecord extends Model<PwRecord> {
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    @TableField("key_id")
    private String keyId;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("host")
    private String host;

    @TableField("keywords")
    private String keywords;

    @TableField("hits")
    private Integer hits;

    public String getId() {
        return id;
    }

    public PwRecord setId(String id) {
        this.id = id;
        return this;
    }

    public String getKeyId() {
        return keyId;
    }

    public PwRecord setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public PwRecord setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PwRecord setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getHost() {
        return host;
    }

    public PwRecord setHost(String host) {
        this.host = host;
        return this;
    }

    public Integer getHits() {
        return hits;
    }

    public PwRecord setHits(Integer hits) {
        this.hits = hits;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public PwRecord setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
