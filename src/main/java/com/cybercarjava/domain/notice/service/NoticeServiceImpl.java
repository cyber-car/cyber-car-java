package com.cybercarjava.domain.notice.service;

import com.cybercarjava.domain.notice.dto.response.NoticeResponse;
import com.cybercarjava.domain.notice.model.Notice;
import com.cybercarjava.domain.notice.repository.NoticeRepository;
import com.cybercarjava.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Override
    public List<NoticeResponse> getListNotice(User user) {
        return null;
    }

    @Override
    public NoticeResponse getNotice(User user, Long noticeId) {
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(RuntimeException::new);
        // 예외처리는 추후 작성
        return NoticeResponse.builder().title(notice.getTitle()).content(notice.getContent()).build();
    }
}
