package com.cybercarjava.domain.notice.repository;

import com.cybercarjava.domain.notice.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
