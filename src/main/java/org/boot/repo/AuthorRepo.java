package org.boot.repo;


import org.boot.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface AuthorRepo extends JpaRepository<AuthorEntity, Serializable> {
}
