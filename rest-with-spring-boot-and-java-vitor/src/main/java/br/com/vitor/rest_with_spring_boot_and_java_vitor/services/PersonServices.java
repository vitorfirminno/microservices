package br.com.vitor.rest_with_spring_boot_and_java_vitor.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vitor.rest_with_spring_boot_and_java_vitor.exceptions.ResourceNotFoundException;
import br.com.vitor.rest_with_spring_boot_and_java_vitor.model.Person;
import br.com.vitor.rest_with_spring_boot_and_java_vitor.repositories.PersonRepository;

@Service
public class PersonServices {
  
  
  private Logger logger = Logger.getLogger(PersonServices.class.getName());

  @Autowired
  PersonRepository repository;

  public List<Person> findAll(){
      logger.info("finding all Person");
    
   
    return repository.findAll();
  }


  public Person findByID(Long id){

    logger.info("Finding one Person");
 
    
    return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Records found for this ID!"));
  }

 

  public Person create(Person person){

    logger.info("Creating one person");

    return repository.save(person);
  }

  public Person update(Person person){
    logger.info("Updating one person");
    var entity = repository.findById(person.getId()).orElseThrow(()-> 
    new ResourceNotFoundException("No Records found for this ID!"));
    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setAddress(person.getLastName());
    entity.setGender(person.getGender());


    return repository.save(person);
    
  }

   public void delete(Long id){
    logger.info("Deleting one person!");

    var entity = repository.findById(id).orElseThrow(()-> 
    new ResourceNotFoundException("No Records found for this ID!"));
    
    repository.delete(entity);
  }

}

