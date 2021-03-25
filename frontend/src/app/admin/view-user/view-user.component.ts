import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/admin.service';
import { Router } from '@angular/router';
import {PageEvent} from '@angular/material/paginator';


@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.scss']
})
export class ViewUserComponent implements OnInit {

  users!: any;
  //search=""
  pageEvent!:PageEvent;
  searchInput!: string
  userBySearch: any;
  filteredArray: any[] = []
  defaultRecords: any = 5;

  constructor(private as: AdminService, private router: Router) {
   
    
    
   }
  // users = [{ name: "1" }, { name: "2" }, { name: "3" }, { name: "4" }, { name: "5" }, { name: "6" }, { name: "7" }, { name: "8" }, { name: "9" }, { name: "10" }, { name: "11" }, { name: "12" }, { name: "13" }];
  
  ngOnInit(): void {

    this.as.getUsers().subscribe((data) => {
      this.users = data;
      console.log("Get users");
      
      console.log(this.users[0].username);
      this.defprint()
    },
      (err) => {
        console.log('Error is:', err);

      })



  }
  
  
defprint(){
  this.filteredArray = this.users.slice(0, this.defaultRecords);
  console.log(this.filteredArray); 
 console.log("Inside oninit");
}


  getUser(event: any) {
    console.log(event);
    this.userBySearch = this.users.filter((x: any) => { return x.users == event });
    console.log(this.userBySearch);


  }

  // searchUsers(uname: String) {
  //   console.log(uname);

  
  //     this.userBySearch = this.users.filter((user: any) => user.username.toLowerCase().includes(uname));
    
  // }

  onPaginateChange(data: any) {
    console.log(data);
    this.filteredArray = this.users.slice(((data.pageSize)*data.pageIndex), (data.pageIndex+1)*data.pageSize);
  }
}
