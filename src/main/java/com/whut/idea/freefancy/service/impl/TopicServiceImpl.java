package com.whut.idea.freefancy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whut.idea.freefancy.entity.Topic;
import com.whut.idea.freefancy.mapper.TopicMapper;
import com.whut.idea.freefancy.service.TopicService;
import org.springframework.stereotype.Service;

/**
 * TopicServiceImpl
 *
 * @author LiMing
 * @date 2021/11/9 15:43
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {
}
