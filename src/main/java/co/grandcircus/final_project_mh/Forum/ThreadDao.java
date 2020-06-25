package co.grandcircus.final_project_mh.Forum;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadDao extends JpaRepository<Thread, Long>{

	List<Thread> findByDiscussionId(Long Id);
}
