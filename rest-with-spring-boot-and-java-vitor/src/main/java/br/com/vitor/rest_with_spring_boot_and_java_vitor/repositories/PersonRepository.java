package br.com.vitor.rest_with_spring_boot_and_java_vitor.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vitor.rest_with_spring_boot_and_java_vitor.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
