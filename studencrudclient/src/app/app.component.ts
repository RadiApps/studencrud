import { Component } from '@angular/core';
import { UsersService } from './services/users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedCountry = "egypt"
  title = 'studencrudclient';
  currentId : number;
  firstName='your first name';
  user_data={
    firstName:'your firstName',
    lastName: 'your lastName'
  }
  users: any[];
  constructor(userService: UsersService ) {
      userService.getUsers().subscribe(res => {
        this.users = res;
        console.log(res);
      },err => {
        console.log(err);
      })
  }

  handleBtnClick(e){
    // to uncall the upper events
    //e.stopPropagation();
    console.log(" Button Clicked",e)
  }
  handleDivClick(){
    alert(" Div Clicked");
    console.log("Div Clicked");
  }
  activeUser(id){
    this.currentId = id;
  }

  handleInput(){
    console.log(this.user_data.firstName);
    alert(this.user_data.firstName);
  }
}
