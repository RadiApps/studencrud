import { Component } from '@angular/core';
import { PersonService } from '../services/person.service';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent {
  currentId= 3; 
  users: any[];
  postDescription =`Thank you for contacting us This is an automated response confirming the receipt of your ticket. One of our agents will 
                    get back to you as soon as possible
                    Ticket ID: AD-821-49025
                    Subject: 31300092809
                    Department: Support.kw`
  item={
    title: 'HP Screen',
    price: 2199.99,
    sold : 4531,
    rating:4.7655,
    date: new Date()
  }

  constructor(userService: UsersService ) {
      userService.getUsers().subscribe(res => {
        this.users = res;
        console.log(res);
      },err => {
        console.log(err);
      })
  }

  ngOnInit(): void {
  }


}
