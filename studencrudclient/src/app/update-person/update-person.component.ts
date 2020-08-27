import { Component, OnInit } from '@angular/core';
import { Person } from '../model/Person';
import { PersonService } from '../services/person.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonType } from '../model/PersonType';

@Component({
  selector: 'update-person',
  templateUrl: './update-person.component.html',
  styleUrls: ['./update-person.component.css']
})
export class UpdatePersonComponent implements OnInit {

  id: number;
  person: Person;
  personType: PersonType;
  constructor(private route: ActivatedRoute,private router: Router,
    private personService: PersonService) { }

  ngOnInit(): void {
    debugger;
    this.person = new Person();
    this.personType=new PersonType();

    this.id = this.route.snapshot.params['id'];
    
    this.personService.getPerson(this.id)
      .subscribe(data => {
        debugger;
        console.log(data)
        
        this.person = data;    
        this.personType=this.person.personType;        

      }, error => console.log(error));
  }
  updatePerson() {
    this.person.personType=this.personType;
    this.personService.updatePerson(this.id, this.person)
      .subscribe(data => {
        console.log(data);       

        this.person = new Person();
        this.personType= new PersonType();

        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updatePerson();    
  }

  gotoList() {
    this.router.navigate(['/persons']);
  }

}
