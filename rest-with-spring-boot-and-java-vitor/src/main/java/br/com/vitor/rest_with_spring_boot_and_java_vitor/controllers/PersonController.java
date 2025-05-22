package br.com.vitor.rest_with_spring_boot_and_java_vitor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitor.rest_with_spring_boot_and_java_vitor.model.Person;
import br.com.vitor.rest_with_spring_boot_and_java_vitor.services.PersonServices;






@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;
    //private PersonService service = new PersonServices();

    @RequestMapping(value = "/{id}",
        method=RequestMethod.GET,
        produces= MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable(value= "id" )Long id){
        return service.findByID(id);
    }

    
      @RequestMapping(
        method=RequestMethod.GET,
        produces= MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAllPersons(){
        return service.findAll();
    }
    @RequestMapping(//value = "/create",
            method=RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE, 
            produces= MediaType.APPLICATION_JSON_VALUE
        )
        public Person create(@RequestBody Person person){
            return service.create(person);
        }

          @RequestMapping(
            method=RequestMethod.PUT,
            consumes= MediaType.APPLICATION_JSON_VALUE, 
            produces= MediaType.APPLICATION_JSON_VALUE
        )
        public Person update(@RequestBody Person person){
            return service.update(person);
        }


          @RequestMapping(value = "/{id}",
        method=RequestMethod.DELETE)    
        public void delete(@PathVariable(value= "id")Long id){
            service.delete(id);
        }
        
    }
    

    //  @RequestMapping(value = "/",
    //     method=RequestMethod.GET,
    //     produces= MediaType.APPLICATION_JSON_VALUE
    // )
    // public List<Person> findAllPersonsi(){
    //     return service.findAll();
    // }
    
  
