package pupket.togedogserver.domain.dog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pupket.togedogserver.domain.dog.entity.Dog;
import pupket.togedogserver.domain.user.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DogRepository extends JpaRepository<Dog, Long> {

    Optional<List<Dog>> findByUser(User findUser);

    Collection<Dog> findAllByUser(User user);

    Optional<Dog> findByUserAndDogId(User findUser, Long id);

    @Query("select m.breedName from DogBreed m ")
    List<String> findAllBreedData();
}
