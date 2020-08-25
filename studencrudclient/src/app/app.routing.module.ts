import { NgModule } from '@angular/core';
import { CountriesListComponent } from './countries-list/countries-list.component';
import { CreatePersonComponent } from './create-person/create-person.component';
import { PersonDetailsComponent } from './person-details/person-details.component';
import { PersonListComponent } from './person-list/person-list.component';
import { UpdatePersonComponent } from './update-person/update-person.component';
import { VideosListComponent } from './videos-list/videos-list.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
    { path: '', redirectTo: 'person', pathMatch: 'full' },
    { path: 'persons', component: PersonListComponent },
    { path: 'add', component: CreatePersonComponent },
    { path: 'update/:id', component: UpdatePersonComponent },
    { path: 'details/:id', component: PersonDetailsComponent },
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }