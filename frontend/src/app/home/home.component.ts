import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import {Valute} from '../model/Valute';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  valutes: Valute[];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getPublicContent().subscribe(
      data => {
        this.valutes = data;
      },
      err => {
        this.valutes = JSON.parse(err.error).message;
      }
    );
  }

}
