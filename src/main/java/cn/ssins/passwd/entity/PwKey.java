package cn.ssins.passwd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

@TableName("pw_key")
public class PwKey extends Model<PwKey> {
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    @TableField("public_key")
    private String publicKey;

    @TableField("valid")
    private String valid;

    public String getId() {
        return id;
    }

    public PwKey setId(String id) {
        this.id = id;
        return this;
    }

    public String getValid() {
        return valid;
    }

    public PwKey setValid(String valid) {
        this.valid = valid;
        return this;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public PwKey setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
