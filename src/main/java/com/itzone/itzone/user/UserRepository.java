package com.itzone.itzone.user;

import com.itzone.itzone.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
