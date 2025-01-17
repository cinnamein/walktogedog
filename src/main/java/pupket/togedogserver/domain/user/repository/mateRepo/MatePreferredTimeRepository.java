package pupket.togedogserver.domain.user.repository.mateRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import pupket.togedogserver.domain.user.entity.mate.Mate;
import pupket.togedogserver.domain.user.entity.mate.MatePreferredTime;

public interface MatePreferredTimeRepository extends JpaRepository<MatePreferredTime, Long> {
    void deleteAllByMate(Mate findMate);
}
