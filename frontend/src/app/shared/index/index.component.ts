  
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { AuthenticateService } from 'src/app/authenticate.service';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  constructor(private router: Router,private as:AuthenticateService, public dialog : MatDialog) { }

  ngOnInit(): void {
  }
  
  reg(){
    this.dialog.open(RegisterComponent,{
      width: '800px',
    });
  }

}