import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AddCategoryComponent } from './add-category/add-category.component';
import { AddCourseComponent } from './add-course/add-course.component';
import { AddVideoComponent } from './add-video/add-video.component';
import { ViewVideoComponent } from './view-video/view-video.component';
import { ViewCategoryComponent } from './view-category/view-category.component';
import { ViewCourseComponent } from './view-course/view-course.component';
import { AdminSidebarComponent } from './admin-sidebar/admin-sidebar.component';
import { EditCategoryComponent } from './edit-category/edit-category.component';
import { EditCourseComponent } from './edit-course/edit-course.component';
import { EditVideoComponent } from './edit-video/edit-video.component';
import { LockedUserNotificationComponent } from './locked-user-notification/locked-user-notification.component';
import { UserLogComponent } from './user-log/user-log.component';
import { ReportsComponent } from './reports/reports.component';

const AdminComponents = [
  AddCategoryComponent,
  AdminDashboardComponent,
  AdminSidebarComponent,
  AddCategoryComponent,
  AddCourseComponent,
  AddVideoComponent,
  EditCategoryComponent,
  EditCourseComponent,
  EditVideoComponent,
  UserLogComponent,
  LockedUserNotificationComponent,
  ReportsComponent
]

@NgModule({
  declarations: [AdminDashboardComponent, AddCategoryComponent, AddCourseComponent, AddVideoComponent, ViewVideoComponent, ViewCategoryComponent, ViewCourseComponent, AdminSidebarComponent, EditCategoryComponent, EditCourseComponent, EditVideoComponent, LockedUserNotificationComponent, UserLogComponent, ReportsComponent],
  imports: [
    CommonModule,
    AdminComponents
  ],

  exports: [
    AdminComponents
  ]
})
export class AdminModule { }
