package cn.ssins.passwd.service.impl;

import cn.ssins.passwd.entity.PwRecord;
import cn.ssins.passwd.mapper.PwRecordMapper;
import cn.ssins.passwd.service.IPwRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PwRecordServiceImpl extends ServiceImpl<PwRecordMapper, PwRecord> implements IPwRecordService {
}
