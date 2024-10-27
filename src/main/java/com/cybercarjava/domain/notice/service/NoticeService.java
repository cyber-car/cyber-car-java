package com.cybercarjava.domain.notice.service;

import com.cybercarjava.domain.notice.dto.response.NoticeResponse;
import com.cybercarjava.domain.user.model.User;
import java.util.List;

public interface NoticeService {

    List<NoticeResponse> getListNotice(User user);

    NoticeResponse getNotice(User user, Long noticeId);
}
