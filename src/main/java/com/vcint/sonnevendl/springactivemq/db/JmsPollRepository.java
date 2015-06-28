package com.vcint.sonnevendl.springactivemq.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lorincsonnevend on 28/06/15.
 */
@Repository
interface JmsPollRepository extends CrudRepository<JmsPoll,Long> {


}
