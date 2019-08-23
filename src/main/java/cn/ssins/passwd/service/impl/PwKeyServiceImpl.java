package cn.ssins.passwd.service.impl;


import cn.ssins.passwd.entity.PwKey;
import cn.ssins.passwd.mapper.PwKeyMapper;
import cn.ssins.passwd.service.IPwKeyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PwKeyServiceImpl extends ServiceImpl<PwKeyMapper, PwKey> implements IPwKeyService {
}


