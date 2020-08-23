import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'countries-list',
  templateUrl: './countries-list.component.html',
  styleUrls: ['./countries-list.component.css']
})
export class CountriesListComponent implements OnInit {
  @Input("selectedCountry") currentCountry = "saudi";
  countries=[
    {name : 'Egypt',value: 'egypt' },
    {name : 'German',value: 'german' },
    {name : 'Austria',value: 'austria' },
    {name : 'Saudi Arabia',value: 'saudi' },
    {name : 'Morroco',value: 'morroco' }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
