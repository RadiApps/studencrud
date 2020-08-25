import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app.routing.module';
import { AppComponent } from './app.component';


import { CountriesListComponent } from './countries-list/countries-list.component';
import { CreatePersonComponent } from './create-person/create-person.component';
import { PersonDetailsComponent } from './person-details/person-details.component';
import { PersonListComponent } from './person-list/person-list.component';
import { UpdatePersonComponent } from './update-person/update-person.component';
import { VideosListComponent } from './videos-list/videos-list.component';


import{ PersonService } from './services/person.service';
import{ UsersService } from './services/users.service';

import{ SummaryPipe } from './pipes/summary.pipes';





@NgModule({

  declarations: [
    AppComponent,
    CreatePersonComponent,
    PersonDetailsComponent,
    PersonListComponent,
    VideosListComponent,
    SummaryPipe,
    CountriesListComponent,
    UpdatePersonComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,    
    AppRoutingModule

  ],
  providers: [ PersonService,UsersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
