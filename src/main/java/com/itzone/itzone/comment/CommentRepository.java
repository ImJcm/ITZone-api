package com.itzone.itzone.comment;

import com.itzone.itzone.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
