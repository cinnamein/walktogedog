package pupket.togedogserver.domain.match.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pupket.togedogserver.domain.board.entity.Board;
import pupket.togedogserver.domain.match.entity.Match;
import pupket.togedogserver.domain.user.entity.mate.Mate;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {

    Optional<Match> findByBoardAndMate(Board board, Mate mate);
}