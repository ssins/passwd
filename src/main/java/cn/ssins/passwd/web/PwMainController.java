package cn.ssins.passwd.web;

import cn.hextec.common.upms.ResultT;
import cn.ssins.passwd.entity.PwKey;
import cn.ssins.passwd.entity.PwRecord;
import cn.ssins.passwd.service.IPwKeyService;
import cn.ssins.passwd.service.IPwRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${adminPath}/main")
public class PwMainController {
    private final static Logger logger = LoggerFactory.getLogger(PwMainController.class);

    @Autowired
    IPwKeyService iPwKeyService;
    @Autowired
    IPwRecordService iPwRecordService;

    @ApiOperation(value = "获取一条用户名密码信息（优先度依据使用次数）")
    @RequestMapping(value = "getRecord", method = RequestMethod.POST)
    public ResultT<PwRecord> getRecord(@ApiParam(required = false, name = "keywords", value = "关键词") @RequestParam(required = false) String keywords,
                                       @ApiParam(required = false, name = "host", value = "域名") @RequestParam(required = false) String host) {
        QueryWrapper<PwRecord> queryWrapper = new QueryWrapper<PwRecord>();
        if (keywords != null) {
            queryWrapper.like("keywords", keywords);
        }
        if (host != null) {
            queryWrapper.like("host", host);
        }
        queryWrapper.orderByDesc("hits");
        PwRecord pwRecord = iPwRecordService.getOne(queryWrapper);
        if (pwRecord != null) {
            return ResultT.success(pwRecord);
        }
        return ResultT.ex("未查询到符合的记录");
    }

    @ApiOperation(value = "注册，提供公钥")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultT<Boolean> register(@ApiParam(name = "publicKey", value = "公钥") @RequestParam String publicKey) {
        PwKey pwKey = iPwKeyService.getOne(new QueryWrapper<PwKey>().eq("public_key", publicKey));
        if (pwKey != null) {
            return ResultT.ex("注册失败");
        }
        pwKey = new PwKey().setPublicKey(publicKey).setValid("1");
        return ResultT.success(iPwKeyService.save(pwKey));
    }

    @ApiOperation(value = "新增记录")
    @RequestMapping(value = "addRecord", method = RequestMethod.POST)
    public ResultT<Boolean> addRecord(@ApiParam(name = "publicKey", value = "公钥") @RequestParam String publicKey,
                                      @ApiParam(name = "host", value = "域名") @RequestParam String host,
                                      @ApiParam(name = "username", value = "用户名") @RequestParam String username,
                                      @ApiParam(name = "password", value = "密码") @RequestParam String password,
                                      @ApiParam(name = "keywords",value = "关键词")@RequestParam String keywords) {
        PwKey pwKey = iPwKeyService.getOne(new QueryWrapper<PwKey>().eq("public_key", publicKey));
        if (pwKey == null) {
            return ResultT.ex("用户不存在");
        }
        PwRecord pwRecord = new PwRecord().setKeyId(pwKey.getId()).setHost(host).setPassword(password).setUsername(username).setKeywords(keywords);
        return ResultT.success(iPwRecordService.save(pwRecord));
    }
}
