import { Component} from '@angular/core';

@Component({
  selector: 'app-videos-list',
  templateUrl: './videos-list.component.html',
  styleUrls: ['./videos-list.component.css']
})
export class VideosListComponent {
  title="Videos List IS Working";
  students=['student 1','student 2', 'student 3'];

  constructor() { 
    
  }
  
  

}
