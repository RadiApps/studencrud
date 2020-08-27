import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from '../model/Person';
import { PersonType } from '../model/PersonType';
import { PersonService } from '../services/person.service';
import { Router } from '@angular/router';


@Component({
  selector: 'person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {
  persons: Observable<Person[]>
  constructor(private personService: PersonService, 
    private router: Router ) {     

  }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(){
    this.persons = this.personService.getPersonsList();
  }
  deletePerson(id: number){
    if(confirm("Are you sure to delete this person!")){
      this.personService.deletePerson(id).subscribe(
        data => {
          console.log(data);
          this.reloadData(); 
        },error => {
          console.log(error);
        } )
    }
  }
  updatePerson(id: number,p: any){
    this.router.navigate(['update',id]);
  }

  personDetails(id: number){
    this.router.navigate(['details',id]);
  }

}
