import { Component, OnInit } from '@angular/core';
import { Person } from '../model/Person';
import { PersonType } from '../model/PersonType';
import { PersonService } from '../services/person.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-person',
  templateUrl: './create-person.component.html',
  styleUrls: ['./create-person.component.css']
})
export class CreatePersonComponent implements OnInit {
  
  person: Person = new Person();
  personType: PersonType = new PersonType();
  submitted = false;


  constructor(private personService: PersonService,
      private router: Router) {

       }

  ngOnInit(): void {
  }

  newPerson(): void {
    this.submitted = false;
    this.person = new Person();
    this.personType = new PersonType();
  }

  save() {
    this.personService
    .createPerson(this.person).subscribe(data => {
      console.log(data)
      this.person = new Person();
      this.personType = new PersonType();
      this.gotoList();
    }, 
    error => console.log(error));
  }

   onSubmit() {
    this.submitted = true;
    this.save();    
  }
  gotoList(){
    this.router.navigate(['/persons']);
  }
}
