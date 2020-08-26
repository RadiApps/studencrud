import { Component, OnInit } from '@angular/core';
import { Person } from '../model/Person';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonService } from '../services/person.service';
import { PersonType } from '../model/PersonType';

@Component({
  selector: 'person-details',
  templateUrl: './person-details.component.html',
  styleUrls: ['./person-details.component.css']
})
export class PersonDetailsComponent implements OnInit {

  id: number;
  person: Person;
  personType: PersonType;

  constructor(private route: ActivatedRoute,private router: Router,
    private personService: PersonService) { }
    gender : string;

  ngOnInit(): void {
    this.person = new Person();
    this.personType = new PersonType();
    this.id = this.route.snapshot.params['id'];
    
    this.personService.getPerson(this.id)
      .subscribe(data => {
        console.log(data)
        this.person = data;
        this.personType=this.person.personType;

        if(this.person.gender == 1)
          this.gender="Male";
        else if(this.person.gender == 2)
          this.gender="Female";
        else if(this.person.gender == 3)
          this.gender="Others";
        else
          this.gender="";

      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['persons']);
  }
}
