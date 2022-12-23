package io.tm.phishingurldetectionservice.repository;

import io.tm.phishingurldetectionservice.model.PhishingURL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhishingURLRepository extends CrudRepository<PhishingURL, Long> {

    PhishingURL findByUrl(String url);

}
